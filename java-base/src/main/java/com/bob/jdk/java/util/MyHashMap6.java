package com.bob.jdk.java.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class MyHashMap6<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {

  static final int DEFAULT_INITIAL_CAPACITY = 16; // 默认初始空间大小：2^4 = 16
  static final int MAXIMUM_CAPACITY = 1 << 30; // 默认最大存储空间：2的倍数 && 小于 1<<30
  static final float DEFAULT_LOAD_FACTOR = 0.75f; // 默认负载因子

  int threshold; // 下一次扩容的阈值
  final float loadFactor; // table的实际负载因子

  transient Entry[] table; // 底层数组容器
  transient int size; // 当前元素个数
  transient volatile int modCount; // 数组修改次数标志字段

  /**
   * 构造方法
   *
   * @param initialCapacity 初始容量
   * @param loadFactor      负载因子
   */
  public MyHashMap6(int initialCapacity, float loadFactor) {
    if (initialCapacity < 0)
      throw new IllegalArgumentException("Illegal initial capacity: " +
          initialCapacity);
    if (initialCapacity > MAXIMUM_CAPACITY)
      initialCapacity = MAXIMUM_CAPACITY;
    if (loadFactor <= 0 || Float.isNaN(loadFactor))
      throw new IllegalArgumentException("Illegal load factor: " + loadFactor);

    // Find a power of 2 >= initialCapacity
    int capacity = 1;
    while (capacity < initialCapacity)
      capacity <<= 1;

    this.loadFactor = loadFactor;
    threshold = (int) (capacity * loadFactor);
    table = new Entry[capacity];
    init();
  }

  public MyHashMap6(int initialCapacity) {
    this(initialCapacity, DEFAULT_LOAD_FACTOR);
  }

  /**
   * 这里比较有意思，没有传入默认参数调用原始构造方法，而是直接进行赋值初始化
   */
  public MyHashMap6() {
    this.loadFactor = DEFAULT_LOAD_FACTOR;
    threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    table = new Entry[DEFAULT_INITIAL_CAPACITY];
    init();
  }

  public MyHashMap6(Map<? extends K, ? extends V> m) {
    this(Math.max((int) (m.size() / DEFAULT_LOAD_FACTOR) + 1, DEFAULT_INITIAL_CAPACITY), DEFAULT_LOAD_FACTOR);
    putAllForCreate(m);
  }
  // 构造方法 结束

  // 内部工具类 开始

  /**
   * init方法，在初始化容器初始化之后，放入元素之前执行，继承了HashMap的子类可以腹泻此方法来进行额外的操作
   */
  void init() {
  }

  static int hash(int h) {
    h ^= (h >>> 20) ^ (h >>> 12);
    return h ^ (h >>> 7) ^ (h >>> 4);
  }

  /**
   * Returns index for hash code h.
   */
  static int indexFor(int h, int length) {
    return h & (length - 1);
  }
  // 内部工具类 结束

  //
  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public V get(Object key) {
    if (key == null)
      return getForNullKey();
    int hash = hash(key.hashCode());
    for (Entry<K, V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
      Object k;
      // hash值相等且 Key 相等（== || equals）就说明这是同一个对象
      if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
        return e.value;
    }
    return null;
  }

  /**
   * key为null的元素永远放在index为0的位置，但是index为0的位置不一定只有key为null的元素
   */
  private V getForNullKey() {
    for (Entry<K, V> e = table[0]; e != null; e = e.next) {
      if (e.key == null)
        return e.value;
    }
    return null;
  }

  @Override
  public boolean containsKey(Object key) {
    return getEntry(key) != null;
  }

  final Entry<K, V> getEntry(Object key) {
    int hash = (key == null) ? 0 : hash(key.hashCode());
    for (Entry<K, V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
      Object k;
      if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
        return e;
    }
    return null;
  }

  /**
   * 已经存在放回原来的值，不存在返回空
   */
  @Override
  public V put(K key, V value) {
    if (key == null)
      return putForNullKey(value);
    int hash = hash(key.hashCode());
    int i = indexFor(hash, table.length);
    for (Entry<K, V> e = table[i]; e != null; e = e.next) {
      Object k;
      if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
        V oldValue = e.value;
        e.value = value;
        e.recordAccess(this);
        return oldValue;
      }
    }

    modCount++;
    addEntry(hash, key, value, i);
    return null;
  }

  /**
   * null值特殊处理，永远放在index为0的位置
   *
   * @UseredBy put(K key, V value)
   */
  private V putForNullKey(V value) {
    for (Entry<K, V> e = table[0]; e != null; e = e.next) {
      if (e.key == null) {
        V oldValue = e.value;
        e.value = value;
        e.recordAccess(this);
        return oldValue;
      }
    }
    modCount++;
    addEntry(0, null, value, 0);
    return null;
  }

  private void putForCreate(K key, V value) {
    int hash = (key == null) ? 0 : hash(key.hashCode());
    int i = indexFor(hash, table.length);

    for (Entry<K, V> e = table[i]; e != null; e = e.next) {
      Object k;
      if (e.hash == hash &&
          ((k = e.key) == key || (key != null && key.equals(k)))) {
        e.value = value;
        return;
      }
    }

    createEntry(hash, key, value, i);
  }

  private void putAllForCreate(Map<? extends K, ? extends V> m) {
    for (Iterator<? extends Map.Entry<? extends K, ? extends V>> i = m.entrySet().iterator(); i.hasNext(); ) {
      Map.Entry<? extends K, ? extends V> e = i.next();
      putForCreate(e.getKey(), e.getValue());
    }
  }

  void resize(int newCapacity) {
    Entry[] oldTable = table;
    int oldCapacity = oldTable.length;
    if (oldCapacity == MAXIMUM_CAPACITY) {
      threshold = Integer.MAX_VALUE;
      return;
    }

    Entry[] newTable = new Entry[newCapacity];
    transfer(newTable);
    table = newTable;
    threshold = (int) (newCapacity * loadFactor);
  }

  /**
   * Transfers all entries from current table to newTable.
   */
  void transfer(Entry[] newTable) {
    Entry[] src = table;
    int newCapacity = newTable.length;
    for (int j = 0; j < src.length; j++) {
      Entry<K, V> e = src[j];
      if (e != null) {
        src[j] = null;
        do {
          Entry<K, V> next = e.next;
          int i = indexFor(e.hash, newCapacity);
          e.next = newTable[i];
          newTable[i] = e;
          e = next;
        } while (e != null);
      }
    }
  }

  @Override
  public void putAll(Map<? extends K, ? extends V> m) {
    int numKeysToBeAdded = m.size();
    if (numKeysToBeAdded == 0)
      return;

    if (numKeysToBeAdded > threshold) {
      int targetCapacity = (int) (numKeysToBeAdded / loadFactor + 1);
      if (targetCapacity > MAXIMUM_CAPACITY)
        targetCapacity = MAXIMUM_CAPACITY;
      int newCapacity = table.length;
      while (newCapacity < targetCapacity)
        newCapacity <<= 1;
      if (newCapacity > table.length)
        resize(newCapacity);
    }

    for (Iterator<? extends Map.Entry<? extends K, ? extends V>> i = m.entrySet().iterator(); i.hasNext(); ) {
      Map.Entry<? extends K, ? extends V> e = i.next();
      put(e.getKey(), e.getValue());
    }
  }

  @Override
  public V remove(Object key) {
    Entry<K, V> e = removeEntryForKey(key);
    return (e == null ? null : e.value);
  }

  final Entry<K, V> removeEntryForKey(Object key) {
    int hash = (key == null) ? 0 : hash(key.hashCode());
    int i = indexFor(hash, table.length);
    Entry<K, V> prev = table[i];
    Entry<K, V> e = prev;

    while (e != null) {
      Entry<K, V> next = e.next;
      Object k;
      if (e.hash == hash &&
          ((k = e.key) == key || (key != null && key.equals(k)))) {
        modCount++;
        size--;
        if (prev == e)
          table[i] = next;
        else
          prev.next = next;
        e.recordRemoval(this);
        return e;
      }
      prev = e;
      e = next;
    }

    return e;
  }

  /**
   * Special version of remove for EntrySet.
   */
  final Entry<K, V> removeMapping(Object o) {
    if (!(o instanceof Map.Entry))
      return null;

    Map.Entry<K, V> entry = (Map.Entry<K, V>) o;
    Object key = entry.getKey();
    int hash = (key == null) ? 0 : hash(key.hashCode());
    int i = indexFor(hash, table.length);
    Entry<K, V> prev = table[i];
    Entry<K, V> e = prev;

    while (e != null) {
      Entry<K, V> next = e.next;
      if (e.hash == hash && e.equals(entry)) {
        modCount++;
        size--;
        if (prev == e)
          table[i] = next;
        else
          prev.next = next;
        e.recordRemoval(this);
        return e;
      }
      prev = e;
      e = next;
    }

    return e;
  }

  /**
   * Removes all of the mappings from this map.
   * The map will be empty after this call returns.
   */
  @Override
  public void clear() {
    modCount++;
    Entry[] tab = table;
    for (int i = 0; i < tab.length; i++)
      tab[i] = null;
    size = 0;
  }

  @Override
  public boolean containsValue(Object value) {
    if (value == null)
      return containsNullValue();

    Entry[] tab = table;
    for (int i = 0; i < tab.length; i++)
      for (Entry e = tab[i]; e != null; e = e.next)
        if (value.equals(e.value))
          return true;
    return false;
  }

  private boolean containsNullValue() {
    Entry[] tab = table;
    for (int i = 0; i < tab.length; i++)
      for (Entry e = tab[i]; e != null; e = e.next)
        if (e.value == null)
          return true;
    return false;
  }

  @Override
  public Object clone() {
    MyHashMap6<K, V> result = null;
    try {
      result = (MyHashMap6<K, V>) super.clone();
    } catch (CloneNotSupportedException e) {
      // assert false;
    }
    result.table = new Entry[table.length];
    result.entrySet = null;
    result.modCount = 0;
    result.size = 0;
    result.init();
    result.putAllForCreate(this);

    return result;
  }

  static class Entry<K, V> implements Map.Entry<K, V> {
    final K key;      // Key的值不能改变
    V value;
    Entry<K, V> next; // 对下一个节点的引用，关联自身数据类型
    final int hash;   // 哈希值值依赖于Key，所以也是final

    Entry(int h, K k, V v, Entry<K, V> n) { // 构造函数
      value = v;
      next = n;
      key = k;
      hash = h;
    }

    @Override
    public final K getKey() {
      return key;
    }

    @Override
    public final V getValue() {
      return value;
    }

    @Override
    public final V setValue(V newValue) { // 赋新值，返旧值
      V oldValue = value;
      value = newValue;
      return oldValue;
    }

    @Override
    public final boolean equals(Object o) {
      if (!(o instanceof Map.Entry)) //先判断类型是否一致
        return false;
      Map.Entry e = (Map.Entry) o;
      Object k1 = getKey();
      Object k2 = e.getKey();
      if (k1 == k2 || (k1 != null && k1.equals(k2))) { // Key相等继续判断
        Object v1 = getValue();
        Object v2 = e.getValue();
        if (v1 == v2 || (v1 != null && v1.equals(v2))) // // Key相等且Value相等则两个Entry相等
          return true;
      }
      return false;
    }

    @Override
    public final int hashCode() { // hashCode是Key的hashCode和Value的hashCode的异或的结果
      return (key == null ? 0 : key.hashCode()) ^
          (value == null ? 0 : value.hashCode());
    }

    @Override
    public final String toString() { // 重写toString方法，是输出更清晰
      return getKey() + "=" + getValue();
    }

    /**
     * 当放入一个在HashMap中已经存在的Key时调用此方法
     */
    void recordAccess(MyHashMap6<K, V> m) {
    }

    /**
     * 当移除一个在HashMap中的Key时调用此方法
     */
    void recordRemoval(MyHashMap6<K, V> m) {
    }
  }

  void addEntry(int hash, K key, V value, int bucketIndex) {
    Entry<K, V> e = table[bucketIndex];
    table[bucketIndex] = new Entry<K, V>(hash, key, value, e);
    if (size++ >= threshold)
      resize(2 * table.length);
  }

  void createEntry(int hash, K key, V value, int bucketIndex) {
    Entry<K, V> e = table[bucketIndex];
    table[bucketIndex] = new Entry<K, V>(hash, key, value, e);
    size++;
  }


  private abstract class HashIterator<E> implements Iterator<E> {
    Entry<K, V> next;  // next entry to return
    int expectedModCount;  // For fast-fail
    int index;    // current slot
    Entry<K, V> current;  // current entry

    HashIterator() {
      expectedModCount = modCount;
      if (size > 0) { // advance to first entry
        Entry[] t = table;
        // map有元素,就定位数组索引到第一个不为null的位置,并赋给next
        while (index < t.length && (next = t[index++]) == null)
          ;
      }
    }

    @Override
    public final boolean hasNext() {
      return next != null;
    }

    final Entry<K, V> nextEntry() {
      if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
      Entry<K, V> e = next;
      if (e == null)
        throw new NoSuchElementException();

      // 判断下一个entry,如果为空,则继续搜索数组下一个索引位置
      if ((next = e.next) == null) {
        Entry[] t = table;
        while (index < t.length && (next = t[index++]) == null)
          ;
      }
      current = e;
      return e;
    }

    // 用迭代器执行删除操作(不会引起快速失败)：什么时候需要删除？
    @Override
    public void remove() {
      if (current == null)
        throw new IllegalStateException();
      if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
      Object k = current.key;
      current = null;
      MyHashMap6.this.removeEntryForKey(k);
      expectedModCount = modCount;
    }

  }

  // 为什么一个value一个是getKey？而没有统一使用get方法？
  private final class ValueIterator extends HashIterator<V> {
    public V next() {
      return nextEntry().value;
    }
  }

  private final class KeyIterator extends HashIterator<K> {
    public K next() {
      return nextEntry().getKey();
    }
  }

  private final class EntryIterator extends HashIterator<Map.Entry<K, V>> {
    public Map.Entry<K, V> next() {
      return nextEntry();
    }
  }

  // Subclass overrides these to alter behavior of views' iterator() method
  Iterator<K> newKeyIterator() {
    return new KeyIterator();
  }

  Iterator<V> newValueIterator() {
    return new ValueIterator();
  }

  Iterator<Map.Entry<K, V>> newEntryIterator() {
    return new EntryIterator();
  }


  // Views

  // Bob: 从 AbstractMap 拷贝而来
  transient volatile Set<K> keySet = null;

  @Override
  public Set<K> keySet() {
    Set<K> ks = keySet;
    return (ks != null ? ks : (keySet = new KeySet()));
  }

  private final class KeySet extends AbstractSet<K> {

    public Iterator<K> iterator() {
      return newKeyIterator();
    }

    public int size() {
      return size;
    }

    public boolean contains(Object o) {
      return containsKey(o);
    }

    public boolean remove(Object o) {
      return MyHashMap6.this.removeEntryForKey(o) != null;
    }

    public void clear() {
      MyHashMap6.this.clear();
    }
  }

  // Bob: 从 AbstractMap 拷贝而来
  transient volatile Collection<V> values = null;

  @Override
  public Collection<V> values() {
    Collection<V> vs = values;
    return (vs != null ? vs : (values = new Values()));
  }

  private final class Values extends AbstractCollection<V> {
    @Override
    public Iterator<V> iterator() {
      return newValueIterator();
    }

    @Override
    public int size() {
      return size;
    }

    @Override
    public boolean contains(Object o) {
      return containsValue(o);
    }

    @Override
    public void clear() {
      MyHashMap6.this.clear();
    }
  }

  private transient Set<Map.Entry<K, V>> entrySet = null;

  @Override
  public Set<Map.Entry<K, V>> entrySet() {
    return entrySet0();
  }

  private Set<Map.Entry<K, V>> entrySet0() {
    Set<Map.Entry<K, V>> es = entrySet;
    return es != null ? es : (entrySet = new EntrySet());
  }

  private final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
    public Iterator<Map.Entry<K, V>> iterator() {
      return newEntryIterator();
    }

    public boolean contains(Object o) {
      if (!(o instanceof Map.Entry))
        return false;
      Map.Entry<K, V> e = (Map.Entry<K, V>) o;
      Entry<K, V> candidate = getEntry(e.getKey());
      return candidate != null && candidate.equals(e);
    }

    public boolean remove(Object o) {
      return removeMapping(o) != null;
    }

    public int size() {
      return size;
    }

    public void clear() {
      MyHashMap6.this.clear();
    }
  }

  private void writeObject(java.io.ObjectOutputStream s) throws IOException {
    Iterator<Map.Entry<K, V>> i = (size > 0) ? entrySet0().iterator() : null;

    // Write out the threshold, loadfactor, and any hidden stuff
    s.defaultWriteObject();

    // Write out number of buckets
    s.writeInt(table.length);

    // Write out size (number of Mappings)
    s.writeInt(size);

    // Write out keys and values (alternating)
    if (i != null) {
      while (i.hasNext()) {
        Map.Entry<K, V> e = i.next();
        s.writeObject(e.getKey());
        s.writeObject(e.getValue());
      }
    }
  }

  private static final long serialVersionUID = 362498820763181265L;

  /**
   * Reconstitute the <tt>HashMap</tt> instance from a stream (i.e.,
   * deserialize it).
   */
  private void readObject(java.io.ObjectInputStream s)
      throws IOException, ClassNotFoundException {
    // Read in the threshold, loadfactor, and any hidden stuff
    s.defaultReadObject();

    // Read in number of buckets and allocate the bucket array;
    int numBuckets = s.readInt();
    table = new Entry[numBuckets];

    init();  // Give subclass a chance to do its thing.

    // Read in size (number of Mappings)
    int size = s.readInt();

    // Read the keys and values, and put the mappings in the HashMap
    for (int i = 0; i < size; i++) {
      K key = (K) s.readObject();
      V value = (V) s.readObject();
      putForCreate(key, value);
    }
  }

  // These methods are used when serializing HashSets
  int capacity() {
    return table.length;
  }

  float loadFactor() {
    return loadFactor;
  }
}


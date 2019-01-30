# HashMap 6
Map 接口中有一个内部接口 Entry，在AbstractMap中有两个内部实现 SimpleEntry 和 SimpleImmutableEntry 静态类，而且在 HashMap中又自己
实现了一个 Entry类，继承自原始的Map.Entry。那么：为什么要使用内部接口？ 抽象类中的实现类有什么用处？









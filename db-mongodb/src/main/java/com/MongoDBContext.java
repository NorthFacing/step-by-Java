package com;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Bob on 2016/11/9.
 */
public class MongoDBContext {

  protected final Logger logger = LoggerFactory.getLogger(MongoDBContext.class);

  private MongoClient mongoClient = null;
  private MongoDatabase mongoDatabase = null;
  private MongoCollection<Document> collection = null;
  private String host = "aliyun";
  private int port = 27017;
  private String database = "test";
  private String username = "";
  private String password = "";

  //初始化
  public void initialize() {
    try {

      // 连接到 mongodb 服务,不需要密码
      mongoClient = new MongoClient(host, port);
      // 连接到数据库
      mongoDatabase = mongoClient.getDatabase(database);
      logger.info("Connect to database: " + database + " successfully");

//      //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址 ，需要密码
//      //ServerAddress()两个参数分别为 服务器地址 和 端口
//      ServerAddress serverAddress = new ServerAddress(host, port);
//      List<ServerAddress> addrs = new ArrayList<>();
//      addrs.add(serverAddress);
//
//      //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
//      MongoCredential credential = MongoCredential.createScramSha1Credential(username, database, password.toCharArray());
//      List<MongoCredential> credentials = new ArrayList<>();
//      credentials.add(credential);
//
//      //通过连接认证获取MongoDB连接
//      mongoClient = new MongoClient(addrs, credentials);
//      //连接到数据库
//      mongoDatabase = mongoClient.getDatabase(database);

      logger.info("Connect to database: " + database + " successfully");
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
  }

  //插入数据
  public void insertOne(String coll, Document document) {
    try {
      collection = mongoDatabase.getCollection(coll);
      logger.debug("集合:" + coll + "选择成功");
      collection.insertOne(document);
      logger.debug(coll + "插入数据选择成功：\n" + document.toJson());
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }

  }

  //检索所有文档

  /**
   * 1. 获取迭代器FindIterable<Document>
   * 2. 获取游标MongoCursor<Document>
   * 3. 通过游标遍历检索出的文档集合
   */
  // TODO
  public void findAll(String coll) {
    try {
      collection = mongoDatabase.getCollection(coll);
      FindIterable<Document> findIterable = collection.find();
      MongoCursor<Document> mongoCursor = findIterable.iterator();
      while (mongoCursor.hasNext()) {
        System.out.println(mongoCursor.next());
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
  }

  public void dispose() {
    mongoClient.close();
  }

}

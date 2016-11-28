package com;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bob on 2016/11/28.
 */
public class MongodbContext {

  final static Logger logger = LoggerFactory.getLogger(MongodbContext.class);

  private MongoClient mongoClient = null;
  private MongoDatabase mongoDatabase = null;

  //初始化本地环境
  public void initialize(String host, int port, String database) {
    try {
      // 连接到 mongodb 服务,不需要密码
      mongoClient = new MongoClient(host, port);
      // 连接到数据库
      mongoDatabase = mongoClient.getDatabase(database);
      logger.info("Connect to database: " + database + " successfully");
    } catch (Exception e) {
      logger.error(e.getClass().getName() + ": " + e.getMessage());
    }
  }

  //初始化测试环境
  public void initializeWithPass(String host, int port, String database, String username, String password) {
    try {
      //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址 ，需要密码
      //ServerAddress()两个参数分别为 服务器地址 和 端口
      ServerAddress serverAddress = new ServerAddress(host, port);
      List<ServerAddress> addrs = new ArrayList<>();
      addrs.add(serverAddress);

      //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
      MongoCredential credential = MongoCredential.createScramSha1Credential(username, database, password.toCharArray());
      List<MongoCredential> credentials = new ArrayList<>();
      credentials.add(credential);

      //通过连接认证获取MongoDB连接
      mongoClient = new MongoClient(addrs, credentials);
      //连接到数据库
      mongoDatabase = mongoClient.getDatabase(database);

      logger.info("Connect to database: " + database + " successfully");
    } catch (Exception e) {
      logger.error(e.getClass().getName() + ": " + e.getMessage());
    }
  }

  public MongoCollection<Document> getCollection(String name) {
    return mongoDatabase.getCollection(name);
  }

  public static void main(String[] args) {
    // 使用范例
    MongodbContext myContext = new MongodbContext();
    myContext.initialize("aliyun", 27017, "test");
    MongodbContext testContext = new MongodbContext();
    testContext.initializeWithPass("114.55.143.28", 27017, "official", "bao", "12345678");
  }

}

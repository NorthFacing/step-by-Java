package com;

import org.bson.Document;

/**
 * Created by Bob on 2016/11/9.
 */
public class Demo {
  public static void main(String[] args) {
    MongoDBContext context = new MongoDBContext();
    context.initialize();

    String message = "{\"title\":\"MongoDB 教程\",\"description\":\"MongoDB 是一个 Nosql 数据库\",\"by\":\"菜鸟教程\",\"url\":\"http://www.runoob.com\",\"tags\":[\"mongodb\",\"database\",\"NoSQL\"],\"likes\":100}";
    Document document = Document.parse(message);

    context.insertOne("devinfo", document);
  }
}

package com;

import com.mongodb.BulkWriteError;
import com.mongodb.BulkWriteException;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.DeleteOneModel;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.UpdateOneModel;
import com.mongodb.client.model.WriteModel;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Bob on 2016/11/9.
 */
public class BulkWriteDemo {

  final static Logger logger = LoggerFactory.getLogger(MongodbContext.class);

  public static void main(String[] args) {
    // 初始化
    MongodbContext myContext = new MongodbContext();
    myContext.initialize("aliyun", 27017, "test");

    MongoCollection<Document> collection = myContext.getCollection("bulkWrite");

    // 清空
    collection.drop();
    assert !collection.find().iterator().hasNext();

    // 插入原始数据
    List<Document> documents = Arrays.asList(
        Document.parse("{ \"_id\" : 1, \"char\" : \"Brisbane\", \"class\" : \"monk\", \"lvl\" : 4 }"),
        Document.parse("{ \"_id\" : 2, \"char\" : \"Eldon\", \"class\" : \"alchemist\", \"lvl\" : 3 }"),
        Document.parse("{ \"_id\" : 3, \"char\" : \"Meldane\", \"class\" : \"ranger\", \"lvl\" : 3 }")
    );
    collection.insertMany(documents);

    // 查询
    logger.debug("当前数据：");
    MongoCursor<Document> iterator = collection.find().iterator();
    while (iterator.hasNext()) {
      logger.debug(iterator.next().toJson());
    }

    // 新增
    Document insertDocument = new Document("_id", 4).append("char", "Dithras").append("class", "barbarian").append("lvl", 4);
    InsertOneModel<Document> insertOneModel = new InsertOneModel<>(insertDocument);
    // 修改
    Document updateFilterDocument = new Document("char", "Eldon");
    Document updateDocument = new Document("$set", new Document("status", "Critical Injury"));
    UpdateOneModel<Document> updateOneModel = new UpdateOneModel<>(updateFilterDocument, updateDocument);
    // 删除
    Document deleteFilterDocument = new Document("char", "Brisbane");
    DeleteOneModel<Document> deleteOneModel = new DeleteOneModel<>(deleteFilterDocument);
    // 替换
    Document replaceFilterDocument = new Document("char", "Meldane");
    Document replaceDocument = new Document("char", "Tanys").append("class", "oracle").append("lvl", 4);
    ReplaceOneModel<Document> replaceOneModel = new ReplaceOneModel<>(replaceFilterDocument, replaceDocument);

    List<WriteModel<Document>> bulkList = Arrays.asList(insertOneModel, updateOneModel, deleteOneModel, replaceOneModel);

    BulkWriteResult bulkWriteResult = null;
    try {
      bulkWriteResult = collection.bulkWrite(bulkList);
    } catch (BulkWriteException e) {
      List<BulkWriteError> bulkWriteErrors = e.getWriteErrors();
      for (BulkWriteError bulkWriteError : bulkWriteErrors) {
        int failedIndex = bulkWriteError.getIndex();
        logger.error("Failed record: " + failedIndex + "-> " + bulkList.get(failedIndex));
      }
    }
    logger.info("bulkWriteResult:" + bulkWriteResult);

    logger.debug("当前数据：");
    MongoCursor<Document> iterator2 = collection.find().iterator();
    while (iterator2.hasNext()) {
      logger.debug(iterator2.next().toJson());
    }

  }
}

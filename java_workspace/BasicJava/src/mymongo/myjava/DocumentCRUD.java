package mymongo.myjava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class DocumentCRUD {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		System.out.println(mongoClient);
		MongoDatabase database = mongoClient.getDatabase("java_db");
		System.out.println(database);

//		database.createCollection("java_col");
		MongoCollection<Document> collection = database.getCollection("java_col");
		System.out.println(collection);

		Document user1 = new Document("_id", 1) // �ߺ� ������ ���� �ȵǵ��� ����
				.append("userid", "mongo").append("name", "����").append("gender", "��").append("addr", "����");
		System.out.println(user1);

		Document user2 = new Document("_id", 2) // �ߺ� ������ ���� �ȵǵ��� ����
				.append("userid", "java").append("name", "�ڹ�").append("gender", "��").append("addr", "���");
		System.out.println(user2);

		Document user3 = new Document("_id", 3) // �ߺ� ������ ���� �ȵǵ��� ����
				.append("userid", "springboot").append("name", "��Ʈ").append("gender", "��").append("addr", "����");
		System.out.println(user3);

		List<Document> userList = new ArrayList<>();
		userList.add(user2);
		userList.add(user3);

		try {
			collection.insertOne(user1);
			collection.insertMany(userList);
		} catch (MongoException ex) {
			System.out.println(ex.getCode() + " " + ex.getMessage());
//			if (ex.getCode() == 11000) {
//				System.out.println("�ߺ��� User �Դϴ�!");
//			}
		}
		
		/* find() ����� ArrayList�� ������ �ִ� ��� */
		List<Document> resultList = new ArrayList<>();
		
		// userid�� springboot�� �͸� ��������
		Document query = new Document("userid", "springboot");
		collection.find(query).into(resultList);
		
		for(Document document : resultList) {
			System.out.println(document);
			System.out.println(document.getString("userid") + " " + document.getString("name"));
		}

		// updateOne() ���
		collection.updateOne(Filters.eq("userid","mongo"), Updates.set("addr", "���� ������"));

		// deleteOne() ���
		Document query2 = new Document("addr", "����");
		collection.deleteOne(query2);
		
		/* find() ����� FindIterable�� ������ �ִ� ��� */
		FindIterable<Document> iterable = collection.find(Filters.eq("gender","��"));
		// FFindIterable�� Iterator�� ��ȯ
		Iterator<Document> iter = iterable.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}

}

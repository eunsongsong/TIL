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

		Document user1 = new Document("_id", 1) // 중복 데이터 삽입 안되도록 설정
				.append("userid", "mongo").append("name", "몽고").append("gender", "여").append("addr", "서울");
		System.out.println(user1);

		Document user2 = new Document("_id", 2) // 중복 데이터 삽입 안되도록 설정
				.append("userid", "java").append("name", "자바").append("gender", "여").append("addr", "경기");
		System.out.println(user2);

		Document user3 = new Document("_id", 3) // 중복 데이터 삽입 안되도록 설정
				.append("userid", "springboot").append("name", "부트").append("gender", "남").append("addr", "대전");
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
//				System.out.println("중복된 User 입니다!");
//			}
		}
		
		/* find() 결과를 ArrayList에 저장해 주는 경우 */
		List<Document> resultList = new ArrayList<>();
		
		// userid가 springboot인 것만 가져오기
		Document query = new Document("userid", "springboot");
		collection.find(query).into(resultList);
		
		for(Document document : resultList) {
			System.out.println(document);
			System.out.println(document.getString("userid") + " " + document.getString("name"));
		}

		// updateOne() 사용
		collection.updateOne(Filters.eq("userid","mongo"), Updates.set("addr", "서울 강동구"));

		// deleteOne() 사용
		Document query2 = new Document("addr", "대전");
		collection.deleteOne(query2);
		
		/* find() 결과를 FindIterable에 저장해 주는 경우 */
		FindIterable<Document> iterable = collection.find(Filters.eq("gender","여"));
		// FFindIterable을 Iterator로 변환
		Iterator<Document> iter = iterable.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}

}

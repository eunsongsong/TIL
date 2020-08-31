package mymongo.myjava.zips;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.InsertOneModel;

public class ZipsJsonToDB {
	public static void main(String[] args) {
		MongoClient client = new MongoClient("localhost", 27017);
		System.out.println(client);
		MongoDatabase database = client.getDatabase("zips_db");
		System.out.println(database);
		MongoCollection<Document> collection = database.getCollection("zips_col");
		System.out.println(collection);

		
		int count = 0;
		int batch = 1000;

		List<InsertOneModel<Document>> docs = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("zip.json"));
			String line;
		      while ((line = br.readLine()) != null) {
		         docs.add(new InsertOneModel<>(Document.parse(line)));
		         count++;
		         if (count == batch) {
		        	 System.out.println(batch + "건 쓰기 완료");
		           collection.bulkWrite(docs, new BulkWriteOptions().ordered(false));
		           docs.clear();
		           count = 0;
		        }
		    }
		      if (count > 0) {
				   collection.bulkWrite(docs, new BulkWriteOptions().ordered(false));
				}  
		      br.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
//		try (BufferedReader br = new BufferedReader(new FileReader("zipss.json"))) {
//		      String line;
//		      while ((line = br.readLine()) != null) {
//		         docs.add(new InsertOneModel<>(Document.parse(line)));
//		         count++;
//		         if (count == batch) {
//		           collection.bulkWrite(docs, new BulkWriteOptions().ordered(false));
//		           docs.clear();
//		           count = 0;
//		        }
//		    }
//		}

		
	}
}

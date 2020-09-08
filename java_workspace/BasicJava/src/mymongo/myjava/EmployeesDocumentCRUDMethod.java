package mymongo.myjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class EmployeesDocumentCRUDMethod {
	MongoCollection<Document> collection;
	
	public EmployeesDocumentCRUDMethod() {
		MongoClient mongoClient = new MongoClient("localhost",27017);
		MongoDatabase database = mongoClient.getDatabase("java_db");
		collection = database.getCollection("employees");
		
	}
	
	public void insert() {
		Document employee = new Document("_id",10)
			    .append("first_name", "Joe")
			    .append("last_name", "Smith")
			    .append("title", "Java Developer")
			    .append("years_of_service", 3)
			    .append("skills", Arrays.asList("java", "spring", "mongodb"))
			    .append("manager", new Document()
			                           .append("first_name", "Sally")
			                           .append("last_name", "Johanson"));
		Document employee2 = new Document("_id",20)
			    .append("first_name", "John")
			    .append("last_name", "Smith")
			    .append("title", "Java Developer")
			    .append("years_of_service", 3)
			    .append("skills", Arrays.asList("javascript", "spring", "mongodb"))
			    .append("manager", new Document()
			                           .append("first_name", "Sally")
			                           .append("last_name", "Johanson"));
		Document employee3 = new Document("_id",30)
			    .append("first_name", "Jane")
			    .append("last_name", "Doe")
			    .append("title", "Python Developer")
			    .append("years_of_service", 2)
			    .append("skills", Arrays.asList("python", "ai", "machine learning"))
			    .append("manager", new Document()
			                           .append("first_name", "Sally")
			                           .append("last_name", "Johanson"));
		
		try {
			collection.insertOne(employee);
			
			List<Document> list = new ArrayList<>();
			list.add(employee2);
			list.add(employee3);
			
			collection.insertMany(list);
		}catch(MongoException ex) {
			//if(ex.getCode() == 11000) {
				System.out.println(ex.getMessage());
			//}
		}
	}
	
	public void find_filter() {
		System.out.println("1111 =======> find using filter query");

		Document query = new Document("last_name", "Smith");
		List<Document> results = new ArrayList<>();
		collection.find(query).into(results);
		
		for (Document document : results) {
			System.out.println(document);
		}
		/*
		 * {
			  "$or": [
			    { "first_name": "Joe" },
			    { "last_name":"Smith" }
			  ]
			}
		 */
		
		System.out.println("2222 =======> find using filter query");
	
		Document query2 = 
				  new Document("$or", Arrays.asList(
				      new Document("last_name", "Doe"),
				      new Document("first_name", "John")));
		List<Document> results2 = new ArrayList<>();
		collection.find(query2).into(results2);
		
		for (Document document : results2) {
			System.out.println(document);
		}
	}
	
	public void update() {
		/*
		 * {
			  "skills": { 
			    $elemMatch:  { 
			      "$eq": "spring"
			    }
			  }
			}
			 
			{
			  "$push": { 
			    "skills": "security"
			  }
			}
		 */
		Document query3 = new Document(
				  "skills",
				  new Document(
				    "$elemMatch",
				    new Document("$eq", "spring")));
		Document update = new Document(
				  "$push",
				  new Document("skills", "security"));
		collection.updateMany(query3, update);
		
	}
	
	public void find() {
		System.out.println("3333=======> find all query");

		List<Document> results3 = new ArrayList<>();
		collection.find().into(results3);
		
		for (Document document : results3) {
			System.out.println(document);
		}
	}
	
	public void delete() {
		Document query4 = new Document(
				  "years_of_service", 
				  new Document("$lt", 3));
		collection.deleteMany(query4);
	}
	
	public static void main(String[] args) {
		EmployeesDocumentCRUDMethod crud = new EmployeesDocumentCRUDMethod();
		crud.insert();
		crud.find_filter();
//		crud.update();
//		crud.find();
		crud.delete();
		crud.find();
	}
	
	
	public Boolean databaseFound(String databaseName){
	    MongoClient mongoClient = new MongoClient(); //Maybe replace it with an already existing client
	    MongoCursor<String> dbsCursor = mongoClient.listDatabaseNames().iterator();
	    while(dbsCursor.hasNext()) {
	        if(dbsCursor.next().equals(databaseName))
	            return true;
	    }
	    return false;
	}
}

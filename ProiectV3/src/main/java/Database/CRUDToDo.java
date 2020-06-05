package main.java.Database;

import com.mongodb.client.*;
import com.mongodb.client.model.InsertManyOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public abstract class CRUDToDo {

    public static void createToDo(String content, boolean checked){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase sameples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = sameples.getCollection("ToDo");

            insertOneDocument(colectie, content, checked);
        }
    }

    public static void recreateDBToDo( int nr){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase sameples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = sameples.getCollection("ToDo");

            insertManyDocuments(colectie, nr);
        }
    }

    private static void insertOneDocument(MongoCollection<Document> colectie, String content, boolean checked) {
        colectie.insertOne(generateNewToDo(content, checked));
        System.out.println("One ToDo inserted.");
    }

    private static void insertManyDocuments(MongoCollection<Document> colectie, int nr) {
        List<Document> vector = new ArrayList<>();
        for (int classId = 0; classId < nr; classId++) {
            vector.add(generateNewToDo( "New ToDo" + String.valueOf(classId), false));
        }

        colectie.insertMany(vector, new InsertManyOptions().ordered(false));
        System.out.println( Integer.valueOf(nr) + " ToDos inserted.");
    }

    private static Document generateNewToDo(String content, boolean checked) {
        return new Document("_id", new ObjectId()).append("content", content).append("checked", checked);
    }

    public static void readAllToDo() {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("ToDo");


            // find a list of documents and iterate throw it using an iterator.
            FindIterable<Document> iterable = colectie.find();
            MongoCursor<Document> cursor = iterable.iterator();
            System.out.println("ToDo list with a cursor: ");
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        }
    }

    public static MongoCollection<Document> returnAllToDo() {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("ToDo");
            return colectie;
        }
    }

    public static void updateToDo( String StoUpdate, boolean BtoUpdate, String SupdateWith, boolean BupdateWith){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("ToDo");

            // update one document
            Bson filter = and (eq("content", StoUpdate), eq("checked", BtoUpdate));
            Bson updateOperation1 = set("content", SupdateWith);
            Bson updateOperation2 = set("checked", BupdateWith);
            ArrayList<Bson> vector = new ArrayList<>();
            vector.add(updateOperation1);
            vector.add(updateOperation2);
            UpdateResult updateResult = colectie.updateOne(filter, vector);
            System.out.println("\n=> Updating first documents with {\"content\":" +  SupdateWith + " " + BupdateWith + "}.");
            System.out.println(updateResult);
        }
    }

    public static String findToDo(String content, boolean checked){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("ToDo");
            FindIterable<Document> iterable = colectie.find();
            MongoCursor<Document> cursor = iterable.iterator();
            while (cursor.hasNext()) {
                String returnstatement = cursor.next().toJson();
                String c = ((returnstatement.split(":"))[3]).split(",")[0];
                c = c.substring(2, c.length() - 1);
                String n = ((returnstatement.split(":"))[4]);
                n = n.substring(1, n.length() - 1);
                boolean nrc = Boolean.parseBoolean(n);
                if(c.equals(content) && checked == nrc){
                    System.out.println("The ToDo has been found.");
                    System.out.println(returnstatement);
                    return returnstatement;
                }
            }
            System.out.println("ToDo not found.");
            return null;
        }
    }

    public static void deleteOneToDo(String content){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("ToDo");

            Bson filter = eq("content", content);
            DeleteResult result = colectie.deleteOne(filter);
            System.out.println(result);
        }
    }
    public static void deleteManyToDo(String [] content, boolean [] checked){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("ToDo");

            for( int x = 0; x < checked.length; x++ ){
                Bson filter = and(eq("content", content[x]), eq("checked", checked[x]));
                DeleteResult result = colectie.deleteOne(filter);
                System.out.println(result);
            }
        }
    }
    public static void deleteAllToDo(){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("ToDo");
            colectie.drop();
            System.out.println("All records have been deleted.");
        }
    }

    public static void main(String [] args){
//        readAllToDo();
//        createToDo("New ToDo11", true);
//        readAllToDo();
//        updateToDo("New ToDo10", false, "New ToDo13", true);
//        //updateToDo("New ToDo13", true, "New ToDo10", false);
//        readAllToDo();
//        findToDo("New ToDo11", true);
//        deleteOneToDo("New ToDo0");
//        readAllToDo();
//        String[] s = {"New ToDo1", "New ToDo2", "New ToDo3"};
//        boolean[] b = {false, false, false};
//        deleteManyToDo(s, b);
//        readAllToDo();
//        deleteAllToDo();
//        readAllToDo();
//        recreateDBToDo(11);
//        readAllToDo();
    }
}


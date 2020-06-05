package main.java.Database;

import com.mongodb.client.*;
import com.mongodb.client.model.InsertManyOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public abstract class CRUDRemainder {

    public static void createRemainder(int imp){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase sameples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = sameples.getCollection("Remainder");

            insertOneDocument(colectie, imp);
        }
    }

    public static void recreateDBRemainder( int nr){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase sameples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = sameples.getCollection("Remainder");

            insertManyDocuments(colectie, nr);
        }
    }

    private static void insertOneDocument(MongoCollection<Document> colectie, int imp) {
        colectie.insertOne(generateNewRemainder(imp));
        System.out.println("One Remainder inserted.");
    }

    private static void insertManyDocuments(MongoCollection<Document> colectie, int nr) {
        List<Document> vector = new ArrayList<>();
        for (int classId = 0; classId < nr; classId++) {
            vector.add(generateNewRemainder( classId));
        }

        colectie.insertMany(vector, new InsertManyOptions().ordered(false));
        System.out.println( Integer.valueOf(nr) + " remainders inserted.");
    }

    private static Document generateNewRemainder(int imp) {
        return new Document("_id", new ObjectId()).append("imp", imp);
    }

    public static void readAllRemainder() {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Remainder");


            // find a list of documents and iterate throw it using an iterator.
            FindIterable<Document> iterable = colectie.find();
            MongoCursor<Document> cursor = iterable.iterator();
            System.out.println("Remainder list with a cursor: ");
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        }
    }

    public static MongoCollection<Document> returnAllRemainder() {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Remainder");
            return colectie;
        }
    }

    public static void updateRemainder( int toUpdate, int updateWith){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Remainder");

            // update one document
            Bson filter = eq("imp", toUpdate);
            Bson updateOperation = set("imp", updateWith);
            UpdateResult updateResult = colectie.updateOne(filter, updateOperation);
            System.out.println("\n=> Updating first documents with {\"imp\":" +  updateWith + "}.");
            System.out.println(updateResult);
        }
    }

    public static String findRemainder(int imp){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Remainder");
            FindIterable<Document> iterable = colectie.find();
            MongoCursor<Document> cursor = iterable.iterator();
            while (cursor.hasNext()) {
                String returnstatement = cursor.next().toJson();
                String content = (returnstatement.split(":"))[3];
                content = content.substring(1, content.length() - 1);
                int nr = Integer.parseInt(content);
                if(nr == imp){
                    System.out.println("The Remainder has been found.");
                    System.out.println(returnstatement);
                    return returnstatement;
                }
            }
            System.out.println("Remainder not found.");
            return null;
        }
    }

    public static void deleteOneRemainder(int imp){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Remainder");

            Bson filter = eq("imp", imp);
            DeleteResult result = colectie.deleteOne(filter);
            System.out.println(result);
        }
    }
    public static void deleteManyRemainder(int [] imp){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Remainder");

            for( int x : imp ){
                Bson filter = eq("imp", x);
                DeleteResult result = colectie.deleteOne(filter);
                System.out.println(result);
            }
        }
    }
    public static void deleteAllRemainder(){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Remainder");
            colectie.drop();
            System.out.println("All records have been deleted.");
        }
    }

    public static void main(String [] args){
//        readAllRemainder();
//        createRemainder(11);
//        readAllRemainder();
//        recreateDBRemainder(11);
//        readAllRemainder();
//        updateRemainder(10, 13);
//       // updateRemainder(13, 10);
//        readAllRemainder();
//        findRemainder(7);
//        readAllRemainder();
//        deleteOneRemainder(0);
//        readAllRemainder();
//        int[] s = {1, 2, 3, 4, 5};
//        deleteManyRemainder(s);
//        readAllRemainder();
//        deleteAllRemainder();
//        readAllRemainder();
//        recreateDBRemainder(11);
//        readAllRemainder();
    }
}

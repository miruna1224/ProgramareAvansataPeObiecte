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
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;
import static com.mongodb.client.model.Updates.set;
import static java.util.Arrays.asList;

public abstract class CRUDNote {

    public static void createNote(String noteText){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase sameples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = sameples.getCollection("Note");

            insertOneDocument(colectie, noteText);
        }
    }

    public static void recreateDBNote( int nr){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase sameples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = sameples.getCollection("Note");

            insertManyDocuments(colectie, nr);
        }
    }

    private static void insertOneDocument(MongoCollection<Document> colectie, String noteText) {
        colectie.insertOne(generateNewNote(noteText));
        System.out.println("One note inserted.");
    }

    private static void insertManyDocuments(MongoCollection<Document> colectie, int nr) {
        List<Document> vector = new ArrayList<>();
        for (int classId = 0; classId < nr; classId++) {
            vector.add(generateNewNote( "New Note" + String.valueOf(classId)));
        }

        colectie.insertMany(vector, new InsertManyOptions().ordered(false));
        System.out.println( Integer.valueOf(nr) + " notes inserted.");
    }

    private static Document generateNewNote(String noteText) {
        return new Document("_id", new ObjectId()).append("noteText", noteText);
    }

    public static void readAllNote() {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Note");


            // find a list of documents and iterate throw it using an iterator.
            FindIterable<Document> iterable = colectie.find();
            MongoCursor<Document> cursor = iterable.iterator();
            System.out.println("Note list with a cursor: ");
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        }
    }


    public static MongoCollection<Document> returnAllNote() {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Note");
            return colectie;
        }
    }
    public static void updateNote( String toUpdate, String updateWith){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Note");

            // update one document
            Bson filter = eq("noteText", toUpdate);
            Bson updateOperation = set("noteText", updateWith);
            UpdateResult updateResult = colectie.updateOne(filter, updateOperation);
            System.out.println("\n=> Updating first documents with {\"noteText\":" +  updateWith + "}.");
            System.out.println(updateResult);
        }
    }

    public static String findNote(String noteText){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Note");
            FindIterable<Document> iterable = colectie.find();
            MongoCursor<Document> cursor = iterable.iterator();
            while (cursor.hasNext()) {
                String returnstatement = cursor.next().toJson();
                String content = (returnstatement.split(":"))[3];
                content = content.substring(2, content.length() - 2);
                if(content.equals(noteText)){
                    System.out.println("The note has been found.");
                    System.out.println(returnstatement);
                    return returnstatement;
                }
            }
            System.out.println("Note not found.");
            return null;
        }
    }

    public static void deleteOneNote(String noteText){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Note");

            Bson filter = eq("noteText", noteText);
            DeleteResult result = colectie.deleteOne(filter);
            System.out.println(result);
        }
    }
    public static void deleteManyNote(String [] noteText){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Note");

            for( String x : noteText ){
                Bson filter = eq("noteText", x);
                DeleteResult result = colectie.deleteOne(filter);
                System.out.println(result);
            }
        }
    }
    public static void deleteAllNote(){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Note");
            colectie.drop();
            System.out.println("All records have been deleted.");
        }
    }

    public static void main(String [] args){
//        readAllNote();
//        createNote("New Note11");
//        readAllNote();
//        recreateDBNote(11);
//        readAllNote();
//        updateNote("New Note10", "New Note13");
////        updateNote("New Note13", "New Note10");
//        readAllNote();
//        findNote("New Note11");
//        readAllNote();
//        deleteOneNote("New Note0");
//        readAllNote();
//        String[] s = {"New Note1", "New Note2", "New Note3"};
//        deleteManyNote(s);
//        readAllNote();
//        deleteAllNote();
//        readAllNote();
//        recreateDBNote(11);
//        readAllNote();
    }
}

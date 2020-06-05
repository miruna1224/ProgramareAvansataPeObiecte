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

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public abstract class CRUDTracker {

    public static void createTracker(String objective, int done, int toDo){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase sameples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = sameples.getCollection("Tracker");

            insertOneDocument(colectie, objective, done, toDo);
        }
    }

    public static void recreateDBTracker( int nr){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase sameples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = sameples.getCollection("Tracker");

            insertManyDocuments(colectie, nr);
        }
    }

    private static void insertOneDocument(MongoCollection<Document> colectie, String objective, int done, int toDo) {
        colectie.insertOne(generateNewTracker(objective, done, toDo));
        System.out.println("One Tracker inserted.");
    }

    private static void insertManyDocuments(MongoCollection<Document> colectie, int nr) {
        List<Document> vector = new ArrayList<>();
        for (int classId = 1; classId <= nr; classId++) {
            vector.add(generateNewTracker( "New Tracker" + String.valueOf(classId), classId, 100));
        }

        colectie.insertMany(vector, new InsertManyOptions().ordered(false));
        System.out.println( Integer.valueOf(nr) + " Trackers inserted.");
    }

    private static Document generateNewTracker(String objective, int done, int toDo) {
        return new Document("_id", new ObjectId()).append("objective", objective).append("done", done).append("toDo", toDo);
    }

    public static void readAllTracker() {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Tracker");


            // find a list of documents and iterate throw it using an iterator.
            FindIterable<Document> iterable = colectie.find();
            MongoCursor<Document> cursor = iterable.iterator();
            System.out.println("Tracker list with a cursor: ");
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        }
    }

    public static MongoCollection<Document> returnAllTracker() {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Tracker");
            return colectie;
        }
    }

    public static void updateTracker( String StoUpdate, int I1toUpdate, int I2toUpdate, String SupdateWith, int I1updateWith, int I2updateWith){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Tracker");

            // update one document
            Bson filter = and (eq("objective", StoUpdate), eq("done", I1toUpdate), eq("toDo", I2toUpdate));
            Bson updateOperation1 = set("objective", SupdateWith);
            Bson updateOperation2 = set("done", I1updateWith);
            Bson updateOperation3 = set("toDo", I2updateWith);
            ArrayList<Bson> vector = new ArrayList<>();
            vector.add(updateOperation1);
            vector.add(updateOperation2);
            vector.add(updateOperation3);
            UpdateResult updateResult = colectie.updateOne(filter, vector);
            System.out.println("\n=> Updating first documents with {\"objective\":" +  SupdateWith + " " + I1updateWith + " " + I2updateWith + "}.");
            System.out.println(updateResult);
        }
    }

    public static String findTracker(String objective, int done, int toDo){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Tracker");
            FindIterable<Document> iterable = colectie.find();
            MongoCursor<Document> cursor = iterable.iterator();
            while (cursor.hasNext()) {
                String returnstatement = cursor.next().toJson();
                String c = ((returnstatement.split(":"))[3]).split(",")[0];
                c = c.substring(2, c.length() - 1);
                String n1 = ((returnstatement.split(":"))[4]).split(",")[0];
                n1 = n1.substring(1, n1.length());
                String n2 = ((returnstatement.split(":"))[5]).split(",")[0];
                n2 = n2.substring(1, n2.length() - 1);
                int nn1 = Integer.parseInt(n1);
                int nn2 = Integer.parseInt(n2);
                if(c.equals(objective) && done == nn1 && toDo == nn2){
                    System.out.println("The Tracker has been found.");
                    System.out.println(returnstatement);
                    return returnstatement;
                }
            }
            System.out.println("Tracker not found.");
            return null;
        }
    }

    public static void deleteOneTracker(String objective, int done, int toDo){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Tracker");

            Bson filter = and(eq("objective", objective), eq("done", done), eq("toDo", toDo));
            DeleteResult result = colectie.deleteOne(filter);
            System.out.println(result);
        }
    }
    public static void deleteManyTracker(String [] objective, int [] done, int [] toDo){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Tracker");

            for( int x = 0; x < done.length; x++ ){
                Bson filter = and(eq("objective", objective[x]), eq("done", done[x]), eq("toDo", toDo[x]));
                DeleteResult result = colectie.deleteOne(filter);
                System.out.println(result);
            }
        }
    }
    public static void deleteAllTracker(){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase samples = mongoClient.getDatabase("test");
            MongoCollection<Document> colectie = samples.getCollection("Tracker");
            colectie.drop();
            System.out.println("All records have been deleted.");
        }
    }

    public static void main(String [] args){
//        readAllTracker();
//        createTracker("New Tracker12", 12, 100);
//        readAllTracker();
//        updateTracker("New Tracker10", 10, 100, "New Tracker13", 13, 100);
//        readAllTracker();
//        findTracker("New Tracker11", 11, 100);
//        deleteOneTracker("New Tracker1", 1, 100);
//        readAllTracker();
//        String [] s = {"New Tracker4", "New Tracker2", "New Tracker3"};
//        int [] n1 = {4, 2, 3};
//        int [] n2 = {100, 100, 100};
//        deleteManyTracker(s, n1, n2);
//        readAllTracker();
//        deleteAllTracker();
//        readAllTracker();
//        recreateDBTracker(11);
//        readAllTracker();
    }
}



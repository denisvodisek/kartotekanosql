package com.feri;

import com.feri.entity.*;
import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.BSONObject;
import org.bson.Document;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        MongoClient mongo = new MongoClient(new MongoClientURI("mongodb+srv://root:root@teamnajboljsi-bdrvb.mongodb.net/test"));

        MongoDatabase mdb = mongo.getDatabase("Kartoteke");
        try {
            mdb.createCollection("Kartoteka");
        }
        catch (Exception e) {
            System.out.println("Kolekcija že obstaja");
        }

        MongoCollection mongoCollection = mdb.getCollection("Kartoteka");

        long prev = mongoCollection.count();

        Naslov naslov = new Naslov("Mariborska ulica 2", "Maribor", 2000);

        OsebniPodatki osebniPodatki = new OsebniPodatki("Ime", "Priimek", naslov, 234234234, "+3867171121", OsebniPodatki.Spol.MOSKI, "tn@tn.com");

        Zdravnik zdravnik = new Zdravnik(osebniPodatki, "Kirurgija");
        Zdravilo zdravilo = new Zdravilo();
        List<Zdravilo> zdravila = new ArrayList<Zdravilo>();
        zdravila.add(zdravilo);

        Pregled pregled = new Pregled(123454234, zdravnik, zdravila);

        List<Pregled> pregledi = new ArrayList<Pregled>();
        pregledi.add(pregled);

        Bolezen bolezen = new Bolezen("Aids", pregledi);

        Poskodba poskodba = new Poskodba("Zlom", pregledi);

        List<Poskodba> poskodbe = new ArrayList<Poskodba>();
        poskodbe.add(poskodba);
        List<Bolezen> bolezni = new ArrayList<Bolezen>();
        bolezni.add(bolezen);

        ZdravstvenaStanja zdravstvenaStanja = new ZdravstvenaStanja(poskodbe, bolezni);

        Kartoteka kartoteka = new Kartoteka();
        kartoteka.setOsebniPodatki(osebniPodatki);
        kartoteka.setZdravstvenaStanja(zdravstvenaStanja);


        Gson gson = new Gson();
        String kartotekajson = gson.toJson(kartoteka);
        Document document = new Document();
        document.append("kartoteka", kartotekajson);
        mongoCollection.insertOne(document);
        long now = mongoCollection.count();
        System.out.print("Število vnosov v bazi: " + now + " | " + "Prej: " + prev);



    }

}

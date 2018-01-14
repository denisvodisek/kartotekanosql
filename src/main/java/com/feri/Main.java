package com.feri;

import com.feri.entity.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.reflect.Array;

import java.util.*;

public class Main {
    static Random random = new Random();
    public static void main(String[] args) {

        MongoClient mongo = new MongoClient(new MongoClientURI("mongodb+srv://root:root@teamnajboljsi-bdrvb.mongodb.net/test"));

        MongoDatabase mdb = mongo.getDatabase("Kartoteke");

        DB db = mongo.getDB("Kartoteke");
        try {
            mdb.createCollection("Kartoteka");
        }
        catch (Exception e) {
            System.out.println("Kolekcija že obstaja");
        }

        MongoCollection mongoCollection = mdb.getCollection("Kartoteka");
        DBCollection collection = db.getCollection("Kartoteka");


        long prev = mongoCollection.count();

        //vse kar rabimo za osebne podatke
        String ime = "ime";
        String priimek ="priimek";
        String ulica = "ulica";
        BsonTimestamp datum_rojstva = new BsonTimestamp(805723200);
       String tel_st = "+38631787957";
        String email = "email@gmail.com";

        BsonTimestamp datum = new BsonTimestamp(new Date().getTime());


        String poskodba = "poskodba";

        List<String> naziv_zdravila = new ArrayList<String>();
        naziv_zdravila.add("Abilify");
        naziv_zdravila.add("Aricept");
        naziv_zdravila.add("Aspirin");
        naziv_zdravila.add("Botox");
        naziv_zdravila.add("Cialis");
        naziv_zdravila.add("Cipro");
        naziv_zdravila.add("Diovan");
        naziv_zdravila.add("Dymista");
        naziv_zdravila.add("Elavil");
        naziv_zdravila.add("Effient");
        naziv_zdravila.add("Exforge");
        naziv_zdravila.add("Fentanyl");
        naziv_zdravila.add("Forteo");
        naziv_zdravila.add("Gazyva");
        naziv_zdravila.add("Geodon");
        naziv_zdravila.add("Hetlioz");
        naziv_zdravila.add("Hyzaar");
        naziv_zdravila.add("Imdur");
        naziv_zdravila.add("Invokana");
        naziv_zdravila.add("Jalyn");
        naziv_zdravila.add("Jublia");
        naziv_zdravila.add("Kadian");
        naziv_zdravila.add("Kenalog");
        naziv_zdravila.add("Levoxyl");
        naziv_zdravila.add("Lyrica");
        naziv_zdravila.add("Macrobid");
        naziv_zdravila.add("Motrin");
        naziv_zdravila.add("Naloxone");
        naziv_zdravila.add("Norco");
        naziv_zdravila.add("Ofev");

        double moc_zdravila = 1;
        int dnevni_odmerek = 2;

        //kraji
        List<String> kraji = new ArrayList<String>();
        kraji.add("Ljubljana");
        kraji.add("Maribor");
        kraji.add("Celje");
        kraji.add("Kranj");
        kraji.add("Nova Gorica");
        kraji.add("Koper");
        kraji.add("Krško");
        kraji.add("Murska Sobota");
        kraji.add("Novo Mesto");

        List<Integer> postaList = new ArrayList<Integer>();
        postaList.add(1000);
        postaList.add(2000);
        postaList.add(3000);
        postaList.add(4000);
        postaList.add(5000);
        postaList.add(6000);
        postaList.add(7000);
        postaList.add(8000);
        postaList.add(9000);

        List<String> specializacija = new ArrayList<String>();
        specializacija.add("Splosni kirurg");
        specializacija.add("Psiholog");
        specializacija.add("Fizioterapevt");
        specializacija.add("Nevrolog");
        specializacija.add("Ortoped");
        specializacija.add("Zobozdravnik");
        specializacija.add("Otorinolaringolog");
        specializacija.add("Radiolog");
        specializacija.add("Lekarnar");
        specializacija.add("Fizioterapevt");
        specializacija.add("Dietik");
        specializacija.add("Anesteziolog");
        specializacija.add("Ginekolog");
        specializacija.add("Kardiolog");
        specializacija.add("Patolog");
        specializacija.add("Dermatolog");
        specializacija.add("Onkolog");
        specializacija.add("Haematolog");
        specializacija.add("Pulmolog");
        specializacija.add("Urolog");
        specializacija.add("Neonatolog");
        specializacija.add("Gastrolog");
        specializacija.add("Nefrolog");
        specializacija.add("Pediatrik");
        specializacija.add("Podiatrist");
        specializacija.add("Audiolog");
        specializacija.add("Microbiolog");

        List<String> bolezen = new ArrayList<String>();
        bolezen.add("Aids");
        bolezen.add("Botulizem");
        bolezen.add("Crne koze");
        bolezen.add("Gobavost");
        bolezen.add("Gonoreja");
        bolezen.add("Hepatitis");
        bolezen.add("Kolera");
        bolezen.add("Kuga");
        bolezen.add("Malarija");
        bolezen.add("Meningitis");
        bolezen.add("Norice");
        bolezen.add("Ospice");
        bolezen.add("Pasove");
        bolezen.add("Plucnica");
        bolezen.add("Rdecke");
        bolezen.add("Sifilis");
        bolezen.add("Tifus");
        bolezen.add("Tuberkoloza");
        bolezen.add("Rak");
        bolezen.add("Zlom");
        bolezen.add("Zvin");
        bolezen.add("Steklina");
        bolezen.add("Tetanus");
        bolezen.add("Ureznina");
        bolezen.add("Alergija");
        bolezen.add("Odpoved ograna");
        bolezen.add("Osteoporoza");
        bolezen.add("Depresija");
        bolezen.add("Homoseksualnost");
        bolezen.add("Telesna dismorfija");

        DBCollection dbCollection = db.getCollection("Kartoteka");

        long start = new Date().getTime();
        List<BasicDBObject> dbji = new ArrayList<BasicDBObject>();
        int w = 0;
        for(int i = 0; i < 10000; i++) {

            //generiranje random pickov iz arrayov
            int k = getRandomItem(kraji);
            int b = getRandomItem(bolezen);
            int s = getRandomItem(specializacija);
            int z = getRandomItem(naziv_zdravila);
            int s2 = getRandomItem(specializacija);
            int z2 = getRandomItem(naziv_zdravila);
            //root
            BasicDBObject kartoteke = new BasicDBObject();

            BasicDBObject kartoteka = new BasicDBObject();

            //osebni podatki
            BasicDBObject osebni_podatki = new BasicDBObject();

            //naslov
            BasicDBObject naslov = new BasicDBObject();
            naslov.put("ulica", ulica + i);
            naslov.put("kraj", kraji.get(k));
            naslov.put("posta", new BsonInt64(postaList.get(k)));

            //spol
            BasicDBObject spol = new BasicDBObject();
            spol.put("id", 0);
            spol.put("spol", "Moški");

            osebni_podatki.put("ime", ime + i);
            osebni_podatki.put("priimek", priimek + i);
            osebni_podatki.put("naslov", naslov);
            osebni_podatki.put("spol", spol);
            osebni_podatki.put("datum_rojstva", iWantRandDate());
            osebni_podatki.put("tel_st", tel_st + i);
            osebni_podatki.put("email", email+ i);

            BasicDBObject zdravstvena_stanja = new BasicDBObject();

            BasicDBList poskodbaList = new BasicDBList();
            for(int h = 0; h < getRandomItem(kraji); h++) {
                poskodbaList = new BasicDBList();
                BasicDBObject poskodbaObject = new BasicDBObject();
                poskodbaObject.put("ime", poskodba + i);
                poskodbaList.add(poskodbaObject);
                BasicDBList pregledPoskodbaList = new BasicDBList();
                BasicDBObject pregledPoskodba = new BasicDBObject();
                pregledPoskodba.put("datum_pregleda", iWantRandDate());
                //zdravnik
                BasicDBObject zdravnik = new BasicDBObject();
                zdravnik.put("osebni_podatki", osebni_podatki);
                zdravnik.put("specializacija", specializacija.get(s));

                //zdravilo
                BasicDBList zdravila = new BasicDBList();
                for(int o = 0; o < z; o++) {
                    zdravila = new BasicDBList();
                    BasicDBObject zdravilo = new BasicDBObject();
                    zdravilo.put("naziv", naziv_zdravila.get(z));
                    zdravilo.put("moc_zdravila", new BsonDouble(getRandomItem(specializacija)));
                    zdravilo.put("dnevni_odmerek", new BsonInt64(getRandomItem(bolezen)));
                    zdravila.add(zdravilo);
                    pregledPoskodba.put("zdravila", zdravila);
                }
                pregledPoskodba.put("zdravila", zdravila);
                pregledPoskodba.put("zdravnik", zdravnik);
                pregledPoskodbaList.add(pregledPoskodba);

                poskodbaList.add(pregledPoskodbaList);
            }
            BasicDBList bolezenList = new BasicDBList();
            for(int j = 0; j < k; j++) {
                //bolezen
                bolezenList = new BasicDBList();
                BasicDBObject bolezenObject = new BasicDBObject();
                bolezenObject.put("ime", bolezen.get(b));
                bolezenList.add(bolezenObject);
                BasicDBList pregledBolezenList = new BasicDBList();
                BasicDBObject pregledBolezen = new BasicDBObject();
                pregledBolezen.put("datum_pregleda", iWantRandDate());
                //zdravnik
                BasicDBObject zdravnikBolezen = new BasicDBObject();
                zdravnikBolezen.put("osebni_podatki", osebni_podatki);
                zdravnikBolezen.put("specializacija", specializacija.get(s2));
                //zdravila
                BasicDBList zdravilaBolezen = new BasicDBList();
                for(int d = 0; d < z; d++) {
                    zdravilaBolezen = new BasicDBList();
                    BasicDBObject zdraviloBolezen = new BasicDBObject();
                    zdraviloBolezen.put("naziv", naziv_zdravila.get(z2));
                    zdraviloBolezen.put("moc_zdravila", new BsonDouble(getRandomItem(specializacija)));
                    zdraviloBolezen.put("dnevni_odmerek", new BsonInt64(getRandomItem(bolezen)));
                    zdravilaBolezen.add(zdraviloBolezen);
                }
                pregledBolezen.put("zdravnik", zdravnikBolezen);
                pregledBolezen.put("zdravila", zdravilaBolezen);

                pregledBolezenList.add(pregledBolezen);
                bolezenList.add(pregledBolezenList);
            }
            zdravstvena_stanja.put("poskodbe", poskodbaList);
            zdravstvena_stanja.put("bolezni", bolezenList);

            kartoteke.put("kartoteka", kartoteka);
            kartoteka.put("osebni_podatki", osebni_podatki);
            kartoteka.put("zdravstvena_stanja", zdravstvena_stanja);

            dbji.add(kartoteke);
            long now = mongoCollection.count();
            w++;
            if(w == 500) {
                System.out.println("w: " + w);
                w=0;
            }
            if(dbji.size() == 1000) {
                long startImport = new Date().getTime();
                System.out.println("Vnašam ...");
                dbCollection.insert(dbji);
                System.out.println("Število vnosov v bazi: " + now + ", vnešenih v tem importu: " + i + 1);
                dbji.clear();
                System.out.println("Kartotek v arrayu: " + dbji.size());
                long end = new Date().getTime();

                long elapsed = end - startImport;

                System.out.println("Elapsed time importing: " + elapsed / 1000);
            }
        }

        long end = new Date().getTime();

        long elapsed = end - start;

        System.out.println("Elapsed time: " + elapsed / 1000);

    }
    private static int getRandomItem(List<?> list)
    {
        Random random = new Random();
        int listSize = list.size();
        int randomIndex = random.nextInt(listSize);
        return randomIndex;
    }

    private static long iWantRandDate() {
        return -298728000 + random.nextInt(1436875200 - -298728000);
    }
}



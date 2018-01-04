package com.feri.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aleksej on 23.12.2017.
 */
public class OsebniPodatki {

    private String ime;

    private String priimek;

    private Naslov naslov;

    private long datumRojstva; //Predviden v "time in millis" formatu

    private String telefonskaStevilka;

    @SerializedName("spol")
    private Spol spol;

    public String email;

    public enum Spol{
        @SerializedName("moski")
        MOSKI,

        @SerializedName("zenski")
        ZENSKI

    }

    public OsebniPodatki(String ime, String priimek, Naslov naslov, long datumRojstva, String telefonskaStevilka, Spol spol, String email) {
        this.ime = ime;
        this.priimek = priimek;
        this.naslov = naslov;
        this.datumRojstva = datumRojstva;
        this.telefonskaStevilka = telefonskaStevilka;
        this.spol = spol;
        this.email = email;
    }
}

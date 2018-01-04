package com.feri.entity;

/**
 * Created by Aleksej on 23.12.2017.
 */
public class Zdravnik {

    private OsebniPodatki osebniPodatki;

    private String specializacija;

    public Zdravnik(OsebniPodatki osebniPodatki, String specializacija) {
        this.osebniPodatki = osebniPodatki;
        this.specializacija = specializacija;
    }
}

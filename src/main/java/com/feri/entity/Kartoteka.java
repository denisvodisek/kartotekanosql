package com.feri.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksej on 23.12.2017.
 */
public class Kartoteka {

    private OsebniPodatki osebniPodatki;

    private ZdravstvenaStanja zdravstvenaStanja;

    public OsebniPodatki getOsebniPodatki() {
        return osebniPodatki;
    }

    public void setOsebniPodatki(OsebniPodatki osebniPodatki) {
        this.osebniPodatki = osebniPodatki;
    }

    public ZdravstvenaStanja getZdravstvenaStanja() {
        return zdravstvenaStanja;
    }

    public void setZdravstvenaStanja(ZdravstvenaStanja zdravstvenaStanja) {
        this.zdravstvenaStanja = zdravstvenaStanja;
    }
}

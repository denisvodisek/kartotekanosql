package com.feri.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksej on 23.12.2017.
 */
public class Pregled {

    private long datumPregleda;

    private Zdravnik zdravnik;

    private List<Zdravilo> zdraviloList;

    public Pregled(long datumPregleda, Zdravnik zdravnik, List<Zdravilo> zdraviloList) {
        this.datumPregleda = datumPregleda;
        this.zdravnik = zdravnik;
        this.zdraviloList = zdraviloList;
    }
}

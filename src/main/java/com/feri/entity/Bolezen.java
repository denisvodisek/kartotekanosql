package com.feri.entity;

import java.util.List;

/**
 * Created by Aleksej on 23.12.2017.
 */
public class Bolezen {
    private String ime;

    List<Pregled> pregledList; //Pregled pri katerem je bilo stanje pregledano

    public Bolezen(String ime, List<Pregled> pregledList) {
        this.ime = ime;
        this.pregledList = pregledList;
    }

}

package com.feri.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksej on 23.12.2017.
 */
public class ZdravstvenaStanja {

    private List<Poskodba> poskodbaList;

    private List<Bolezen> bolezenList;


    public ZdravstvenaStanja(List<Poskodba> poskodbaList, List<Bolezen> bolezenList) {
        this.poskodbaList = poskodbaList;
        this.bolezenList = bolezenList;
    }
}

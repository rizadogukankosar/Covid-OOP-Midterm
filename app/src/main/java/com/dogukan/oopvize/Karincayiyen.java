package com.dogukan.oopvize;

import java.util.ArrayList;

public class Karincayiyen extends Canli {


    public Karincayiyen(String ad, int yas) {
        super(ad, yas);
    }

    public void karincaYe(ArrayList<Karinca> karincalar) {
        if (karincalar != null) {
            int karinca_sayisi = karincalar.size();
            ArrayList<Virus> virusler = new ArrayList<>();


            for (int i = 0; i < karinca_sayisi; i++) {
                Canli karinca = karincalar.get(i);


                for (int j = 0; j < karinca.getkVirusler().size(); j++) {
                    Virus v = karinca.getkVirusler().get(j);
                    boolean var_mi = false;
                    for (int k = 0; k < virusler.size(); k++) {
                        if (virusler.get(k) == v){
                            var_mi = true;
                        }
                    }
                    if (!var_mi){
                        virusler.add(v);
                    }
                }
            }
            this.setkVirusler(virusler);

        }
    }

}

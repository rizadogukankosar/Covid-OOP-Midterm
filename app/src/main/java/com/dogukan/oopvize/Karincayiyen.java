package com.dogukan.oopvize;

import java.util.ArrayList;

public class Karincayiyen extends Canli {


    public Karincayiyen(String ad, int yas) {
        super(ad,yas);


    }

    public void karincaYe(ArrayList<Karinca> karincalar){
        if (!karincalar.isEmpty()) {
            for (int i = 0; i < karincalar.size(); i++) {
                if (karincalar.get(i) != null){
                    karincalar.get(i).kYiyenSayisi++;
                    if (karincalar.get(i).getkVirusler() != null){
                        for (int j = 0; j < karincalar.get(i).getkVirusler().size(); j++) {
                            if (!this.kVirusler.contains(karincalar.get(i).getkVirusler().get(j))){
                                this.kVirusler.add(karincalar.get(i).getkVirusler().get(j));
                            }
                        }
                    }
                }
            }
        }



    }

}

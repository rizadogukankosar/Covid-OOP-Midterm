package com.dogukan.oopvize;

import java.util.ArrayList;
import java.util.HashSet;

public class Deneme {
    public static void main(String[] args) {
        Canli c = new Karinca("karinca",5);
        System.out.println(c.getAd());

        ArrayList<Virus> denenecek_virusler = new ArrayList<>();
        ArrayList<Canli> denenecek_canlilar = new ArrayList<>();

        Virus v1 = new Covid19("Covid19",50,6);
        Virus v2 = new Covid19("Covid19",70,5);
        Virus v3 = new Covid20("Covid20",80,7);
        Virus v4 = new Covid20("Covid20",90,8);
        Virus v5 = new Covid21("Covid21",120,9);
        denenecek_virusler.add(v1);
        denenecek_virusler.add(v2);
        denenecek_virusler.add(v3);
        denenecek_virusler.add(v4);
        denenecek_virusler.add(v5);
        c.hastalıkKap(denenecek_virusler);

        Canli cn1 = new Insan("dogu",19,"Yok");
        cn1.setkVirusler(denenecek_virusler);
        Canli cn2 = new Karincayiyen("dogu",19);
        Canli cn3 = new Karincayiyen("dogu",17);
        Canli cn4 = new Karincayiyen("dogu",15);
        Canli cn5 = new Karinca("kr",2);

        denenecek_canlilar.add(cn1);
        denenecek_canlilar.add(cn2);
        denenecek_canlilar.add(cn3);
        denenecek_canlilar.add(cn4);
        denenecek_canlilar.add(cn5);

        cn5.hastalikKapv2(denenecek_canlilar);






        for (int i = 0; i < c.getkVirusler().size(); i++) {
            System.out.println(c.getkVirusler().get(i).getAd());
            System.out.println(c.getkVirusler().get(i).getBulasmaMiktari());
        }






    }
}

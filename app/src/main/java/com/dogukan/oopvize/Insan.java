package com.dogukan.oopvize;

import java.util.ArrayList;

public class Insan extends Canli {
    private String meslek;
    private Canli[] canlilar;

    public Insan(String ad, int yas,String meslek) {
        super(ad, yas);
        this.meslek = meslek;
    }

    @Override
    public void hastalikKapv2(ArrayList<Canli> canlilar) {

        if (!canlilar.isEmpty()){
            int canli_sayisi = canlilar.size();
            int this_canli_sayisi = this.canlilar.length;
            ArrayList<Canli> yeni_canli_listesi = new ArrayList<>();
            for (int i = 0; i < this_canli_sayisi; i++) {
                int a =0;
                Canli canli = this.canlilar[i];
                for (int j = 0; j < canli_sayisi; j++) {
                    if (canli == canlilar.get(j)){
                        a++;
                    }
                }
                if (a == 0){
                    yeni_canli_listesi.add(canli);
                }
            }


            ArrayList<Virus> virusler = new ArrayList<>();
            for (int i = 0; i < canli_sayisi; i++) {
                if (!yeni_canli_listesi.get(i).getkVirusler().isEmpty()) {
                    for (int j = 0; j < yeni_canli_listesi.get(i).getkVirusler().size(); j++) {
                        virusler.add(yeni_canli_listesi.get(i).getkVirusler().get(j));
                    }
                }
            }
            hastalıkKap(virusler);

        }

    }


}

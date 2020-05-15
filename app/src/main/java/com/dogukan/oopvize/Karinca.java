package com.dogukan.oopvize;

import java.util.ArrayList;

public class Karinca extends Canli {
    public int kYiyenSayisi =0;

    public Karinca(String ad, int yas) {
        super(ad,yas);
    }


    @Override
    public void hastalikKapv2(ArrayList<Canli> canlilar) {
        super.hastalikKapv2(canlilar);
        if (!canlilar.isEmpty()){
            for (int i = 0; i <canlilar.size() ; i++) {
                if (canlilar.get(i) instanceof Karincayiyen) {
                    this.kYiyenSayisi++;
                }
            }
        }
    }

    @Override
    public void hastalikKap(Canli[] canlilar) {
        if (canlilar != null) {
            for (int i = 0; i < canlilar.length; i++) {
                if (canlilar[i] instanceof Karincayiyen){
                    this.kYiyenSayisi++;
                }
            }
        }
        super.hastalikKap(canlilar);

    }


}

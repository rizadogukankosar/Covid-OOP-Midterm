package com.dogukan.oopvize;

import java.util.ArrayList;

public class Karinca extends Canli {
    public int kYiyenSayisi;

    public Karinca(String ad, int yas) {
        super(ad,yas);
        this.kYiyenSayisi = 0;

    }


    @Override
    public void hastalikKapv2(ArrayList<Canli> canlilar) {
        super.hastalikKapv2(canlilar);
        if (canlilar !=null){
            for (int i = 0; i <canlilar.size() ; i++) {
                if (canlilar.get(i).getClass() == Karincayiyen.class) {
                    this.kYiyenSayisi++;
                }
            }
        }
    }

    @Override
    public void hastalikKap(Canli[] canlilar) {
        if (canlilar != null) {
            for (int i = 0; i < canlilar.length; i++) {
                if (canlilar[i].getClass() == Karincayiyen.class){
                    this.kYiyenSayisi++;
                }
            }
        }
        super.hastalikKap(canlilar);

    }


}

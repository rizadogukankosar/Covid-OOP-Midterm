package com.dogukan.oopvize;

import java.util.ArrayList;

public class Karinca extends Canli {
    public int kyiyenSayisi;



    public Karinca(String ad, int yas) {
        super(ad, yas);
        kyiyenSayisi = 0;
    }

    @Override
    public void hastalikKapv2(ArrayList<Canli> canlilar) {
        super.hastalikKapv2(canlilar);
        kyiyenSayisi++;
    }

    public int getKyiyenSayisi(){
        return this.kyiyenSayisi;
    }


}

package com.dogukan.oopvize;

import java.util.ArrayList;

public class Insan extends Canli {
     String meslek;
     Canli[] canlilar;

    public Insan(String ad, int yas,String meslek) {
        super(ad, yas);
        this.meslek = meslek;

    }

    @Override
    public void hastalikKapv2(ArrayList<Canli> canlilar) {


            if (this.canlilar == null) {
                super.hastalikKapv2(canlilar);
            } else{
                if (!canlilar.isEmpty()) {
                    ArrayList<Canli> canlis = new ArrayList<>();
                    for (int i = 0; i < canlilar.size() ; i++) {
                        boolean var_mi = false;
                        for (int j = 0; j < this.canlilar.length; j++) {
                            if (this.canlilar[j].getClass() == canlilar.get(i).getClass()){
                                var_mi = true;
                            }
                        }
                        if (!var_mi){
                            canlis.add(canlilar.get(i));
                        }

              /*  if (canlilar.get(i).getClass() == Insan.class) {
                    Canli canli = new Insan(canlilar.get(i).getAd(), canlilar.get(i).getYas(), "doktor");
                    canlis.add(canli);
                } else if (canlilar.get(i).getClass() == Karinca.class) {
                    Canli canli = new Karinca(canlilar.get(i).getAd(), canlilar.get(i).getYas());
                    canlis.add(canli);
                } else {
                    Canli canli = new Karincayiyen(canlilar.get(i).getAd(), canlilar.get(i).getYas());
                    canlis.add(canli);
                }*/
                    }
                    ArrayList<Virus> virusler = new ArrayList<>();
                    int canli_sayisi = canlis.size();
                    for (int i = 0; i < canli_sayisi; i++) {
                        if (canlis.get(i).getkVirusler() != null) {
                            for (int j = 0; j < canlis.get(i).getkVirusler().size(); j++) {
                                virusler.add(canlis.get(i).getkVirusler().get(j));
                            }
                        }
                    }
                    this.hastalikKap(virusler);
                }



        }
    }



}

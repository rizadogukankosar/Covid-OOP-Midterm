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
        ArrayList<Canli> canlis = canlilar;
            if (this.canlilar == null) {
                if (!canlilar.isEmpty()){
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
            }else{
                if (!canlilar.isEmpty()) {
                    int length = this.canlilar.length;
                    for (int i = 0; i < length; i++) {
                        for (int j = 0; j < canlis.size(); j++) {
                            if (canlis.size() > j){
                                if (canlis.get(j).getClass() == this.canlilar[i].getClass()){
                                    canlis.remove(j);
                                    j--;
                                }
                            }
                        }
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

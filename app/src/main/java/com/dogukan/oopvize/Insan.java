package com.dogukan.oopvize;

import java.util.ArrayList;

public class Insan extends Canli {

    String meslek;
    Canli[] canlilar;

    public Insan(String ad, int yas, String meslek) {
        super(ad, yas);
        this.meslek = meslek;

    }


    public  void hastalikKapv2(ArrayList<Canli> canlilar){
        /* BURADA EĞER BİRLİKTE YAŞADIĞI CANLILAR LİSTESİ BOŞSA
           NORMALDE ÇALIŞACAK METHODUN AYNISINI YAZDIM. AMA PARAMETRE
           OLARAK GELEN ARRAYE DOKUNMAK İSTEMEDİĞİMİZ İÇİN ARRAYİN
           BİR KOPYASINI OLUŞTURARAK İŞE BAŞLADIM
        */
        if (this.canlilar == null) {
            super.hastalikKapv2(canlilar);
        } else{
            if (!canlilar.isEmpty()) {
                ArrayList<Canli> canlis = new ArrayList<>();
                for (int i = 0; i < canlilar.size() ; i++) {
                    boolean var_mi = false;
                    for (int j = 0; j < this.canlilar.length; j++) {
                        if (this.canlilar[j] == canlilar.get(i)){
                            var_mi = true;
                        }
                    }
                    if (!var_mi){
                        canlis.add(canlilar.get(i));
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

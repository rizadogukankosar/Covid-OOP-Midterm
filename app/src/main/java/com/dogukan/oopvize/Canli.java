package com.dogukan.oopvize;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Canli implements Comparable{
    private String ad;
    private int yas;
    private ArrayList<Virus> kVirusler = new ArrayList<>();

    public Canli(String ad, int yas) {
        this.ad = ad;
        this.yas = yas;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public void setkVirusler(ArrayList<Virus> kVirusler){
        this.kVirusler = kVirusler;
    }
    public ArrayList<Virus> getkVirusler(){
        return this.kVirusler;
    }



    public int compareTo(Object o) {
        if (this.getClass() == o.getClass()){
            return 1;
        }else {
            return 0;
        }

    }

    public void hastalıkKap(ArrayList<Virus> virusler) {
        if (!virusler.isEmpty()){
        int virus_sayisi = virusler.size();
        ArrayList<Virus> cikanlar = new ArrayList<>();

        for (int i = 0; i < virus_sayisi; i++) {
            int virus_counter = 0;
            double bulasma_orani_toplam = 0;
            Virus v = virusler.get(i);
            boolean cikti_mi = cikanlar.contains(v);

           // System.out.println(cikti_mi);

            /**********************HATA OLURSA İF KISMINI == v yazarak dene*************************************/
            if (!cikti_mi) {
                for (int j = 0; j < virus_sayisi; j++) {
                    if (virusler.get(j).getAd().equalsIgnoreCase(v.getAd())) {
                        virus_counter++;
                        bulasma_orani_toplam += virusler.get(j).getBulasmaMiktari();

                    }
                }
                v.setBulasmaMiktari(bulasma_orani_toplam / virus_counter);
                cikanlar.add(v);
            }
        }
     /*   for (int i = 0; i < cikanlar.size(); i++) {
            System.out.println(cikanlar.get(i).getAd());
            System.out.println(cikanlar.get(i).getBulasmaMiktari());
        }*/

        /************************DOKUNMA SAKIN ÇALIŞIYOR********************************/

        for (int i = 0; i < cikanlar.size(); i++) {
            //System.out.println(cikanlar.get(i).getAd());
            boolean hasta_eder_mi = cikanlar.get(i).hastaEdiyormu(this);
            boolean zaten_hasta_mi = false;
            if (kVirusler != null) {
                for (int j = 0; j < this.kVirusler.size(); j++) {
                    if (kVirusler.get(j).getAd().equalsIgnoreCase(cikanlar.get(i).getAd())) {
                        zaten_hasta_mi = true;
                    }
                }
                if (hasta_eder_mi && !zaten_hasta_mi) {
                    kVirusler.add(cikanlar.get(i));
                }
            }
        }
    }
    }

    public void hastalikKapv2(ArrayList<Canli> canlilar){
        if (!canlilar.isEmpty()){
            ArrayList<Virus> virusler = new ArrayList<>();
            int canli_sayisi = canlilar.size();
            for (int i = 0; i < canli_sayisi; i++) {
                if (!canlilar.get(i).getkVirusler().isEmpty()) {
                    for (int j = 0; j < canlilar.get(i).getkVirusler().size(); j++) {
                        virusler.add(canlilar.get(i).getkVirusler().get(j));
                    }
                }
            }
            hastalıkKap(virusler);

        }

    }


    public void hastalıkKap(Canli [] canlilar){

        if (canlilar != null){
            int canli_sayisi = canlilar.length;

            for (int i =0; i < canli_sayisi;i++){
                ArrayList<Virus> v = canlilar[i].getkVirusler();
                for (int j = 0;j < v.size();j++){
                    double bulasma_miktarı_temp = v.get(j).getBulasmaMiktari();


                }
            }
        }

    }


 /*

        int canli_sayisi = canlilar.length;
        if (canli_sayisi != 0){
            for (int i =0; i < canli_sayisi;i++){
                ArrayList<Virus> v = canlilar[i].kVirusler;
                for (int j = 0;j < v.size();j++){
                    boolean hasta_ediyor_mu = v.get(j).hastaEdiyormu(this);
                    if (hasta_ediyor_mu == true){

                    }

                }
            }
        }*/


}



package com.dogukan.oopvize;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Canli implements Comparable{
    public String ad;
    public int yas;
    public ArrayList<Virus> kVirusler = new ArrayList<>();

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

    public void hastalikKap(ArrayList<Virus> virusler) {
        if (virusler != null){
            ArrayList<Virus> virus_list = virusler;
            int virus_sayisi = virus_list.size();
            for (int i = 0; i < virus_sayisi ; i++) {
                if (i < virus_list.size()) {
                    if (virus_list.get(i) != null) {
                        Virus v = virus_list.get(i);
                        if (v.hastaEdiyormu(this)) {
                            double bulasma_orani_toplam = 0;
                            int virus_counter = 0;
                            for (int j = 0; j < virus_list.size(); j++) {
                                if (virus_list.get(j) != null) {
                                    if (virus_list.get(j).getClass() == v.getClass()) {
                                        bulasma_orani_toplam += virus_list.get(j).getBulasmaMiktari();
                                        virus_counter++;
                                        virus_list.remove(j);
                                        virus_list.add(j, null);
                                    }
                                }
                            }
                            int a = 65465;
                            for (int j = 0; j < this.kVirusler.size(); j++) {
                                if (this.kVirusler.get(j).getClass() == v.getClass()) {
                                    bulasma_orani_toplam += this.kVirusler.get(j).getBulasmaMiktari();
                                    virus_counter++;
                                    a = j;
                                }
                            }
                            v.setBulasmaMiktari(bulasma_orani_toplam / virus_counter);
                            Virus virus;
                            if (v.getClass() == Covid19.class){
                                virus = new Covid19(v.getAd(),v.getBulasmaMiktari(),v.getGuc());
                            }else if (v.getClass() == Covid20.class){
                                virus = new Covid20(v.getAd(),v.getBulasmaMiktari(),v.getGuc());
                            }else {
                                virus = new Covid21(v.getAd(),v.getBulasmaMiktari(),v.getGuc());
                            }

                            if (a != 65465) {
                                this.kVirusler.remove(a);
                                this.kVirusler.add(a, virus);
                            } else {
                                this.kVirusler.add(virus);
                            }
                        }
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
                if (canlilar.get(i).getkVirusler() != null) {
                    for (int j = 0; j < canlilar.get(i).getkVirusler().size(); j++) {
                        virusler.add(canlilar.get(i).getkVirusler().get(j));
                    }
                }
            }
            this.hastalikKap(virusler);


        }

    }


    public void hastalikKap(Canli [] canlilar){

        if (canlilar != null){
            int canli_sayisi = canlilar.length;

            for (int i =0; i < canli_sayisi;i++){
                ArrayList<Virus> v = canlilar[i].getkVirusler();
                if(v != null) {
                    for (int j = 0; j < v.size(); j++) {
                        double bulasma_miktarı_temp = v.get(j).getBulasmaMiktari();



                    }
                }
            }
        }

    }



}



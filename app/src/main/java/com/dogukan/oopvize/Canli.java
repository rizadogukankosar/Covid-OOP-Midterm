package com.dogukan.oopvize;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Canli implements Comparable{
    public String ad;
    public int yas;
    public ArrayList<Virus> kVirusler = new ArrayList<>();

    public Canli(String ad, int yaş){
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


    @Override
    public int compareTo(Object o) {
        if (this.getClass() == o.getClass()){
            return 1;
        }else {
            return 0;
        }

    }




    public void hastalikKap(ArrayList<Virus> virusler){
        if (virusler != null){
            ArrayList<Virus> virus_list = new ArrayList<>();
            for (int i = 0; i < virusler.size(); i++) {
                if (virusler.get(i) instanceof Covid19){
                    Virus virus = new Covid19(virusler.get(i).getAd(),virusler.get(i).getBulasmaMiktari(),virusler.get(i).getGuc());
                    virus_list.add(virus);
                }else if (virusler.get(i) instanceof Covid20){
                    Virus virus = new Covid20(virusler.get(i).getAd(),virusler.get(i).getBulasmaMiktari(),virusler.get(i).getGuc());
                    virus_list.add(virus);

                }else {
                    Virus virus = new Covid21(virusler.get(i).getAd(),virusler.get(i).getBulasmaMiktari(),virusler.get(i).getGuc());
                    virus_list.add(virus);

                }
            }
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
                            int a = 999999;
                            for (int j = 0; j < this.kVirusler.size(); j++) {
                                if (this.kVirusler.get(j).getClass() == v.getClass()) {
                                    bulasma_orani_toplam += this.kVirusler.get(j).getBulasmaMiktari();
                                    virus_counter++;
                                    a = j;
                                }
                            }
                            v.setBulasmaMiktari(bulasma_orani_toplam / virus_counter);
                            Virus virus;
                            if (v instanceof Covid19){
                                virus = new Covid19(v.getAd(),v.getBulasmaMiktari(),v.getGuc());
                            }else if (v instanceof Covid20){
                                virus = new Covid20(v.getAd(),v.getBulasmaMiktari(),v.getGuc());
                            }else {
                                virus = new Covid21(v.getAd(),v.getBulasmaMiktari(),v.getGuc());
                            }

                            if (a != 999999) {
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

            for (int i = 0; i < canlilar.size(); i++) {
                if (!canlilar.get(i).getkVirusler().isEmpty()) {
                    virusler.addAll(canlilar.get(i).getkVirusler());
                }
            }
            hastalikKap(virusler);

        }
        int kYiyen_sayisi = 0;
        if (this.getClass() == Karincayiyen.class){
            kYiyen_sayisi++;
        }

        for (int i = 0; i <canlilar.size() ; i++) {
            if (canlilar.get(i) instanceof Karincayiyen){
                kYiyen_sayisi +=1;
            }
        }
        for (int i = 0; i < canlilar.size(); i++) {
            if (canlilar.get(i) instanceof Karinca){
                Karinca karinca = (Karinca) canlilar.get(i);
                karinca.kYiyenSayisi += kYiyen_sayisi;
            }
        }



    }

    public void hastalikKap(Canli[] canlilar){
        if (canlilar != null){
            ArrayList<Virus> virusler = new ArrayList<>();
            for (int i = 0; i <canlilar.length ; i++) {
                if (canlilar[i].getkVirusler() != null){
                    virusler.addAll(canlilar[i].getkVirusler());
                }
            }
            for (int i = 0; i < canlilar.length; i++) {
                ArrayList<Virus> vrs = new ArrayList<>();
                vrs.addAll(canlilar[i].getkVirusler());
                virusler.removeAll(canlilar[i].getkVirusler());
                if (virusler != null){
                    ArrayList<Virus> virus_list = new ArrayList<>();
                    for (int j = 0; j < virusler.size(); j++) {
                        if (virusler.get(j) instanceof Covid19){
                            Virus virus = new Covid19(virusler.get(j).getAd(),virusler.get(j).getBulasmaMiktari(),virusler.get(j).getGuc());
                            virus_list.add(virus);
                        }else if (virusler.get(j) instanceof Covid20){
                            Virus virus = new Covid20(virusler.get(j).getAd(),virusler.get(j).getBulasmaMiktari(),virusler.get(j).getGuc());
                            virus_list.add(virus);

                        }else {
                            Virus virus = new Covid21(virusler.get(j).getAd(),virusler.get(j).getBulasmaMiktari(),virusler.get(j).getGuc());
                            virus_list.add(virus);

                        }
                    }
                    int virus_sayisi = virus_list.size();
                    for (int j = 0; j < virus_sayisi ; j++) {
                        if (j < virus_list.size()) {
                            if (virus_list.get(j) != null) {
                                Virus v = virus_list.get(j);
                                if (v.hastaEdiyormu(canlilar[i])) {
                                    double bulasma_orani_toplam = 0;
                                    int virus_counter = 0;
                                    for (int k = 0; k < virus_list.size(); k++) {
                                        if (virus_list.get(k) != null) {
                                            if (virus_list.get(k).getClass() == v.getClass()) {
                                                double bulasmaMiktariTemp = virus_list.get(k).getBulasmaMiktari();
                                                bulasma_orani_toplam += bulasmaMiktariTemp;
                                                virus_counter++;
                                                virus_list.remove(k);
                                                virus_list.add(k, null);
                                            }
                                        }
                                    }
                                    int a = 999999;
                                    for (int k = 0; k < canlilar[i].kVirusler.size(); k++) {
                                        if (canlilar[i].kVirusler.get(k).getClass() == v.getClass()) {
                                            double bulasmaMiktariTemp = canlilar[i].kVirusler.get(k).getBulasmaMiktari();
                                            bulasma_orani_toplam += bulasmaMiktariTemp;
                                            virus_counter++;
                                            a = k;
                                        }
                                    }
                                    v.setBulasmaMiktari(bulasma_orani_toplam / virus_counter);
                                    Virus virus;
                                    if (v instanceof Covid19){
                                        virus = new Covid19(v.getAd(),v.getBulasmaMiktari(),v.getGuc());
                                    }else if (v instanceof Covid20){
                                        virus = new Covid20(v.getAd(),v.getBulasmaMiktari(),v.getGuc());
                                    }else {
                                        virus = new Covid21(v.getAd(),v.getBulasmaMiktari(),v.getGuc());
                                    }

                                    if (a != 999999) {
                                        canlilar[i].kVirusler.remove(a);
                                        canlilar[i].kVirusler.add(a, virus);
                                    } else {
                                        canlilar[i].kVirusler.add(virus);
                                    }
                                }
                            }
                        }
                    }
                }

                virusler.addAll(vrs);

            }
            int kYiyenler = 0;
            if (this instanceof Karincayiyen){
                kYiyenler++;
            }

            for (int i = 0; i <canlilar.length ; i++) {
                if (canlilar[i] instanceof Karincayiyen){
                    kYiyenler++;
                }
            }
            for (int i = 0; i < canlilar.length; i++) {
                if (canlilar[i].getClass() == Karinca.class){
                    Karinca karinca = (Karinca) canlilar[i];
                    karinca.kYiyenSayisi += kYiyenler;
                }
            }
        }

    }



}



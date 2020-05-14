package com.dogukan.oopvize;

public abstract class Virus implements Comparable{
    public String ad;
    public double bulasmaMiktari;
    public double guc;



    public Virus(String ad, double bulasmaMiktari, double guc)
    {
        this.ad = ad;
        this.bulasmaMiktari = bulasmaMiktari;
        this.guc = guc;

    }

    public Virus (Virus v){
        this.ad = v.getAd();
        this.bulasmaMiktari = v.getBulasmaMiktari();
        this.guc = v.getGuc();
    }


    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public double getBulasmaMiktari() {
        return bulasmaMiktari;
    }

    public void setBulasmaMiktari(double bulasmaMiktari) {
        this.bulasmaMiktari = bulasmaMiktari;
    }

    public double getGuc() {
        return guc;
    }

    public void setGuc(double guc) {
        this.guc = guc;
    }


    public int compareTo(Object o) {
        if (this.getClass() == o.getClass()){
            return 1;
        }else {
            return 0;
        }

    }

    public abstract void mutasyonaUgra(Virus other);
    public abstract boolean hastaEdiyormu(Canli other);




}

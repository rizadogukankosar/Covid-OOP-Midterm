package com.dogukan.oopvize;

public class Covid21 extends Virus {

    public Covid21(String ad, double bulasmaMiktari, double guc) {
        super(ad, bulasmaMiktari, guc);
    }

    @Override
    public void mutasyonaUgra(Virus other) {
        if (other.getClass() == Covid21.class){
            this.setGuc(this.getGuc()*3);
        }
    }

    @Override
    public boolean hastaEdiyormu(Canli other) {
        if(other.getClass() == Insan.class || other.getClass() == Karincayiyen.class){
            return true;
        }else{
            return false;
        }
    }



}

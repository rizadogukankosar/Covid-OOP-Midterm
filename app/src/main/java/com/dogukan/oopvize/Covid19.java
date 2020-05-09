package com.dogukan.oopvize;

public class Covid19 extends Virus{

    public Covid19(String ad, double bulasmaMiktari, double guc) {
        super(ad, bulasmaMiktari, guc);
    }

    @Override
    public void mutasyonaUgra(Virus other) {

        if (other.getClass() == Covid21.class){
            this.setGuc(this.getGuc()*2);
        }

    }

    @Override
    public boolean hastaEdiyormu(Canli other) {
        if(other.getClass() == Insan.class){
            return true;
        }else{
            return false;
        }

    }


}

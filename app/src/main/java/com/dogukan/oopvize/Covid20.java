package com.dogukan.oopvize;

public class Covid20 extends Virus {


    public Covid20(String ad, double bulasmaMiktari, double guc){
        super(ad, bulasmaMiktari, guc);


    }

    @Override
    public void mutasyonaUgra(Virus other) {

    }

    @Override
    public boolean hastaEdiyormu(Canli other) {
        if(other.getClass() == Insan.class  || other.getClass() == Karinca.class  || other.getClass() == Karincayiyen.class ){
            return true;
        }else{
            return false;
        }
    }


}

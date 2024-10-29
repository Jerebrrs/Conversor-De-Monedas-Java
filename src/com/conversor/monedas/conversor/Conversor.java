package com.conversor.monedas.conversor;

import com.conversor.monedas.model.Coins;

public class Conversor {
    public static void convertCurrency(int option, double amount, Coins coins){

        switch (option){
            case 1:{
                double rate = coins.conversion_rates().get("ARS");
                System.out.println("Monto convertido: " + amount * rate + " ARS");
                break;
            }
            case 2, 4, 6: {
                double rate = coins.conversion_rates().get("USD");
                System.out.println("Monto convertido: "+ amount * rate + " USD");
                break;
            }
            case 3:{
                double rate = coins.conversion_rates().get("BRL");
                System.out.println("Monto convertido: "+ amount * rate + " BRL");
                break;
            }
            case 5:{
                double rate = coins.conversion_rates().get("COP");
                System.out.println("Monto convertido: "+ amount * rate +" COP");
                break;
            }
            default : {
                System.out.println("Opción no válida, intente nuevamente.");
                break;
            }
        }

    }
}

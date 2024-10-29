package com.conversor.monedas.principal;

import com.conversor.monedas.conversor.CoinNumber;
import com.conversor.monedas.conversor.Conversor;
import com.conversor.monedas.data.DataApi;
import com.conversor.monedas.model.Coins;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner reading = new Scanner(System.in);
        DataApi dateApiCoins = new DataApi();

        System.out.println("******************************************");
        System.out.println("Sea bienvenido/a al conversor de Monedas de Kevin Jeremias!" + "\n");

        int coinOption;

        do {
            System.out.println(
                    "1) Dólar ==> Peso Argentino.\n" +
                            "2) Peso Argentino ==> Dólar.\n" +
                            "3) Dólar ==> Real Brasileño.\n" +
                            "4) Real Brasileño ==> Dólar.\n" +
                            "5) Dólar ==> Peso Colombiano.\n" +
                            "6) Peso Colombiano ==> Dólar.\n" +
                            "7) Salir.\n" +
                            "Elija una opción válida:");

            coinOption = reading.nextInt();

            if (coinOption == 7) {
                System.out.println("Saliendo del programa.");
                break;
            }

            try {
                String rateOption = CoinNumber.convertCoinNumber(coinOption);
                Coins coins = dateApiCoins.coinInformation(rateOption);

                System.out.println("Ingrese el monto a convertir: ");
                double amount = reading.nextDouble();

                Conversor.convertCurrency(coinOption, amount, coins);
                System.out.println("*************************");
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }

        } while (coinOption != 7);

        reading.close();
    }
}

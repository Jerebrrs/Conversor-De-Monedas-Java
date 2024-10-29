package com.conversor.monedas.conversor;

public class CoinNumber {
    public static String convertCoinNumber(int option) {
        return switch (option) {
            case 1, 3 ,5 -> "USD";
            case 2 -> "ARS";
            case 4 -> "BRL";
            case 6 -> "COP";
            default -> "Opción no válida, intente nuevamente.";
        };
    }
}

package com.company;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static NumberFormat nf = NumberFormat.getInstance();

    public static void main(String[] args) {
        //Initialising Variables
        initializeNumberFormat();
        float priceSum;
        float vat;

        //getting the five prices and the category
        float price1 = getNumberInput();
        String category1 = getNextString();
        float price2 = getNumberInput();
        String category2 = getNextString();
        float price3 = getNumberInput();
        String category3 = getNextString();
        float price4 = getNumberInput();
        String category4 = getNextString();
        float price5 = getNumberInput();
        String category5 = getNextString();

        //Calculating the price and the VAT
        priceSum = addFloats(price1, price2, price3, price4, price5);
        vat = calculateVat(price1, price2, price3, price4, price5, category1, category2, category3, category4, category5);

        //Output of the info
        output(priceSum, vat, 5);
    }

    //Returns the sum of five floats
    private static float addFloats(float a, float b, float c, float d, float e){
        float result;
        result = a + b + c + d + e;
        return result;
    }

    //Returns the VAT percentage of a price total
    private static float calculateVat (float price1, float price2, float price3, float price4, float price5, String category1, String category2, String category3, String category4, String category5){
        float total;
        total = addFloats(getVatByCategory(price1, category1), getVatByCategory(price2, category2), getVatByCategory(price3, category3), getVatByCategory(price4, category4), getVatByCategory(price5, category5));
        return total;
    }

    //Returns the VAT based on the category
    private static float getVatByCategory (float price, String category) {
        if (category.equals("g")) {
            return price * 0.07f;
        }
        if (category.equals("k")) {
            return price *0.19f;
        }
        else return 0;
    }

    //Returns the next float from input
    private static float getNumberInput () {
        System.out.println("Bitte geben Sie einen Preis ein:");
        return scanner.nextFloat();
    }

    //Returns the next String from input
    private static String getNextString () {
        System.out.println("Bitte wählen Sie die Kategorie aus:\n" +
                "1. 'g' für Grundbedarf\n" +
                "2. 'k' für Konsumgüter");
        String scannerValue = scanner.nextLine();
        //System.out.println("Bitte geben Sie 'g' oder 'k' ein.");
        scannerValue = scanner.nextLine();
        return scannerValue;
    }

    //Prints out the total, the VAT amount and the number of items
    private static void output(float total, float vat, int numberOfItems){
        System.out.println("Der Preis beträgt: " + nf.format(total) + "€");
        System.out.println("Die Mehrwertsteuer beträgt: " + nf.format(vat) + "€");
        System.out.println("Die Anzahl Artikel breträgt: " + numberOfItems);
    }

    //Sets the rounding mode and the amount of fractional digits
    private static void initializeNumberFormat(){
        nf.setRoundingMode(RoundingMode.HALF_UP);
        nf.setMaximumFractionDigits(2);
    }
}


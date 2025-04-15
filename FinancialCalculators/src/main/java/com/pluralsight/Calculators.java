package com.pluralsight;
import java.util.Scanner;
public class Calculators {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Which calculator would you like to use? (1/2/3) ");
        int calcType = scanner.nextInt();
        scanner.nextLine();

        if(calcType == 1) {
            mortgageCalc(scanner);
        } else if (calcType == 2) {
            futureValCalc(scanner);
        } else if (calcType == 3) {
            presentValCalc(scanner);
        }
    }

    public static void mortgageCalc (Scanner scanner) {

        System.out.print("Enter your loan amount: ");
        double p = scanner.nextDouble();

        System.out.print("Enter your annual interest rate: ");
        double r = scanner.nextDouble();

        System.out.print("Enter loan length (in years): ");
        int y = scanner.nextInt();
        scanner.nextLine();

        double decimalR = r / 100;
        double i = decimalR / 12;
        double n = 12 * y;
        double interestPow = Math.pow((1 + i), n);
        double m = p * (i * interestPow / (interestPow  - 1));
        float newM = (float) m;
        double totalInterest = (m * n) - p;

        System.out.printf("Your expected monthly payment is $%.2f/month %n", newM);
        System.out.printf("with a total interest of $%.2f for %d years", totalInterest, y);

    }

    public static void futureValCalc (Scanner scanner) {

        System.out.print("How much are you depositing? ");
        double p = scanner.nextDouble();

        System.out.print("Enter your interest rate: ");
        double r = scanner.nextDouble();

        System.out.print("Enter number of years: ");
        int t = scanner.nextInt();
        scanner.nextLine();

        int numOfDays = 365 * t;
        double decimalR = r /100;
        double fV = p * (Math.pow(1 + (decimalR / 365), numOfDays));
        double totalInterest = fV - p;

        System.out.printf("The future value of your CD is $%.2f %n", fV);
        System.out.printf("and the total interest earned is $%.2f ", totalInterest);
    }

    public static void presentValCalc (Scanner scanner) {
        System.out.print("Enter monthly payout: ");
        double c = scanner.nextDouble();

        System.out.print("Enter your interest rate: ");
        double i = scanner.nextDouble() ;

        System.out.print("Enter number of years: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        double iPerMonth = (i / 100) / 12;
        int numOfPayments = n * 12;
        double numerator = 1 - Math.pow((1 + iPerMonth), (-1 * numOfPayments));
        double pV = c * (numerator / iPerMonth);

        System.out.printf("The present value of annuity is $%.2f", pV);

    }
}

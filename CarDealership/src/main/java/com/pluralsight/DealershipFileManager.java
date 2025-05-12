package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {


    public Dealership getDealership() {
        Dealership dealership = null;
        ArrayList<Vehicle> inventory = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));

            String line;
            line = bufferedReader.readLine();
            String[] dealershipInfo = line.split("\\|");
            String name = dealershipInfo[0];
            String address = dealershipInfo[1];
            String number = dealershipInfo[2];
            dealership = new Dealership(name, address, number, inventory);

            while((line = bufferedReader.readLine()) != null) {
                String[] details = line.split("\\|");
                int vin = Integer.parseInt(details[0]);
                int year = Integer.parseInt(details[1]);
                String make = details[2];
                String model = details[3];
                String vehicleType = details[4];
                String color = details[5];
                int odometer = Integer.parseInt(details[6]);
                double price = Double.parseDouble(details[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                inventory.add(vehicle);
            }

            bufferedReader.close();
        }
        catch(IOException e) {
            System.out.println("File not found");
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inventory.csv"));


            bufferedWriter.close();

        }
        catch(IOException e) {
            e.getStackTrace();
        }
    }
}

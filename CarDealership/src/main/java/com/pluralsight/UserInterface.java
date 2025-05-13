package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
        this.dealership = init();
    }

    public void display(Scanner scanner) {
        int command = getCommand(scanner);

        switch(command) {
            case 1:
                processGetByPriceRequest(scanner);
                break;
            case 2:
                processGetByMakeModelRequest(scanner);
                break;
            case 3:
                processGetByYearRequest(scanner);
                break;
            case 4:
                processGetByColorRequest(scanner);
                break;
            case 5:
                processGetByMileageRequest(scanner);
                break;
            case 6:
                processGetByVehicleTypeRequest(scanner);
                break;
            case 7:
                processGetAllVehiclesRequest();
                break;
            case 8:
                break;
            case 9:
                break;
            case 99:
                break;
        }

    }

    private Dealership init() {

        DealershipFileManager dealershipFileManager = new DealershipFileManager();

        return dealershipFileManager.getDealership();
    }

    private void displayVehicles(List<Vehicle> filteredVehicles) {
        for(Vehicle vehicle : filteredVehicles) {
            System.out.println(vehicle);
        }
    }

    public void processGetByPriceRequest(Scanner scanner) {
        System.out.print("Enter a minimum price to search: ");
        double min = scanner.nextDouble();
        System.out.print("Enter a maximum price to search: ");
        double max = scanner.nextDouble();

        List<Vehicle> results = dealership.getVehiclesByPrice(min, max);
        displayVehicles(results);

    }

    public void processGetByMakeModelRequest(Scanner scanner) {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        List<Vehicle> results = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(results);
    }

    public void processGetByYearRequest(Scanner scanner) {
        System.out.print("Enter oldest year to search:  ");
        int minYear = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter recent year to search: ");
        int maxYear = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> results = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(results);
    }

    public void processGetByColorRequest(Scanner scanner) {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        List<Vehicle> results = dealership.getVehiclesByColor(color);
        displayVehicles(results);
    }

    public void processGetByMileageRequest(Scanner scanner) {
        System.out.print("Enter minimum mileage: ");
        double minMileage = scanner.nextDouble();
        System.out.print("Enter maximum mileage: ");
        double maxMileage = scanner.nextDouble();

        List<Vehicle> results = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayVehicles(results);
    }

    public void processGetByVehicleTypeRequest(Scanner scanner) {
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();

        List<Vehicle> results = dealership.getVehiclesByType(vehicleType);
        displayVehicles(results);
    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    public int getCommand(Scanner scanner) {
        System.out.println("What would you like to do?");
        System.out.println("1 - Find vehicle within a price range");
        System.out.println("2 - Find vehicles by make.model");
        System.out.println("3 - Find vehicles by year model");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage range");
        System.out.println("6 - Find vehicles by type(car, truck etc.)");
        System.out.println("7 - List all vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
        System.out.print("Enter command: ");
        int command = scanner.nextInt();
        scanner.nextLine();

        return command;
    }
}

package lesson3.labs.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Apartment> apartments;
    private double maintenanceCost;

    public Building(double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
        apartments = new ArrayList<>();
    }

    public void addApartment(Apartment apartment){
        apartments.add(apartment);
    }

    public double calcProfits(){
        double profits = 0;
        for (Apartment apartment:
             apartments) {
            profits+=apartment.getRent();
        }
        return profits-maintenanceCost;
    }
}

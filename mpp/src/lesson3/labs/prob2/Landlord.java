package lesson3.labs.prob2;

import java.util.ArrayList;
import java.util.List;

public class Landlord {
    private List<Building> buildings = new ArrayList<>();

    public void addBuilding(Building building){
        buildings.add(building);
    }

    public double monthProfits(){
        double profits = 0;
        for (Building building:
                buildings) {
            profits+=building.calcProfits();
        }
        return profits;
    }
}

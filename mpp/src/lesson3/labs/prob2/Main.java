package lesson3.labs.prob2;

public class Main {

    public static void main(String[]args){
        Landlord landlord = new Landlord();

        Apartment apt1 = new Apartment(200);
        Apartment apt2 = new Apartment(250);
        Apartment apt3 = new Apartment(222);

        Building building = new Building(99);
        building.addApartment(apt1);
        building.addApartment(apt2);
        building.addApartment(apt3);

        landlord.addBuilding(building);

        System.out.println(landlord.monthProfits());

    }

}

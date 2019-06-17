package lesson9.labs.prob9;
import java.util.*;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type { MEAT, FISH, OTHER }

    @Override
    public String toString() {
        return name;
    }

    public static final List<Dish> menu =
            Arrays.asList( new Dish("pork", false, 800, Type.MEAT),
                           new Dish("beef", false, 700, Type.MEAT),
                           new Dish("chicken", false, 400, Type.MEAT),
                           new Dish("french fries", true, 530, Type.OTHER),
                           new Dish("rice", true, 350, Type.OTHER),
                           new Dish("season fruit", true, 120, Type.OTHER),
                           new Dish("pizza", true, 550, Type.OTHER),
                           new Dish("prawns", false, 400, Type.FISH),
                           new Dish("salmon", false, 450, Type.FISH));


    public static boolean anyVegetarianMealAvailable(List<Dish> list){
        return list.stream().filter(dish -> dish.vegetarian==true).findAny().isPresent();
    }

    public static boolean caloriesLessThan1000(List<Dish> list){
        return list.stream().filter(dish -> dish.calories<1000).findAny().isPresent();
    }

    public static boolean caloriesGreaterThan1000(List<Dish> list){
        return list.stream().filter(dish -> dish.calories>1000).findAny().isPresent();
    }

    public static Optional<Dish> theFirstMEATItem(List<Dish> list){
        return list.stream().filter(dish -> dish.type== Type.MEAT).findFirst();
    }

    public static int calculateTotalCalories(){
        return menu.stream().map(dish -> dish.calories).reduce((a,b)->a+b).get();
    }

    public static int calculateTotalCaloriesMethodReference(){
        return menu.stream().map(Dish::getCalories).reduce(Math::addExact).get();
    }



    public static void main(String[]args){
        System.out.println(anyVegetarianMealAvailable(menu));
        System.out.println(caloriesLessThan1000(menu));
        System.out.println(caloriesGreaterThan1000(menu));
        System.out.println(theFirstMEATItem(menu));
        System.out.println(calculateTotalCalories());
        System.out.println(calculateTotalCaloriesMethodReference());
    }
}
package lesson7.labs.prob2;

public interface Polygon {
    double[] getSides();
    default double computePerimeter(){
        double sum = 0;
        for (double d:
             getSides()) {
            sum+=d;
        }
        return sum;
    }
}

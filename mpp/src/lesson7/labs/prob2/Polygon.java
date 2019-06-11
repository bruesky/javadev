package lesson7.labs.prob2;

public interface Polygon extends ClosedCurve {
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

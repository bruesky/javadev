package lesson7.labs.prob2;

public class Ellipse implements Polygon {
    private double a;
    private double E;

    public Ellipse(double a, double e) {
        this.a = a;
        E = e;
    }

    @Override
    public double[] getSides() {
        return new double[]{4*a*E};
    }
}

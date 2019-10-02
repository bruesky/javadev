package edu.mum.model;

public class Calculator {
    private int add1;
    private int add2;
    private int mult1;
    private int mult2;
    private String sum;
    private String product;

    public void calcSum(){
        sum+=(add1+add2);
    }

    public void calcProduct(){
        product+=(mult1*mult2);
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getAdd1() {
        return add1;
    }

    public void setAdd1(int add1) {
        this.add1 = add1;
    }

    public int getAdd2() {
        return add2;
    }

    public void setAdd2(int add2) {
        this.add2 = add2;
    }

    public int getMult1() {
        return mult1;
    }

    public void setMult1(int mutl1) {
        this.mult1 = mutl1;
    }

    public int getMult2() {
        return mult2;
    }

    public void setMult2(int mutl2) {
        this.mult2 = mutl2;
    }
}

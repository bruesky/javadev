package lesson8.labs.d2prob1;

import java.util.Objects;
import java.util.function.Function;

public class MyClass {
    int x;
    double y;
    private Function<MyClass,Boolean> bf = this::equals;

    public MyClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return x == myClass.x &&
                y == myClass.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public void myMethod(MyClass c){
        System.out.println(bf.apply(c));
    }

    public static void main(String[] args){
        MyClass myClass = new MyClass(1,2);
        myClass.myMethod(new MyClass(1,2));
    }
}

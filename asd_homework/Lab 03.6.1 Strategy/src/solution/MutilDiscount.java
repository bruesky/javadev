package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MutilDiscount extends DiscountStrategy {

    private List<DiscountStrategy> discountStrategies = new ArrayList<>();

    public void addDiscountStrategy(DiscountStrategy discountStrategy){
        this.discountStrategies.add(discountStrategy);
    }

    @Override
    public String getName() {
        String ret = "";
        if (discountStrategies != null){
            ret = discountStrategies.stream().map(d->d.getName()).collect(Collectors.joining("+"));

        }
        return ret;
    }

    @Override
    public double getDiscount(int quantity, double unitPrice)
    {
        double dis = 1.0;
        for (DiscountStrategy d:
                discountStrategies) {
            dis*=(1-d.getDiscount(quantity,unitPrice*dis));
        }
        return 1-dis;
    }
}

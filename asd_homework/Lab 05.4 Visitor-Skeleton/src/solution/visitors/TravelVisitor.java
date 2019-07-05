package solution.visitors;

import solution.deal.*;
import solution.visitors.Visitor;

import java.util.HashMap;
import java.util.Map;

public class TravelVisitor extends Visitor {
    private double cost = 0.0;
    private Map<String,Double> desAndcost = new HashMap<>();

    @Override
    public Object getState() {
        return cost;
    }

    public void execute(SalesConsultant salesConsultant)
    {
        for (Deal deal : salesConsultant.getDeals())
            deal.acceptVisitor(this);
    }


    public void execute(Deal deal)
    {
        for (Event event : deal.getEvents())
            event.acceptVisitor(this);
    }

    public void execute(Event event)
    {
        for (Order order : event.getOrders())
            order.acceptVisitor(this);

        if (event.getTravel() != null){
            cost += event.getTravel().getCost();
            String des = event.getTravel().getDestination();
            if (!desAndcost.containsKey(des)){
                desAndcost.put(des, event.getTravel().getCost());
            }else {
                desAndcost.put(des, desAndcost.get(des)+event.getTravel().getCost());
            }
        }
    }

    public Map<String,Double> getDesAndCost(){
        return desAndcost;
    }
}

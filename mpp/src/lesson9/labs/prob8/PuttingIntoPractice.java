package lesson9.labs.prob8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class PuttingIntoPractice{
    public static void main(String ...args){    
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
        
        
        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        transactions.stream()
                    .filter(transaction -> transaction.getYear()>2011)
                    .sorted(Comparator.comparing(Transaction::getValue))
                    .forEach(System.out::println);

        
        // Query 2: What are all the unique cities where the traders work?
//        transactions.stream()
        transactions.stream().map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        

        // Query 3: Find all traders from Cambridge and sort them by name.
        transactions.stream().map(transaction -> transaction.getTrader())
                             .filter(trader -> trader.getCity().compareTo("Cambridge")==0)
                             .distinct()
                             .sorted(Comparator.comparing(Trader::getName))
                             .forEach(System.out::println);
        
   
        
        // Query 4: Return a string of all traders names sorted alphabetically.
        transactions.stream().map(transaction -> transaction.getTrader().getName())
                            .distinct()
                            .sorted()
                            .forEach(System.out::println);
        

        // Query 5: Are there any trader based in Milan?
        transactions.stream().map(transaction -> transaction.getTrader())
                            .distinct()
                            .filter(trader -> trader.getCity().compareTo("Milan")==0)
                            .forEach(System.out::println);
        
   
     // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        transactions.stream().map(transaction ->{
            if (transaction.getTrader().getCity().compareTo("Milan")==0)
                transaction.getTrader().setCity("Cambridge");
            return transaction;
        }).forEach(System.out::println);
        
        // Query 7: What's the highest value in all the transactions?
        int max = transactions.stream().map(transaction -> transaction.getValue())
                    .collect(Collectors.summarizingInt(n->n)).getMax();
        System.out.println(max);
    }
}

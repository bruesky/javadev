package lesson7.lecture.hashcode.bad3;

import java.util.HashSet;
import java.util.Set;

/**
 * Illustrates importance of using immutable objects
 * as keys in a hashtable
 */
public class Point {
	
		  private int x;
		  private int y;
		  
		  public Point(int x, int y) {
		    this.x = x;
		    this.y = y;
		  }

		  public int getX() {
		    return x;
		  }

		  public void setX(int x) {
		    this.x = x;
		  }

		  public int getY() {
		    return y;
		  }

		  public void setY(int y) {
		    this.y = y;
		  }
		  
		  public boolean equals(Object obj) {
		    if(obj == null) {
		      return false;
		    }
		    if(obj.getClass() != this.getClass()) {
		      return false;
		    }
		    Point other = (Point) obj;
		    return (other.x == this.x) && (other.y == this.y);
		  }
		  
		  @Override
		  public String toString() {
			  return "[" + x + ", " + y + "]";
		  }
		  
		  public int hashCode() {
		    int hash = 7;
		    hash = 31 * hash + this.x;
		    hash = 31 * hash + this.y;
		    return hash;
		  }
		  public static void main(String[] args) {
			    Point a = new Point(5,5);
			    Set<Point> set = new HashSet<>();
			    
			    set.add(a); // Set the Point with 5,5
			    System.out.println(set);
			    
			    a.setX(8); // Without hashing modify the key as 8
			    System.out.println(set); // Print 8,5
			    /* 8,5 not hashed in the table. 
			     * contains method first hash the key value and search  8,5 
			     * but no values in that location of hash table*/
			    System.out.println(set.contains(a)); 
			    
			    set.add(a);
			    System.out.println(set);
			    System.out.println(set.contains(a)); // The key is hashed and not modified
			    System.out.println("Size : " + set.size()); // size becomes two.
			    
			    set.remove(a); // Remove the 8,5 , which is added by the line : 72
			    System.out.println("Size : " + set.size()); // size becomes 1
			    
			    // Why this remove is not working
			   set.remove(a); // because the key is modified without hashing
			    System.out.println("Size : " + set.size()); // Size returns 1
			   
	  }
}

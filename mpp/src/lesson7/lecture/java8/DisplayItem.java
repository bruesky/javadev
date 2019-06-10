package lesson7.lecture.java8;

import java.time.LocalDate;

public interface DisplayItem {
	String getOwner();
	abstract public LocalDate getDateToReturnToOwner();
	// Interface fields are by default public static final, so its immutable
	// Setter need to be provide in classes which implements Interface 
	public default void setOwner(String s) {
		//by default, object is not mutable
	};
	public default void setDateToReturnToOwner(LocalDate d) {
		//by default, object is not mutable
	};
	 
	public default String displayInfo() {
		return getOwner() + ": " + this.getClass().getSimpleName() 
			+ ": " + getDateToReturnToOwner();
	}
	
	
}

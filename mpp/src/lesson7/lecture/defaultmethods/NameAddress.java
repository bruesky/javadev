package lesson7.lecture.defaultmethods;

public interface NameAddress {
	// Pre Java - 8 - Unimplemented methods
	String getFirstName();
	String getLastName();
	String getStreet();
	String getCity();
	String getState();
	// Java 8 - Implemented Methods
	default String getFullName() {
		return getFirstName() + " " + getLastName();
	}
	default String getFullAddress() {
		return getStreet() + "\n" + getCity() + ", " + getState();
	}
	default String formattedOutput() {
		return getFullName() + "\n" + getFullAddress();
	}
	
}

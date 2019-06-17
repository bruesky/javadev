package lesson10.labs.prob1;
import java.util.*;
public class Group<T> {
	private T specialElement;
	private List<T> elements = new ArrayList<>();
	public Group(T special, List<T> elements) {
		this.specialElement = special;
		this.elements = elements;
	}
	public T getSpecialElement() {
		return specialElement;
	}
	public List<T> getElements() {
		return elements;
	}
	@Override
	public String toString() {
		return "[special : " + specialElement.toString() 
		    + ", elements :\n   " + elements.toString() + "]";
	}

	public static <T> void copy(List<? super T> destination,
								List<? extends T> source) {
		for(int i = 0; i < source.size(); ++i) {
			destination.set(i, source.get(i));
		}
	}

	public static <T> Group<T> helper(Group<T> group){
		List<T> elements = group.getElements();
		Group<T> grp = new Group<T>(group.getSpecialElement(), elements);
		return grp;
	}

	public static Group<?> copy(Group<?> group){

		return helper(group);
	}

	public static void main(String[]args){
		Group<String> group = new Group<>("Java",Arrays.asList("C++","C#","Java","Kotlin"));
		System.out.println(group);
		System.out.println(copy(group));
	}
	
	
}

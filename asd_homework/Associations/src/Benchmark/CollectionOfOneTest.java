package Benchmark;

import static org.junit.Assert.*;

import Framework.ManyToMany;
import Framework.OneToOne;
import org.junit.Test;


public class CollectionOfOneTest {
	private OneToOne<String,String> testOneToOne = new OneToOne<>("get","is got","name","mark");
	private ManyToMany<String,String> testManyToMany = new ManyToMany<>("get","are got","name","marks");
	@Test
	public final void testGetMultiplicityName() {
		System.out.println("====testGetMultiplicityName====");
		System.out.println(testOneToOne.rightMultiplicityName());
		System.out.println(testOneToOne.leftMultiplicityName());
		System.out.println(testManyToMany.rightMultiplicityName());
	}

	@Test
	public final void testLink() {
		System.out.println("====testLink====");
		testOneToOne.link("David","A");
	}

	@Test
	public final void testIsLinked() {

		testOneToOne.link("David","A");
		System.out.println(testOneToOne.isLinked("David","A"));
		System.out.println(testOneToOne.isLinked("David","B"));
	}

	@Test
	public final void testUnlink() {
		System.out.println("====testUnlink====");
		testOneToOne.link("David","A");
		testOneToOne.unlink("David","A");
		System.out.println(testOneToOne.leftToRight("David"));
	}

	@Test
	public final void testUnlinkFrom() {
		System.out.println("====testUnlinkFrom====");
		testOneToOne.link("David","A");
		testOneToOne.unlinkLeft("David");
		System.out.println(testOneToOne.leftToRight("David"));
	}

	@Test
	public final void testIsLinkedTo() {
		System.out.println("====testIsLinkedTo====");
		testOneToOne.link("David","A");
		System.out.println(testOneToOne.leftToRight("David"));
		System.out.println(testOneToOne.leftToRight("Cu"));
	}

	@Test
	public final void testMultiplicities() {
		System.out.println("====testMultiplicities====");
		testOneToOne.link("David","A");
		System.out.println(testOneToOne.leftToRight("David"));
		System.out.println(testOneToOne.rightToLeft("A"));
	}

}

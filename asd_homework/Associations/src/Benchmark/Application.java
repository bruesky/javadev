package Benchmark;

import Framework.*;
import java.util.List;

public class Application 
{
	private String[] grades = 
		{
				"Alpha 01", "Beta 02", "Kappa 03", "Delta 04", "Epsilon 05", "Phi 06", "Gamma 07", "Hotel 08", "India 09", "Juliet 10", "Kilo 11"
		};
	private int gradesSize = grades.length;
	private String allGrades()
	{
		String report = new String();
		for (String grade : grades) report += "{" + grade + "} ";
		return report;
	}
	
	private Account[] accounts = 
		{
			new Account(0,"Alpha"), new Account(2, "Bravo"), new Account(3, "Charlie"), new Account(4, "Delta"), 
			new Account(5, "Echo"), new Account(6, "Foxtrot"), new Account(7, "Golf")
		};
	
	
	private int accountsSize = accounts.length;
	
	private Person[] persons =
		{
			new Person("John Smith", "478-01-0000"), new Person("Jerry Lewis", "478-02-0001" ), new Person("Bob Williams", "478-03-0002" ),
			new Person("Jim Barnes", "478-04-0003"), new Person("Aaron Stalks", "478-05-0004"), new Person("Dominique Scenes", "478-05-0005")
		};
	private int personsSize = persons.length;
	
	Authorization[] authorizations = 
		{
			new Authorization("06/04/2014",0), new Authorization("07/05/2015", 1), new Authorization("08/06/2016", 2), new Authorization("09/07/2017", 3), 
			new Authorization("10/08/2018", 4), new Authorization("11/09/2019", 5), new Authorization("12/10/2020", 6), new Authorization("01/11/2021", 7), 
			new Authorization("02/12/2022", 8), new Authorization("03/01/2023", 9)
		};
	
	Project projects[] = 
	{
		new Project("General Audit 01", 1), new Project("Accounting Audit 02", 2), new Project("Production Audit 03", 3)
	};
	
	private int i = 0, john = i++, jerry = i++, bob = i++, jim = i++, aaron = i++, dominique = i++;
	private int j = 0, alpha = j++, bravo = j++, charlie = j++, delta = j++, echo = j++, foxtrot = j++, golf = j++;
	private int k = 0, general = k++, accounting = k++, production = k++, numberOfProjects = k;

	public void showAllObjects()
	{
		System.out.println(Account.report());
		System.out.println(allGrades());		
	}
	
	@SuppressWarnings("unused")
	public static void main(String args[])
	{
		Application application = new Application();
		
		System.out.println("---Associations Framework---" + "\n");
		if (false)
			application.testCollectionOfOne();
		if (false)
			application.testOneToOne();
		if (false)
			application.testCollectionOfMany();
		if (true)
			application.testOneToMany();
		if (true)
			application.testManyToOne();
		if (true)
			application.testManyToMany();
		if (true)
			application.testAssociationClass();
		if (true)
			application.testTernaryAssociationClass();
	}
	
	private class OneToOneBenchmark
	{
		
		public OneToOne<Account, String> isGradedAs = new OneToOne<>("Is graded as", "Is the grade for", "Graded Item", "Grade");
	
		public void showAccountsLinks()
		{
			System.out.println("All account links");
	
			for (int i = 0; i < accountsSize; i++)
			{
				Account acct = accounts[i];
				String grade = isGradedAs.leftToRight(acct);
				System.out.println("Account: " + acct.description() + "is linked to: " + (grade != null ? grade : "nothing."));
			}
		}
		
		public void showGradesLinks()
		{
			System.out.println("All grade links");
	
			for (int i = 0; i < gradesSize; i++)
			{
				String str = grades[i];
				Account account = isGradedAs.rightToLeft(str);
				System.out.println("String: " + str + " is linked to: " + (account != null ? account.description() : "nothing."));
			}
		}
		
		public void test()
		{
			System.out.println("testOneToOne");
			showAllObjects();
			System.out.println(isGradedAs.report());
			
			for (int i = 0; i < accountsSize && i < gradesSize; i++)
				isGradedAs.link(accounts[i], grades[i]);
			
			showAccountsLinks();
			System.out.println("Testing the right-hand side now...");
			showGradesLinks();			
		}
	};
	
	private class CollectionOfManyBenchmark
	{
		private CollectionOfMany<Account, String> appraisals = new CollectionOfMany<>();
		
		private void showLinks(Account account)
		{
			List<String> gradeList = appraisals.isLinkedToCollection(account);
			System.out.println(account.description() + " is appraised as:");
			for (String grade : gradeList)
				System.out.println("   " + grade);
		}
		
		public void test()
		{
			System.out.println("Testing Collection Of Many: ");
			appraisals.link(accounts[0], grades[0]);
			appraisals.link(accounts[0], grades[1]);
			appraisals.link(accounts[0], grades[2]);
			appraisals.link(accounts[1], grades[3]);
			appraisals.link(accounts[1], grades[4]);
			appraisals.link(accounts[1], grades[5]);
			
			for (Account account : accounts) showLinks(account);
			
			System.out.println("Removing a couple of links");
			appraisals.unlink(accounts[0], grades[2]);
			appraisals.unlink(accounts[1], grades[5]);
			appraisals.unlink(accounts[2], grades[0]);				// Was never linked--just a tricked command
			appraisals.link(accounts[0], grades[0]);				// Was already linked--just a tricked command
			
			for (Account account : accounts) showLinks(account);
			
			System.out.println("Removing all links from: " + accounts[0].description());
			appraisals.unlinkFrom(accounts[0]);
			
			for (Account account : accounts) showLinks(account);

			System.out.println(accounts[0].description() + " and " + grades[0] + " are linked: " + appraisals.isLinked(accounts[0], grades[0]));
			System.out.println(accounts[1].description() + " and " + grades[3] + " are linked: " + appraisals.isLinked(accounts[1], grades[3]));
			System.out.println(accounts[1].description() + " and " + grades[4] + " are linked: " + appraisals.isLinked(accounts[1], grades[4]));
			
			for (Account account : accounts) showLinks(account);
			
			System.out.println("Reassigning a couple of links");
			appraisals.unlink(accounts[1], grades[3]);
			appraisals.link(accounts[1], grades[1]);
			appraisals.unlink(accounts[1], grades[4]);
			appraisals.link(accounts[1], grades[5]);
			
			for (Account account : accounts) showLinks(account);
			
		}
	}
	
	private class OneToManyBenchmark
	{
		private OneToMany<Account, String> accountIsGradedAsGrade = new OneToMany<>("Is Graded As", "Is the grade for", "Account", "Grade");
		
		private void buildLinks()
		{
			accountIsGradedAsGrade.link(accounts[0], grades[0]);	// Have 3 links
			accountIsGradedAsGrade.link(accounts[0], grades[1]);
			accountIsGradedAsGrade.link(accounts[0], grades[2]);
			
			accountIsGradedAsGrade.link(accounts[1], grades[3]);	// Have 2 links
			accountIsGradedAsGrade.link(accounts[1], grades[4]);
			
			accountIsGradedAsGrade.link(accounts[2], grades[5]);	// Have 1 link
			
			accountIsGradedAsGrade.link(accounts[3], grades[6]);	// Have 4 links
			accountIsGradedAsGrade.link(accounts[3], grades[7]);	
			accountIsGradedAsGrade.link(accounts[3], grades[8]);	
			accountIsGradedAsGrade.link(accounts[3], grades[9]);	
		}
		
		private void editLinks()
		{
			System.out.println(accounts[4].description() + " is getting: " + grades[0] + " and " + grades[6]);
			accountIsGradedAsGrade.link(accounts[4], grades[0]);	
			accountIsGradedAsGrade.link(accounts[4], grades[6]);	
			System.out.println(accounts[1].description() + " is getting unlinked from all, and " + grades[7] + " too...");
			accountIsGradedAsGrade.unlinkLeft(accounts[1]);
			accountIsGradedAsGrade.unlinkRight(grades[7]);
		}
		
		private void showLinks()
		{
			for (Account account : accounts)
			{
				List<String> gradeList = accountIsGradedAsGrade.leftToRights(account);
				System.out.println(account.description() + " " + accountIsGradedAsGrade.leftToRightName() + ": ");
				for (String grade : gradeList)
					System.out.println("\t" + grade);
			}
			
			for (String grade : grades)
			{
				Account account = accountIsGradedAsGrade.rightToLeft(grade);
				System.out.println(grade + " " + accountIsGradedAsGrade.rightToLeftName() + ": " + (account != null ? account.description() : "none"));
			}
			
			for (String grade : grades)
			{
				List<Account> accounts = accountIsGradedAsGrade.rightToLefts(grade);
				System.out.println(grade + " " + accountIsGradedAsGrade.rightToLeftName() + ": ");
				for (Account account : accounts)
					System.out.println("\t" + account.description());
			}
			
		}
		
		public void run()
		{
			System.out.println(accountIsGradedAsGrade.report());
			buildLinks();
			showLinks();
			System.out.println("Changing a few links...");
			editLinks();
			showLinks();
		}
	}

	private class ManyToOneBenchmark
	{
		private ManyToOne<Account, String> gradeHistory = new ManyToOne<>("Has been graded as", "Has graded", "Account", "Grade");
		
		private void buildLinks()
		{
			gradeHistory.link(accounts[0], grades[0]);
			gradeHistory.link(accounts[1], grades[0]);
			gradeHistory.link(accounts[2], grades[0]);
			gradeHistory.link(accounts[3], grades[0]);
			gradeHistory.link(accounts[3], grades[1]);	// Should replace the previous one, right?
			gradeHistory.link(accounts[4], grades[1]);
			gradeHistory.link(accounts[5], grades[1]);
			gradeHistory.link(accounts[6], grades[2]);
		}
		
		private void showLinks()
		{
			for (String grade : grades)
			{
				List<Account> accountList = gradeHistory.rightToLefts(grade);
				System.out.println(grade + " " + gradeHistory.rightToLeftName() + ": ");
				for (Account account : accountList)
					System.out.println("\t" + account);
			}
			
			for (Account account : accounts)
			{
				String grade = gradeHistory.leftToRight(account);
				System.out.println(account + " " + gradeHistory.leftToRightName() + ": " + (grade != null ? grade : "none"));
			}			
		}
		
		public void run()
		{
			System.out.println(gradeHistory);
			buildLinks();
			showLinks();
		}
	}

	private class ManyToManyBenchmark
	{
		private ManyToMany<Person, Account> personOwnsAccounts = new ManyToMany<>("Owns", "Is Owned By", "Person", "Account");
		
		private void createLinks()
		{
			personOwnsAccounts.link(persons[0], accounts[0]);
			personOwnsAccounts.link(persons[0], accounts[1]);
			personOwnsAccounts.link(persons[0], accounts[2]);
			personOwnsAccounts.link(persons[1], accounts[2]);
			personOwnsAccounts.link(persons[1], accounts[3]);
			personOwnsAccounts.link(persons[1], accounts[4]);
			personOwnsAccounts.link(persons[2], accounts[4]);
			personOwnsAccounts.link(persons[2], accounts[5]);
			personOwnsAccounts.link(persons[2], accounts[6]);
			personOwnsAccounts.link(persons[2], accounts[6]);	// See if it will repeat--it shouldn't
			personOwnsAccounts.link(persons[3], accounts[0]);
			personOwnsAccounts.link(persons[3], accounts[1]);
			personOwnsAccounts.link(persons[3], accounts[2]);
			personOwnsAccounts.link(persons[3], accounts[3]);
			personOwnsAccounts.link(persons[3], accounts[4]);
			personOwnsAccounts.link(persons[3], accounts[5]);
			personOwnsAccounts.link(persons[3], accounts[6]);
		}
		
		private void editLinks()
		{
			System.out.println("Unlinking " + persons[3] + " from all...");
			personOwnsAccounts.unlinkLeft(persons[3]);
			
			System.out.println("Unlinking " + accounts[6] + " from all...");
			personOwnsAccounts.unlinkRight(accounts[6]);
		}
		
		private void showLinks()
		{
			StringBuilder report = new StringBuilder();
			
			for (Person person : persons)
			{
				report.append(person + " " + personOwnsAccounts.leftToRightName() + ": \n");
				List<Account> accountsList = personOwnsAccounts.leftToRights(person);
				if (accountsList.size() > 0)
					for (Account account : accountsList)
						report.append("\t" + account + "\n");	
				report.append("\n");
			}
			System.out.println(report + "\n");
			
			report = new StringBuilder();
			
			for (Account account : accounts)
			{
				report.append(account + " " + personOwnsAccounts.rightToLeftName() + ": \n");
				List<Person> personsList = personOwnsAccounts.rightToLefts(account);
				if (personsList.size() > 0)
					for (Person person : personsList)
						report.append("\t" + person + "\n");
				report.append("\n");
			}
			System.out.println(report);
		}
		
		private void showLink(Person p, Account a)
		{
			System.out.println(p + " " + personOwnsAccounts.leftToRightName() + " " + a + " is: " + personOwnsAccounts.isLinked(p, a));
		}
		
		private void testIsLinked()
		{
			showLink(persons[0], accounts[0]);
			showLink(persons[0], accounts[1]);
			showLink(persons[1], accounts[1]);
			showLink(persons[1], accounts[2]);
			showLink(persons[2], accounts[2]);
			showLink(persons[2], accounts[5]);
		}
		
		public void run()
		{
			System.out.println(personOwnsAccounts);
			createLinks();
			showLinks();
			editLinks();
			showLinks();
			testIsLinked();
		}
	}
	
	private class SimpleAssociationClassBenchmark
	{
		private Association.Multiplicity ZeroOrMore = Association.Multiplicity.ZeroOrMore;
		private Association.Multiplicity ZeroOrOne = Association.Multiplicity.ZeroOrOne;
		
		private AssociationClass<Authorization, Person, Account> isAuthorizedToAccess = 
				new AssociationClass<>("Is Authorized To Access", "Can Be Accessed By", ZeroOrMore, ZeroOrMore, "Manager", "Asset", "Authorization");

		StringBuilder result = new StringBuilder();
		
		private void createLinks()
		{
			isAuthorizedToAccess.link(authorizations[0], persons[john], accounts[alpha]);
			isAuthorizedToAccess.link(authorizations[1], persons[john], accounts[bravo]);
			isAuthorizedToAccess.link(authorizations[2], persons[john], accounts[charlie]);
			isAuthorizedToAccess.link(authorizations[3], persons[john], accounts[charlie]);
			isAuthorizedToAccess.link(authorizations[5], persons[aaron], accounts[echo]);
			isAuthorizedToAccess.link(authorizations[4], persons[jerry], accounts[alpha]);
			isAuthorizedToAccess.link(authorizations[6], persons[aaron], accounts[delta]);
			isAuthorizedToAccess.link(authorizations[7], persons[jim], accounts[delta]);
			isAuthorizedToAccess.link(authorizations[8], persons[jerry], accounts[charlie]);
			isAuthorizedToAccess.link(authorizations[0], persons[jim], accounts[delta]);		// See if the same link object could be mistakenly used
		}
		
		private void showLinks()
		{
			for (Person person : persons)
			{
				if (person != null)		// See which Account(s) John is authorized to access and what the Authorization(s) look like
				{
					result.append(person + " has the following privileges: \n");
					
					for (Triplet<Authorization, Person, Account> triplet : isAuthorizedToAccess.fromLeft(person))	// All links to person
						if (!triplet.nulls())
						{
							Account account = triplet.right;
							Authorization authorization = triplet.linkObject;
							result.append("\tAccount: " + account + " according to: " + authorization + "\n");
						}
				}
			}
			
			System.out.println(result);
		}
		
		public void run()
		{
			result.append(isAuthorizedToAccess + "\n");
			createLinks();
			showLinks();
		}
	}

	private class SimpleTernaryAssociationClassBenchmark
	{
		StringBuilder result = new StringBuilder();
		
		private TernaryAssociationClass<Authorization, Person, Project, Account> contract
				= new TernaryAssociationClass<>("Authorization", "Person", "Project", "Account", "Auditor", "Project", "Account");
		
		private void buildLinks()
		{
			contract.link(authorizations[0], persons[john], projects[general], accounts[alpha]);
			contract.link(authorizations[1], persons[john], projects[general], accounts[alpha]);
			contract.link(authorizations[2], persons[jerry], projects[accounting], accounts[bravo]);
			contract.link(authorizations[3], persons[bob], projects[accounting], accounts[bravo]);
			contract.link(authorizations[4], persons[jim], projects[production], accounts[charlie]);
			contract.link(authorizations[5], persons[aaron], projects[production], accounts[charlie]);
			contract.link(authorizations[6], persons[bob], projects[general], accounts[delta]);
			contract.link(authorizations[0], persons[jim], projects[accounting], accounts[alpha]);	// Test multiplicity enforcement
		}
		
		private void editLinks()
		{
			System.out.println("\nUnlinking " + authorizations[0] + "\n");
			contract.unlink(authorizations[0]);
			
			System.out.println("Unlinking " + persons[jim] + "\n");
			contract.unlinkLeft(persons[jim]);
			
			System.out.println("Unlinking " + projects[accounting] + "\n");
			contract.unlinkTop(projects[accounting]);
			
			System.out.println("Unlinking " + accounts[delta] + "\n");
			contract.unlinkRight(accounts[delta]);
		}
		
		private void writeLinks()
		{
			for (Quadruplet<Authorization, Person, Project, Account> quad : contract.links())
				result.append(quad.center + ": " + quad.left + ", " + quad.top + ", " + quad.right + "\n");
			
			result.append("\n");
			
			for (Person person : persons)
			{
				result.append(person + ":\n");
				int count = 1;
				for (Quadruplet<Authorization, Person, Project, Account> quad : contract.fromLeft(person))
					result.append("\t" + count++ + ". " + quad.center + ": " + quad.top + ", " + quad.right + "\n");
			}
			
			result.append("\n");
			
			for (Project project : projects)
			{
				result.append(project + ":\n");
				int count = 1;
				for (Quadruplet<Authorization, Person, Project, Account> quad : contract.fromTop(project))
					result.append("\t" + count++ + ". " + quad.center + ": " + quad.left + ", " + quad.right + "\n");
			}
			result.append("\n");
			
			for (Account account : accounts)
			{
				result.append(account + ":\n");
				int count = 1;
				for (Quadruplet<Authorization, Person, Project, Account> quad : contract.fromRight(account))
					result.append("\t" + count++ + ". " + quad.left + ": " + quad.right + ", " + quad.center + "\n");
			}
		}
		
		public void run()
		{
			result.append(contract + "\n");
			buildLinks();
			writeLinks();
			System.out.println(result);
			
			result = new StringBuilder();
			editLinks();
			writeLinks();
			System.out.println(result);
		}
	}
	
	public void testOneToOne()
	{
		(new OneToOneBenchmark()).test();
	}
	
	public void testCollectionOfMany()
	{
		(new CollectionOfManyBenchmark()).test();
	}
	
	public void testCollectionOfOne()
	{
		CollectionOfOne<String, String> collection = new CollectionOfOne<>();
		
		collection.link("one", "Alpha");
		collection.link("two", "Bravo");
		collection.link("three", "Charlie");
		
		System.out.println("one is: " + collection.isLinkedTo("one"));
		System.out.println("two is: " + collection.isLinkedTo("two"));
		System.out.println("three is: " + collection.isLinkedTo("three"));
		
		System.out.println("one" + " and Alpha are linked: " + collection.isLinked("one", "Alpha"));
		
		collection.unlink("one", "Alpha");
		System.out.println("one" + " and Alpha are linked: " + collection.isLinked("one", "Alpha"));
		
		System.out.println("three" + " and Charlie are linked: " + collection.isLinked("three", "Charlie"));
		
		collection.unlinkFrom("three");
		System.out.println("three" + " and Charlie are linked: " + collection.isLinked("three", "Charlie"));	
	}
	
	public void testOneToMany()
	{
		(new OneToManyBenchmark()).run();
	}
	
	public void testManyToOne()
	{
		(new ManyToOneBenchmark()).run();
	}
	
	public void testManyToMany()
	{
		(new ManyToManyBenchmark()).run();
	}
	
	public void testAssociationClass()
	{
		(new SimpleAssociationClassBenchmark()).run();
	}
	
	public void testTernaryAssociationClass()
	{
		(new SimpleTernaryAssociationClassBenchmark()).run();
	}

}

package solution;

import java.util.stream.Stream;

class Domain
{
	private State[] states;
	private Address[] addresses;
	private Customer[] customers;
	private Product[] products;
	private Vendor[] vendors;
	private SalesConsultant[] salesConsultants;
	private CompTerms[] compTerms;
	private Deal[] deals;
	private Event[] events;
	private Travel[] travels;
	private Order[] orders;

	// Package visible
	Domain()
	{
		createDomainObjects();
	}

	private void createDomainObjects()
	{
		State [] s =
		{
			new State("IL", "Illinois"),
			new State("DC", "Washington DC"),
			new State("MA", "Massachusetts"),
			new State("MN", "Minnesota"),
			new State("WA", "Washington")
		};
		states = s;

		Address [] a =
		{
			new Address("1245 Parkway Dr.", "", "Chicago", states[0], "60685"),
			new Address("134 South Michigan Ave.", "Appartment 3-B", "Chicago", states[0], "60685"),
			new Address("205 North Monroe", "Suite 307", "Chicago", states[0], "60685"),
			new Address("134 North Jefferson", "", "Minneapolis", states[3], "55350"),
			new Address("5410 South Kirkwood", "", "Cambridge", states[2], "02142")
		};
		addresses = a;

		Customer [] c =
		{
			new Customer("IBM", addresses[0], "312 467 9899", "312 467 9890", "Bill Smith", "312 467 1200", "bills@ibm.com"),
			new Customer("E-Office", addresses[1], "312 243 6541", "312 243 6540", "Joelle Reynolds", "312 243 6769", "joelle.r@e-office.com"),
			new Customer("Copy Max Corp.", addresses[2], "312 320 9085", "312 320 9086", "Randy Burts", "312 320 9085 xt. 501", "randy@cmc.com"),
			new Customer("Best Buy", addresses[3], "320-587-1809", "320-587-1810", "Jeff Curls", "320-587-1839", "jeffc@bestbuy.com"),
			new Customer("Science Institute", addresses[4], "617.250.2631", "617.250.2098", "Max Randal", "617.250.2631", "maxr@scii.com")
		};
		customers = c;

		Product[] p =
		{
			new Product("Laptop 2001", "400 MB RAM - 750 MHZ - 15 GB"),
			new Product("Dell Latitude", "220 MB RAM - 350 MHZ - 10 GB"),
			new Product("Desktop 9801", "650 MB RAM - 900 MHZ - 30 GB - Linux"),
			new Product("HP 8100 DN", "Duplex installed - Network ready")
		};
		products = p;

		Vendor[] v =
		{
			new Vendor("Gateway Outlet", addresses[3], "(320) 567 9987", "(320) 977 0889"),
			new Vendor("Net Office", addresses[1], "(312) 755 8998", "(312 933 8008)"),
			new Vendor("Sam's Roads", addresses[0], "(312) 765 9778", "(312) 734 9557"),
			new Vendor("Ben & Jenny's", addresses[4], "(617) 456 9878", "(617) 234 0478")
		};
		vendors = v;

		Terms[] t =
		{
			new Terms(vendors[0], products[0], 6500.00, "Overnight", "30 days"),
			new Terms(vendors[3], products[0], 6700.00, "2-day", "15 days"),
			new Terms(vendors[1], products[0], 6300.00, "3-day", "No refund"),
			new Terms(vendors[0], products[1], 6500.00, "Overnight", "30 days"),
			new Terms(vendors[2], products[1], 6100.00, "3-day", "60 days"),
			new Terms(vendors[1], products[2], 6500.00, "Overnight", "20 days"),
			new Terms(vendors[2], products[2], 6200.00, "3-day", "No refund"),
			new Terms(vendors[3], products[2], 6350.00, "5-day", "45 days"),
			new Terms(vendors[0], products[3], 6500.00, "Overnight", "1 Year")
		};
		
		SalesConsultant[] sc =
		{
			new SalesConsultant("John Smith", "(312) 345 9378"),
			new SalesConsultant("Jane Bloomfield","(234) 243 2220"),
			new SalesConsultant("Mike Schimmel","(612) 345 3222"),
			new SalesConsultant("Frank Doer","(737) 266 2256"),
			new SalesConsultant("Savio Lobo","(312) 123 4556"),
			new SalesConsultant("Mary Garden","(768) 533 9889")
		};
		salesConsultants = sc;

		CompTerms[] ct =
		{
			new CompTerms(.06, salesConsultants[0]),
			new CompTerms(.10, salesConsultants[0]),
			new CompTerms(.15, salesConsultants[1]),
			new CompTerms(.06, salesConsultants[2]),
			new CompTerms(.18, salesConsultants[2]),
			new CompTerms(.12, salesConsultants[3]),
			new CompTerms(.20, salesConsultants[3]),
			new CompTerms(.10, salesConsultants[3]),
			new CompTerms(.11, salesConsultants[4]),
			new CompTerms(.08, salesConsultants[4]),
			new CompTerms(.07, salesConsultants[5]),
			new CompTerms(.25, salesConsultants[5]),
			new CompTerms(.12, salesConsultants[5])
		};
		compTerms = ct;

		Deal[] d =
		{
			new Deal(customers[0], salesConsultants[0], products[0]),
			new Deal(customers[0], salesConsultants[0], products[0]),
			new Deal(customers[1], salesConsultants[1], products[1]),
			new Deal(customers[2], salesConsultants[2], products[2]),
			new Deal(customers[2], salesConsultants[2], products[2]),
			new Deal(customers[2], salesConsultants[2], products[2]),
			new Deal(customers[3], salesConsultants[3], products[3]),
			new Deal(customers[4], salesConsultants[4], products[0]),
			new Deal(customers[4], salesConsultants[4], products[0]),
			new Deal(customers[4], salesConsultants[4], products[1]),
			new Deal(customers[3], salesConsultants[5], products[1]),
			new Deal(customers[3], salesConsultants[5], products[2]),
			new Deal(customers[2], salesConsultants[5], products[2])
		};
		deals = d;

		Event[] e =
		{
			new PhoneCall("1 Nice fellow to work with.", "1999 May 3", "Identification of product", "Doesn't seem to be a rich guy.", 12.08),
			new Meeting("2 Strange fellow to work with.", "1998 May 3", "Identification of needs", "Doesn't seem to be a poor guy.", 35.03, 59.43, 120.98, 80.78),
			new Meeting("3 Nice company to work with.", "1997 June 3", "Comments about product", "Doesn't look to be a real guy.", 37.03, 53.43, 190.98, 86.78),
			new Meeting("4 Obscure situation.", "1997 March 1", "Product for identification", "Doesn't identify as being a poor fellow.", 55.03, 79.43, 60.98, 20.78),
			new PhoneCall("5 Nice fellow to work with.", "1999 May 3", "Identification of product", "Doesn't seem to be a rich guy.", 20.07),
			new Meeting("6 Strange fellow to work with.", "1998 May 3", "Identification of needs", "Doesn't seem to be a poor guy.", 45.03, 51.43, 15.98, 10.78),
			new Meeting("7 Nice company to work with.", "1997 June 3", "Comments about product", "Doesn't look to be a real guy.", 125.03, 149.43, 30.98, 70.78),
			new PhoneCall("8 Obscure situation.", "1997 March 1", "Product for identification", "Doesn't identify as being a poor fellow.", 45.92),
			new Meeting("9 Nice fellow to work with.", "1999 May 3", "Identification of product", "Doesn't seem to be a rich guy.", 23.03, 55.43, 60.98, 70.78),
			new PhoneCall("10 Strange fellow to work with.", "1998 May 3", "Identification of needs", "Doesn't seem to be a poor guy.", 52.10),
			new Meeting("11 Nice company to work with.", "1997 June 3", "Comments about product", "Doesn't look to be a real guy.", 23.12, 56.43, 62.98, 78.78),
			new Meeting("12 Obscure situation.", "1997 March 1", "Product for identification", "Doesn't identify as being a poor fellow.", 23.03, 55.43, 60.98, 70.78),
			new PhoneCall("13 Nice fellow to work with.", "1999 May 3", "Identification of product", "Doesn't seem to be a rich guy.", 12.03),
			new Meeting("14 Strange fellow to work with.", "1998 May 3", "Identification of needs", "Doesn't seem to be a poor guy.", 24.03, 54.43, 65.98, 72.78),
			new PhoneCall("15 Nice company to work with.", "1997 June 3", "Comments about product", "Doesn't look to be a real guy.", 7.98),
			new Meeting("16 Obscure situation.", "1997 March 1", "Product for identification", "Doesn't identify as being a poor fellow.", 25.03, 57.43, 61.98, 90.78),
			new Meeting("17 Nice fellow to work with.", "1999 May 3", "Identification of product", "Doesn't seem to be a rich guy.", 23.03, 22.43, 670.98, 98.78),
			new PhoneCall("18 Strange fellow to work with.", "1998 May 3", "Identification of needs", "Doesn't seem to be a poor guy.", 18.29),
			new Meeting("19 Nice company to work with.", "1997 June 3", "Comments about product", "Doesn't look to be a real guy.", 15.03, 515.43, 150.98, 715.78),
			new Meeting("20 Obscure situation.", "1997 March 1", "Product for identification", "Doesn't identify as being a poor fellow.", 23.03, 55.43, 60.98, 70.78),
			new PhoneCall("21 Nice fellow to work with.", "1999 May 3", "Identification of product", "Doesn't seem to be a rich guy.", 62.70),
			new Meeting("22 Strange fellow to work with.", "1998 May 3", "Identification of needs", "Doesn't seem to be a poor guy.", 23.153, 515.43, 615.98, 150.78),
			new Meeting("23 Nice company to work with.", "1997 June 3", "Comments about product", "Doesn't look to be a real guy.", 212.03, 512.43, 612.98, 120.78),
			new PhoneCall("24 Obscure situation.", "1997 March 1", "Product for identification", "Doesn't identify as being a poor fellow.", 45.25),
			new Meeting("25 Nice fellow to work with.", "1999 May 3", "Identification of product", "Doesn't seem to be a rich guy.", 212.03, 125.43, 612.98, 120.78),
			new PhoneCall("26 Strange fellow to work with.", "1998 May 3", "Identification of needs", "Doesn't seem to be a poor guy.", 32.61),
			new Meeting("27 Nice company to work with.", "1997 June 3", "Comments about product", "Doesn't look to be a real guy.", 153.03, 515.43, 615.98, 150.78),
			new PhoneCall("28 Obscure situation.", "1997 March 1", "Product for identification", "Doesn't identify as being a poor fellow.", 41.90),
			new Meeting("29 Make sure to speak with Mike Donn", "2000 May 3", "Reviewed the whole line", "Should yield results soon.", 932.03, 123.43, 43.98, 121.78),
			new PhoneCall("30 Interesting position.", "2000 April 1", "Product review", "Good confidence level.", 23)
		};
		events = e;

		int dealInd = 0;
		int eventIndex = 0;
		int maxD = d.length - 1;
		int maxE = e.length - 1;
		for (; dealInd <= maxD && eventIndex <= maxE; dealInd++)
		{
			d[dealInd].addEvent(e[eventIndex++]);
			d[dealInd].addEvent(e[eventIndex++]);
		}
		d[0].addEvent(e[28]);
		d[0].addEvent(e[29]);

		Travel[] tr =
		{
			new Travel(1200, 302.0, 43, "Chicago"),
			new Travel(800, 290.0, 10, "Ann Arbor"),
			new Travel(1929, 381.0, 10, "St Louis"),
			new Travel(1022, 112.0, 0, "Fairfield"),
			new Travel(1322, 123.0, 12, "Minneapolis"),
			new Travel(1234, 321.0, 11, "New York"),
			new Travel(908, 12.0, 413, "Santa Clara"),
			new Travel(1243, 8.0, 23, "Santa Anna"),
			new Travel(1123, 165.0, 23, "Palo Alto"),
			new Travel(1109, 143.0, 43, "Santa Barbara"),
			new Travel(990, 190.0, 34, "San Francisco"),
			new Travel(1200, 0.0, 0, "Eureka"),
			new Travel(1230, 234.0, 0, "Arcada")
		};
		travels = tr;

		e[0].setTravel(tr[0]); e[2].setTravel(tr[1]); e[3].setTravel(tr[2]);
		e[4].setTravel(tr[3]); e[7].setTravel(tr[4]); e[8].setTravel(tr[5]);
		e[10].setTravel(tr[6]); e[12].setTravel(tr[7]); e[13].setTravel(tr[8]);
		e[16].setTravel(tr[9]); e[18].setTravel(tr[10]); e[22].setTravel(tr[11]);
		e[25].setTravel(tr[12]);

		Order[] or =
		{
			new Order(8580, 0.9, 10, "30 days", ct[1]),
			new Order(8540, 0.8, 20, "15 days", ct[2]),
			new Order(8270, 0.9, 10, "30 days", ct[4]),
			new Order(8720, 0.8, 25, "20 days", ct[6]),
			new Order(8170, 0.8, 45, "30 days", ct[8]),
			new Order(8630, 1.0, 10, "15 days", ct[9]),
			new Order(8440, 0.9, 123, "30 days", ct[10]),
			new Order(8470, 0.8, 32, "10 days", ct[11]),
			new Order(8170, 0.9, 110, "30 days", ct[12]),
			new Order(8750, 1.0, 3, "15 days", ct[12])
		};
		orders = or;

		or[0].setTerms(t[0]); or[1].setTerms(t[0]); or[2].setTerms(t[1]);
		or[3].setTerms(t[2]); or[4].setTerms(t[3]); or[5].setTerms(t[4]);
		or[6].setTerms(t[5]); or[7].setTerms(t[6]); or[8].setTerms(t[7]);
		or[9].setTerms(t[8]);

		e[0].addOrder(or[0]); e[5].addOrder(or[1]); e[9].addOrder(or[2]);
		e[12].addOrder(or[3]); e[16].addOrder(or[4]); e[16].addOrder(or[5]);
		e[24].addOrder(or[6]); e[25].addOrder(or[7]); e[27].addOrder(or[8]);
		e[27].addOrder(or[9]);

		Stream.of(salesConsultants)
				.forEach(obj->obj.printTravelCost(""));

	}
}
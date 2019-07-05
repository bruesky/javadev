package solution;

import java.util.List;

public class SimpleList
{
	private Link first;						// The Link that begins the list
	private Link last;						// The Link that ends the list
	private Link current;					// The Link I'm currently visiting

	// Append an item
	public void append(Object item)			
	{
		if (first == null)					// If I don't have a Link...
		{
			first = new Link(item);			// ... then it's the beginning
			last = first;					// ... as well as the end
		}
		else								// Otherwise...
			last = last.append(item);			// ... put it at the end
	}

	// Visit the first item
	public void restart() { current = first; }		

	// Do we currently visit an item?
	public boolean hasItem() { return current != null; }

	// Get current Item
	public Object getItem()								
	{
		Object item = null;

		if (current != null)				// If we've got a current Link
			item = current.getItem();		// ... get it's item

		return item;
	}
	
	// Visit the next item
	public void next()						
	{
		if (current != null)				// If currently visiting an item
			current = current.getNext();	// ...get it's successor.
	}


	public int getCount(){
		int count = 0;
		Link node = first;
		while (node!=null){
			node = node.getNext();
			count++;
		}
		return count;
	}

	public Link insert(Object item){
		Link node = new Link(item);
		node.setNext(first);
		first = node;
		return first;
	}


}


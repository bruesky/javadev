package skeleton;

public class Link
{
	private Object item;		// The item I hold
	private Link next;			// The link I succeed

	public Link(Object item)			
	{
		this.item = item;		// The item I hold is set here
	}

	public Link append(Object item)
	{
		next = new Link(item);	// Create my "next" Link that will hold the item
		return next;			// Return a reference to this new item
	}

	public Object getItem() { return item; }
	
	public Link getNext() { return next; }
}


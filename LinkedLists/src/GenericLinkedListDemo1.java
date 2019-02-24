
public class GenericLinkedListDemo1 {
	public static void main(String[] args)
	{
	LinkedList3<String> list = new LinkedList3<String>();
	
	list.addToStart("Apples");
	list.addToStart("Bananas");
	list.addToStart("Cantaloupe");
	list.addToStart("Orange");
	System.out.println("List has " + list.size() + " nodes.\n");

	list.outputList();
	System.out.println("\nEnd of list.");
	}
}

/*
When defining the LinkedList3<T> class, the
type for a node is Node<T>, not Node
	– If the <T> is omitted, this is an error for which the
compiler may or may not issue an error message
(depending on the details of the code), and even if it
does, the error message may be quite strange
	– Look for a missing <T> when a program that uses nodes
with type parameters gets a strange error message or
doesn't run correctly
*/
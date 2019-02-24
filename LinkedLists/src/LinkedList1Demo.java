
public class LinkedList1Demo {

	public static void main(String[] args) {
		LinkedList1 list = new LinkedList1();
		list.addToStart("Apples", 1);
		list.addToStart("Bananas", 2);
		list.addToStart("Cantaloupe", 3); //Cantaloupe is now the head node
		
		System.out.println("List has " + list.size() + " nodes.");
		
		list.outputList();
		if(list.contains("Cantaloupe"))
			System.out.println("Cantaloupe is on list.");
		else
			System.out.println("Cantaloupe is NOT on list");
		
		list.deleteHeadNode(); //Remove the head node
		
		if(list.contains("Cantaloupe"))
			System.out.println("Cantaloupe is on list.");
		else
			System.out.println("Cantaloupe is NOT on list");
		
		while(list.deleteHeadNode()) //Empties the list. There's no loop body because
			/*Empty Body*/	;	     //	the method deleteHeadNode both performs an action
								     //	on the list and returns a Boolean value. 
		System.out.println("Start of list: ");
		list.outputList();
		System.out.println("End of list.");
		
	}

}

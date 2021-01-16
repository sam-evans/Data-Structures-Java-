/* ***************************************************
 * Sam Evans
 * 9/28/20
 *
 * List Class - handles any form of data
 *************************************************** */

public class List<Type>
{
    // We don't actually have to set a max size with linked lists
    // But it is a good idea.
    // Just picture an infinite loop adding to the list! :O
    // Yes, you may change this when you do your word count program.
    public static final int MAX_SIZE = 50;

    private Node<Type> head;
    private Node<Type> tail;
    private Node<Type> curr;
    private int num_items;

    // constructor
    // remember that an empty list has a "size" of -1 and its "position" is at -1
    public List()
    {
    	head = null;
    	tail = null;
    	curr = null;
    	num_items = 0;
    }

    // copy constructor
    // clones the list l and sets the last element as the current
    // (notice we're not just copying the whole list at once?)
    public List(List<Type> l)
    {
        Node<Type> n = l.head.getLink();

        this.head = this.tail = this.curr = null;
        this.num_items = 0;

        while (n != null)
        {
            this.InsertAfter(n.getData());
            n = n.getLink();
        }
    }

    // navigates to the beginning of the list
    public void First()
    {
    	curr.setLink(head.getLink());
    }

    // navigates to the end of the list
    // the end of the list is at the last valid item in the list
    public void Last()
    {
    	curr.setLink(tail.getLink());
    	
    	
    	
    }

    // navigates to the specified element (0-index)
    // this should not be possible for an empty list
    // this should not be possible for invalid positions
    public void SetPos(int pos)
    {
    	if((head != null) && (pos != GetSize())) {
    		curr.setLink(head.getLink());
        	for(int i =0; i < pos; i++) {
        		if(curr.getLink().getLink() != null)
        			curr.setLink(curr.getLink().getLink());
        		
        	}
    		}
    	}
    

    // navigates to the previous element
    // this should not be possible for an empty list
    // there should be no wrap-around
    public void Prev()
    {
    	int i = GetPos();
    	if (i>=0) {
    		SetPos(i-1);
    	}
    }

    
    // navigates to the next element
    // this should not be possible for an empty list
    // there should be no wrap-around
    public void Next()
    {
    	if((head != null) && (curr.getLink() != tail.getLink()))
    		
    		curr.setLink(curr.getLink().getLink());
    	
    }

    // returns the location of the current element (or -1)
    //finding curr
    public int GetPos()
    {
    	
    	if(IsFull() == false || num_items == MAX_SIZE) {
    		int index = -1;
	    	if(head != null) {
		    	Node<Type> n = head.getLink();
		    	if(head.getLink() != null) {
			    	while((n != curr.getLink()) && (index < num_items-1))
			    	{
			    		n = n.getLink();
			    		index++;
			    		
			    	}
			    	index++;
		    	}
		    	else
		    		return index;
	    	}
	    	return index;
    	}
    	else 
    		return -1;
    	
    }

    // returns the value of the current element (or -1)
    
    public Type GetValue()
    {
    	if (curr == null) {
    		return null;
    	}
    	else
    		return curr.getLink().getData();
    }

    // returns the size of the list
    // size does not imply capacity
    public int GetSize()
    {
    	if(IsFull() == false)
    		return num_items;
    	else
    	{
    		return MAX_SIZE;
    	}
    		
    		
    }

    // inserts an item before the current element
    // the new element becomes the current
    // this should not be possible for a full list
    public void InsertBefore(Type data)
    {
    	 {
	    	if (head == null) {
	    		Node<Type> n = new Node<Type>();
	    		n.setData(data);
	    		head = new Node<Type>();
	    		head.setLink(n);
	    		tail = new Node<Type>();
	    		tail.setLink(n);
	    		curr = new Node<Type>();
	    		curr.setLink(n);
	    		
	    		
	    	}
	    	else {
	    		//but first, see if curr at 1st node - if so, insert like the wkst
	    		if(curr.getLink() == head.getLink()) {
	    			Node<Type> n = new Node<Type>();
	        		n.setData(data);
	        		n.setLink(head.getLink());
	        		head.setLink(n);
	        		curr.setLink(n);
	        		
	    		}
	    		else {
	    			if(IsFull() == false) {
		    			Prev();
		        		InsertAfter(data);
		        		num_items--;
	    			}
	    		}
	    		
	
	    	}
	    	
    	}
    	num_items++;
    }

    // inserts an item after the current element
    // the new element becomes the current
    // this should not be possible for a full list
    
    public void InsertAfter(Type data)
    {
    	{
	    	if(head == null || head.getLink() == null) {
	    		Node<Type> b = new Node<Type>();
	        	b.setData(data);
	    		head = new Node<Type>();
	    		head.setLink(b);
	    		tail = new Node<Type>();
	    		tail.setLink(b);
	    		curr = new Node<Type>();
	    		curr.setLink(b);
	    		
	    	}
	    	else {
	    		Node<Type> b = new Node<Type>();
	        	b.setData(data);
				b.setLink(curr.getLink().getLink());
				curr.getLink().setLink(b);
				if(curr.getLink() == tail.getLink()) {
					tail.setLink(b);
					}
				curr.setLink(b);
				
				
	    		}
	    	
    	}
    	num_items++;
    	}
    	
    // removes the current element 
    // this should not be possible for an empty list
   
    public void Remove()
    {
    	if(IsEmpty() == false) {
	    	Node<Type> n = head.getLink();
	    	//deletes head
	    	if (head.getLink() == curr.getLink()) {
	    		
	    		head.setLink(head.getLink().getLink());
	    		curr.setLink(head.getLink());
	    		if(head.getLink() == tail.getLink()) {
	    			
	    			tail.setLink(null);
	    			
	    		}
	    		
	    		
	    	}
	    	else if(head.getLink() == curr.getLink() && head.getLink() == tail.getLink()) {
	    		head.setLink(null);
	    		curr.setLink(null);
	    		tail.setLink(null);
	    	}
	    	//deletes tail
	    	else if(curr.getLink() == tail.getLink()) {
	    		Prev();
	    		curr.getLink().setLink(null);
	    		tail.setLink(curr.getLink());
	    		
	    	}
	    	//deletes everything else in between
	    	else {
	    		while(n.getLink() != curr.getLink()) {
	    			n = n.getLink();
	    			
	    		}
	    		if(n.getLink() == curr.getLink()) {
	    			if(curr.getLink() == null) {
	    				
	    				n.setLink(null);
	        			curr.setLink(n);
	        			tail.setLink(n);
	    			}
	    			else {
	    			n.setLink(curr.getLink().getLink());
	    			curr.setLink(n.getLink());
	    			}
	    			
	    			
	    		}
	    		
	    	
	    	}
	    	num_items--;
    	}
    	
    	
    	
    }

    // replaces the value of the current element with the specified value
    // this should not be possible for an empty list
   
    public void Replace(Type data)
    {
    	if((IsEmpty() == false) && (curr.getLink() != null)) {
    		curr.getLink().setData(data);
    	}
    }

    // returns if the list is empty
    
    public boolean IsEmpty()
    {
    	if (num_items == 0)
    		return true;
    	else
    		return false;
    }

    // returns if the list is full
   
    public boolean IsFull()
    {
    	if(num_items >=  MAX_SIZE) {
    		num_items = MAX_SIZE;
    		return true;
    	}
    	else
    		return false;
    }

    // returns if two lists are equal (by value)
   
    public boolean Equals(List<Type> l)
    {
    	Node<Type> a = head.getLink();
    	Node<Type> b = l.head.getLink();
    	int i = 0;
    	if(GetSize() != l.GetSize()) {
    		return false;
    	}
    	else if(GetSize() == l.GetSize() && i == GetSize()) {
    		for(;i<GetSize();) {
    			if(a.getData() == b.getData()){
		    		i++;
		    		a = a.getLink();
		    		b = b.getLink();
    			}
    	}
    	}
    	return true;
    }

    // returns the concatenation of two lists
    // l should not be modified
    // l should be concatenated to the end of *this
    // the returned list should not exceed MAX_SIZE elements
    // the last element of the new list is the current
    
    public List<Type> Add(List<Type> l)
    {
    	List<Type> a = new List<Type>(this);
    	Node<Type> b = l.head.getLink();
    	
    	while(b != null && a.IsFull() == false) {
    		a.InsertAfter(b.getData());
    		b = b.getLink();
    		
    	}
    	return a;
    }

    // returns a string representation of the entire list (e.g., 1 2 3 4 5)
    // the string "NULL" should be returned for an empty list
    public String toString()
    {
    	String output = "";
    	
    	if(IsEmpty() == true) 
    		output += "NULL";
    		
    	else  {
    		Node<Type> n = head.getLink();
    		while(n != tail.getLink().getLink()) {
    			
        		output += n.getData();
        		output += " ";
        		n = n.getLink();
        	}
    	
    	}
    		
    	
    	return output;
   
    }
}
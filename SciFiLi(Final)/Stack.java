
public class Stack<Type> extends List<Type> {
	
	public Stack() {
		super();
	}
	
	public void push(Type n) {
		//adds to front of the list
		//super.Last();
		super.InsertAfter(n);
	}
	
	public Type pop() {
		//pops info from the front 
		if(super.GetSize() > 1) {
			super.Last();
			Type temp = super.GetValue();
			super.Remove();
			return temp;
		}
		else {
			super.Last();
			Type temp1 = super.GetValue();
			super.Remove();
			return temp1;
		}
	}
	
	public Type peek() {
		//checks the value at the front
		super.Last();
		return super.GetValue();
		}
	}


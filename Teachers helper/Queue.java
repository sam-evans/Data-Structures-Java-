
public class Queue<Type> extends List<Type> {
	
	public Queue() {
		super();
	}
	
	public void Enqueue(Type n) {
		//super.Last();
		if(Queue.super.GetSize() < 2)
			super.InsertAfter(n);
		else {
			super.Last();
			super.InsertAfter(n);
		}
	}
		
	public Type Dequeue() {
		super.First();
		Type temp = super.GetValue();
		super.Remove();
		return temp;
	}
}

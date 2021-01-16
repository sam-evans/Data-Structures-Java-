import java.util.Scanner;

public class Helper {

	public static void main(String[] args) {
		Queue<Character> a = new Queue<Character>();
		Queue<Float> c  = new Queue<Float>();
		Stack<Character> b = new Stack<Character>();
		float k = 0;
		@SuppressWarnings("resource")
		Scanner sf = new Scanner(System.in);
		String choice = null;
		try {
			System.out.println("Enter Formula");
			choice = sf.nextLine();
			//System.out.println(choice);
			
		}
		catch(Exception e) {
			System.out.println("Error has occured. Please try again.");
		}
		char[]arr = new char[choice.length()];
		choice.getChars(0, choice.length(), arr, 0);
		for (int i =0; i<arr.length; i++) {
			char s = arr[i]; 
			if(isOp(s) == true && b.IsEmpty() == true) {
				b.push(s);
			}
			else if (isOp(s) == true && compare(b,s) != true && s != ')') {
				//add to stack 
				b.push(s);
				
			}
			else if (isOp(s) == true && compare(b, s) == true) {
				for (int j = 0; j<b.GetSize();j++) {
					a.Enqueue(b.pop());
					
				}
				b.push(s);
			}
			else if(s == ')' && i < arr.length -1) {
				a.Enqueue(b.pop());
				b.pop();
			}
			//enqueue last operand
			else if(i == arr.length -1) {
				if(s == ')') {
					a.Enqueue(b.pop());
					b.pop();
					for(int n = b.GetSize(); n> 0; n--) {
						a.Enqueue(b.pop());
						
					}
				}
				else
				{
					a.Enqueue(s);
					for(int n = b.GetSize(); n> 0; n--) {
						a.Enqueue(b.pop());
						
					}
					try {
						System.out.println("What is the value of " + s);
						k = sf.nextInt();
						c.Enqueue(k);
						
					}
					catch(Exception e) {
						System.out.println("error");
						i--;
					}	
				}
				
			}
			else {
				//enqueue operands
				a.Enqueue(s);
				try {
					System.out.println("What is the value of " + s);
					k = sf.nextInt();
					c.Enqueue(k);
				}
				catch(Exception e) {
					System.out.println("error");
				}
			}
				
		}
		
		System.out.println(cal(a,c));
		//System.out.println();
		
		System.out.println("Postfix conversion - " + a.toString());
	}
	public static boolean isOp(char s) {
			if(s == '+' || s == '-' || s == '*' || s == '/' || s == '(' || s == ')'){
				return true;
			}
			else
				return false;
	
		
	}
	public static boolean compare(Stack<Character>b , char s) {
		
		//if((b.peek() == '+' || b.peek() == '-') && (s == '*' || s == '/'))
			//return true;
		if((b.peek() == '*' || b.peek() == '/') && (s == '+' || s == '-'))
			return true;
		else
			return false;
		
	}
	public static Float cal(Queue<Character>a, Queue<Float>c) {
		
		a.First();
		//c.Last();
		for (int i =0; i<a.GetSize();i++) {
			if(a.GetValue() == '+') {
				float val1 = c.Dequeue();
				float val2 = c.Dequeue();
				c.Enqueue((val1+val2));
				
				a.Next();
			}
			else if(a.GetValue() == '-') {
				float val1 = c.Dequeue();
				float val2 = c.Dequeue();
				if(c.GetSize() <=1 )
					c.Enqueue((val2-val1));
				else
					c.Enqueue(val1-val2);
				a.Next();
			}
			else if(a.GetValue() == '*') {
				float val1 = c.Dequeue();
				float val2 = c.Dequeue();
				c.Enqueue((val1*val2));
				a.Next();
			}
			else if (a.GetValue() == '/'){
				float val1 = c.Dequeue();
				float val2 = c.Dequeue();
				if(c.GetSize() <= 1)
					c.Enqueue((val2/val1));
				else
					c.Enqueue(val1/val2);
				
				a.Next();
			}
			else
				a.Next();
			
		}
		return c.GetValue();
	}
}















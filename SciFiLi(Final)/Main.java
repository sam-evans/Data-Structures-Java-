import java.io.*;
import java.util.Scanner;

//-------SciFiLi Library Final Project-----\\
//-------Sam Evans------Emily Hollis-------\\


public class Main {
	static boolean exit;

	public static void main(String[] args)throws IOException {
		Scanner sf = new Scanner(new File("C:\\Users\\wmpsa\\OneDrive\\Documents\\LA Tech School\\SciFiLiBooks.txt"));
		List<Book> books = new List<Book>();
		//Singly Linked list data structure works best because using this gives the parameters for an array to be sorted easier. 
		//A Linked list also is good for searching in this case because the amount of nodes doesn't take up much memory 
		//searching through the list has a time complexity of O(n) where n = the size of the linked list
		//If the library, for example, got a new shipment of books, The linked list will update it's size not breaking the array's use.
		
		String z = null;
		while (sf.hasNext()) {
			String s = sf.nextLine();
			
			String[] str = s.split(", ");
			String t = str[0];
			String n = str[1];
			boolean c;
			int a = Integer.parseInt(str[2]);
			if(a == 0) {
				c = false;
				
			}
			else
				c = true;
			int p = Integer.parseInt(str[3]);
			Book newBook = new Book(t,n,c,p);
			books.InsertAfter(newBook);
		}
		Book[]arr = new Book[books.GetSize()];
		//array uses Linked List to fill its parameters 
		books.First();
		for(int i = 0; i<books.GetSize(); i++) {
			arr[i] = new Book(books.GetValue().getTitle(), books.GetValue().getName(), books.GetValue().getCheckStat(), books.GetValue().getPrio());
			books.Next();
		}
		menuHead();
		books.First();
		while(!exit) {
			menuOps();
			int choice = getInput();
			switch (choice) {
			case 0:
				exit = true;
				System.out.println("System off ");
				outputFile(arr, books);
				break;
			case 1:
				if (choice == 1) {
					books.First();
					for(int i = 0; i<books.GetSize(); i++) {
						String check = "";
						if(arr[i].getCheckStat() == true) {
							check += "IN";
						}
						else {
							check += "OUT";
						}
						System.out.println( books.GetValue().getTitle() + ", " + books.GetValue().getName() + ", " +  check);
						System.out.println(" ");
						books.Next();
					}
				}
			case 2:
				if(choice == 2) {
					sortTitle(arr);
					for(int i =0; i<arr.length; i++) {
						String check = "";
						if(arr[i].getCheckStat() == true) {
							check += "IN";
						}
						else {
							check += "OUT";
						}
						System.out.println(arr[i].getTitle() + ", " + arr[i].getName() + ", " + check);
						System.out.println(" ");
					}
				}
			case 3:
				if(choice == 3) {
					sortAuthor(arr);
					for(int i=0; i<arr.length; i++) {
						String check = "";
						if(arr[i].getCheckStat() == true) {
							check += "IN";
						}
						else {
							check += "OUT";
						}
						System.out.println(arr[i].getName() + ", " + arr[i].getTitle() + ", " + check);
						System.out.println(" ");
					}
				}
			case 4:
				if(choice == 4) {
					@SuppressWarnings("resource")
					Scanner scanner = new Scanner(System.in);
					String input = null;
					System.out.println("\nSearch Title: ");
					input = scanner.nextLine();
					z = (searchTitle(books, input));
					String check ="";
					if(books.GetValue().getCheckStat() == true) {
						check += "IN";
					}
					else {
						check += "OUT";
					}
					 
					if(z == null) {
						System.out.println("Book Not Found!");
						
					}
					else {
						System.out.println(z + ", " + books.GetValue().getName() + ", " + check);
					}
					while(choice == 4 && z != null) {
						menuOps2();
						int num = getInput();
						switch(num) {
						case 0:
							choice = 1;
						case 1:
							if  (num == 1) {
								boolean cs = books.GetValue().getCheckStat();
								boolean cs2 = arr[books.GetPos()].getCheckStat();
								books.GetValue().changeStat(cs);
								arr[books.GetPos()].changeStat(cs2);
								String check2 ="";
								if(books.GetValue().getCheckStat() == true) {
									check2 += "IN";
								}
								else {
									check2 += "OUT";
								}
								 
								System.out.println("Book Checkin Status Updated!" + "\n" + books.GetValue().getTitle() +  ", " + books.GetValue().getName() + ", " + check2);
								choice = 1;
							}
							
						}
					}
					
					
					
					
				}
			
			case 5:
				if(choice == 5) {
					
					@SuppressWarnings("resource")
					Scanner scanner2 = new Scanner(System.in);
					String input = null;
					System.out.println("Search Author");
					input = scanner2.nextLine();
					System.out.println("Books by " + input);
					searchAuthor(books, input);
					
				
					
				}
			case 6:
				if(choice == 6) {
					//stack data structure is used to emulate return/checkout process for the librarian. He or She can choose how many books are being returned so that the return process can be as quick as possible
					//This data structures pushes book objects that are checked out into a stack and pops everything at once it seems to the user.
					//This is also a lot more efficient than searching title by title when the worker may have to check in 5+ books at a time  
					Stack<Book> pile = new Stack<Book>();
					Scanner scanner3 = new Scanner(System.in);
					int input2 = 0;
					try {
						
						System.out.println("How many books are being returned? ");
						input2 = Integer.parseInt(scanner3.nextLine());
					}
					catch(NumberFormatException e) {
						System.out.println("Error has occured. PLease try again.");
					}
					
					while(pile.GetSize()<input2) {
						Scanner scanner4 = new Scanner(System.in);
						String title = null;
						
						System.out.println("Enter book Title: ");
						
						title = scanner4.nextLine();
						z = searchTitle(books, title);
						if(books.GetValue().getCheckStat() == true) {
							System.out.println("Book is already checked in!");
						}
						else {
							pile.push(books.GetValue());
							boolean cs = arr[books.GetPos()].getCheckStat();
							arr[books.GetPos()].changeStat(cs);
							boolean cs2 = books.GetValue().getCheckStat();
							books.GetValue().changeStat(cs2);
					}
					}
					int n = pile.GetSize();
					System.out.println("---------Check in Stack------");
					pile.Last();
					for(int i = 0; i < n ; i++) {
						
						System.out.println(pile.GetValue().getTitle() + ", " + pile.GetValue().getName() + " ");
						pile.Prev();
						
					}
					Scanner scanner5 = new Scanner(System.in);
					int input3 = 0;
					System.out.println("Press 1 to clear check in stack ");
					input3 = Integer.parseInt(scanner3.nextLine());
					if(input3 == 1) {
						pile.Last();
						
						while(pile.GetSize() != 0) {
							String check = "";
							if(pile.GetValue().getCheckStat() == true) {
								check += "IN";
							}
							else {
								check += "OUT";
							}
							System.out.println(pile.GetValue().getTitle() + ", " + pile.GetValue().getName() + ": Has been checked in! ---> check in status: " + check);
							pile.pop();
							
							
						
						}
				}
					
				}
			case 7:
				if(choice ==7) {
					Stack<Book> pile = new Stack<Book>();
					Scanner scanner3 = new Scanner(System.in);
					int input2 = 0;
					try {
						
						System.out.println("How many books are being checked out? ");
						input2 = Integer.parseInt(scanner3.nextLine());
					}
					catch(NumberFormatException e) {
						System.out.println("Error has occured. PLease try again.");
					}
					while(pile.GetSize()<input2) {
						Scanner scanner4 = new Scanner(System.in);
						String title = null;
						
						System.out.println("Enter book Title: ");
						
						title = scanner4.nextLine();
						z = searchTitle(books, title);
						if(books.GetValue().getCheckStat() == false) {
							System.out.println("Book is not available!");
						}
						else {
							pile.push(books.GetValue());
							boolean cs = arr[books.GetPos()].getCheckStat();
							arr[books.GetPos()].changeStat(cs);
							boolean cs2 = books.GetValue().getCheckStat();
							books.GetValue().changeStat(cs2);
					}
					}
					int n = pile.GetSize();
					System.out.println("---------Check out Stack------");
					pile.Last();
					for(int i = 0; i < n ; i++) {
						
						System.out.println(pile.GetValue().getTitle() + ", " + pile.GetValue().getName() + " ");
						pile.Prev();
						
					}
					Scanner scanner5 = new Scanner(System.in);
					int input3 = 0;
					System.out.println("Press 1 to clear check out stack ");
					input3 = Integer.parseInt(scanner3.nextLine());
					if(input3 == 1) {
						pile.Last();
						
						while(pile.GetSize() != 0) {
							String check = "";
							if(pile.GetValue().getCheckStat() == true) {
								check += "IN";
							}
							else {
								check += "OUT";
							}
							System.out.println(pile.GetValue().getTitle() + ", " + pile.GetValue().getName() + ": Has been checked out! ---> check in status: " + check);
							pile.pop();
							
							
						
						}
					}
				}
			case 8:
				//Heap data structure is best used here because heap sort has a fast run time. This would be necessary during a chaotic circumstance, such as a fire, where the librarian would need to act quick to save his or her books.
				//Heap sort has a time complexity of O(nlogn) in it's worst case.
				//A Heap can also handle large amounts of data while maintaining a fast time complexity in it's worst case.
				//For example - If the SciFiLi Library transfered to a big city, the library would naturally have to account for an exponential amount of books compared to what the library had previously.
				//With this data structure in place, the transition to having much more data will be handled as easy as possible, while maintaining a fast run time in case of emergency. 
				if(choice == 8) {
					int n = checkedIn(books);
					Heap maxHeap = new Heap();
					Book [] heap = new Book[n];
					int x = 0;
					books.First();
					for (int i = 0; i<books.GetSize(); i++) {
						if(books.GetValue().getCheckStat() == true) {
							heap[x] = new Book(books.GetValue().getTitle(), books.GetValue().getName(), books.GetValue().getCheckStat(), books.GetValue().getPrio());
							x++;
							books.Next();
						}
						else
							books.Next();
					}
					maxHeap.sort(heap);
					System.out.println("--------------Evacuate All Checked in books-----------");
					for(int j = 0; j<heap.length; j++) {
						System.out.println(heap[j].getTitle() + ", " + heap[j].getName() + ", Priority = " + heap[j].getPrio());
						System.out.println(" ");
					}
				}
				
			default:
				System.out.println(" ");
			}
		}
		
		sf.close();
	}
	
	
	//menu header
	public static void menuHead() {
		System.out.println(" +------------------------------+ ");
		System.out.println("              Welcome to          ");
		System.out.println("            SciFiLi Library       ");
		System.out.println(" +------------------------------+ ");
	}
	public static void menuOps() {
		System.out.println("\nSystem Options");
		System.out.println("1) List of books");
		System.out.println("2) List of books by title");
		System.out.println("3) List of books by author");
		System.out.println("4) Search by Title");
		System.out.println("5) Search by Author");
		System.out.println("6) Checkin");
		System.out.println("7) Checkout");
		System.out.println("8) Emergency Evac Plan");
		System.out.println("0) Exit");
	}
	public static void menuOps2() {
		System.out.println("1) Check book in or out");
		System.out.println("0) Back");
	}
	public static int getInput() {
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		int choice = -1;
		while(choice <0 || choice >10) {
			try {
				System.out.println("\nEnter choice here: ");
				choice = Integer.parseInt(kb.nextLine());
				
			}
			catch(NumberFormatException e) {
				System.out.println("Error has occured. PLease try again.");
			}
			
		}
		return choice;
	}
	//sort function
	//shell sort- from https://www.geeksforgeeks.org/shellsort/
	 public static void sortTitle(Book arr[]) 
	    { 
	        int n = arr.length; 
	   
	        for (int gap = n/2; gap > 0; gap /= 2) 
	        { 
	           
	            for (int i = gap; i < n; i += 1) 
	            { 
	                Book temp = arr[i]; 
	  
	              
	                int j; 
	                for (j = i; j >= gap && arr[j - gap].getTitle().compareToIgnoreCase(temp.getTitle()) > 0; j -= gap) 
	                    arr[j] = arr[j - gap]; 
	  
	               
	                arr[j] = temp; 
	            } 
	        } 
	    } 
	 public static void sortAuthor(Book arr[]) 
	    { 
	        int n = arr.length; 
	  
	        
	        for (int gap = n/2; gap > 0; gap /= 2) 
	        { 
	            
	            for (int i = gap; i < n; i += 1) 
	            { 
	                 
	                Book temp = arr[i]; 
	  
	                 
	                int j; 
	                for (j = i; j >= gap && arr[j - gap].getName().compareToIgnoreCase(temp.getName()) > 0; j -= gap) 
	                    arr[j] = arr[j - gap]; 
	  
	                
	                arr[j] = temp; 
	            } 
	        } 
	    } 
	//search function
	 public static String searchTitle(List<Book> books, String searchVal) {
		 books.First();
		 for(int i = 0; i<books.GetSize()-1;i++) {
			 if(searchVal.compareToIgnoreCase(books.GetValue().getTitle()) < 0 || searchVal.compareToIgnoreCase(books.GetValue().getTitle()) > 0 ) {
				 books.Next();
			 }
			 else if(searchVal.compareToIgnoreCase(books.GetValue().getTitle()) == 0){
				 return  books.GetValue().getTitle();
			 } 
			 else {
				 return null;
			 }
	 }
		 return null;
		    
} 
	 public static void searchAuthor(List<Book> books, String searchVal) {
		 books.First();
		 for(int i = 0; i<books.GetSize()-1;i++) {
			 if(searchVal.compareToIgnoreCase(books.GetValue().getName()) < 0 || searchVal.compareToIgnoreCase(books.GetValue().getName()) > 0 ) {
				 books.Next();
			 }
			 else if(searchVal.compareToIgnoreCase(books.GetValue().getName()) == 0){
				 String check ="";
				 if(books.GetValue().getCheckStat() == true) {
						check += "IN";
					}
					else {
						check += "OUT";
					}
				 
				 String ava = (books.GetValue().getTitle() + ", " + check);
				 
				 System.out.println(ava);
				 books.Next();
			 } 
			 else {
				 System.out.println("Author Not Found");
			 }
	 }
		 
		    
}
	 public static int checkedIn(List<Book>books) {
			int n = 0;
			books.First();
			for(int i=0; i<books.GetSize();i++) {
				if(books.GetValue().getCheckStat() == true) {
					n++;
					books.Next();
				}
				else
					books.Next();
			}
			return n;
		}
	 //output file will write over the SciFili.txt file given and also an alphabetical output to a separate file
	 public static void outputFile(Book arr[], List<Book>books) throws IOException {
		 FileWriter fw = new FileWriter("C:\\Users\\wmpsa\\OneDrive\\Documents\\LA Tech School\\SciFiLiBooks.txt");
		 FileWriter fc = new FileWriter("C:\\Users\\wmpsa\\OneDrive\\Documents\\LA Tech School\\report.txt");
		 PrintWriter output2 = new PrintWriter(fc);
		 PrintWriter output = new PrintWriter(fw);
		 sortTitle(arr);
		 books.First();
		 //alphabetical output for librarian to keep track of which books are checked in and out 
		 for(int i=0; i<arr.length; i++) {
			 int stat = 0;
			 if(arr[i].getCheckStat() == true) {
				 stat += 1;
			 }
			 output2.println(arr[i].getTitle() + ", "  + stat);
			 
		 }
		 //updates book data base check in status
		 for(int j =0; j<books.GetSize(); j++) {
			 int stat2 = 0;
			 if(books.GetValue().getCheckStat() == true) {
				 stat2 += 1;
			 }
			 output.println(books.GetValue().getTitle() + ", " + books.GetValue().getName() + ", " + stat2 + ", " + books.GetValue().getPrio());
			 books.Next();
		 }
		 fw.close();
		 fc.close();
		 output.close();
		 output2.close();
		 
	 }
	 
}

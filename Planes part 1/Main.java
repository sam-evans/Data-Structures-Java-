import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static boolean exit;
	
	public static void main(String[] args)throws IOException{
		Scanner sf = new Scanner(new File("C:\\Fall 2020 Data Structures java\\planes.txt"));
		//help from Nathan Granade
		Plane[]arr = new Plane[28];
		int i = 0;
		sf.nextLine();
		//reads the file line by line
		while(sf.hasNext()) {
			String s = sf.nextLine();
			String[] str = s.split(", ");
			int p = Integer.parseInt(str[0]);
			String d = str[1];
			int t = Integer.parseInt(str[2]);
			arr[i] = new Plane(p, d ,t);
			i++;
		}
		sf.close();
		listPlanes(arr);
		//welcome header
        menuHeader();
        while(!exit) {
        	//user options
        	menuOptions();
	        int choice = getInput();
			switch(choice) {
			case 0:
				exit = true;
				System.out.println("Thank you for using Cartisian Planes Inc.! ");
				break;
			case 1:
				
				for(i=0; i< arr.length ; i++) {
					System.out.println(arr[i].getPlaneNum() + " " + arr[i].getDestination() + " " + arr[i].getDayOfTravel());
				}
				
				
			case 2:
				if (choice > 1) { 
					int choice1 = getInput1();
					i = searchPlanes(arr, choice1);
					if(i != -1)
						System.out.println(arr[i].getPlaneNum() + " " + arr[i].getDestination() + " " + arr[i].getDayOfTravel());
					else System.out.println("Plane not found");
				}
			default:{
				System.out.println(" ");
			}
        }
        }
	}
	//followed youtube tutorial- link: https://www.youtube.com/watch?v=25kUc_ammbw&list=LLevLluJ2qvYvnb1jxSlQzKg&index=3&t=371s&ab_channel=IntrotoComputerScience
		//runs the initial menu
		//menu header
		public static void menuHeader() {
			System.out.println("+--------------------------------------+");
			System.out.println("            Welcome to                  ");
			System.out.println("       Cartisian Planes Inc.            ");
			System.out.println("+---------------------------------------+");
		}
		//menu options
		public static void menuOptions() {
			System.out.println("\nHow can we assist you?");
			System.out.println("1) View Flights");
			System.out.println("2) Search Flights");
			System.out.println("0) Exit");
		}
		public static void menuOptions1() {
			System.out.println("\nHow can we assist you?");
			System.out.println("1) Search Flights");
			System.out.println("0) Exit");
		}
		//get input from user
		private static int getInput() {
			Scanner kb = new Scanner(System.in);
			int choice = -1;
			while(choice < 0 || choice > 2 ) {
				try {
					System.out.print("\nEnter choice here: ");
					choice = Integer.parseInt(kb.nextLine());
					
				}
				catch(NumberFormatException e){
					System.out.println("Invalid choice. Please try again. ");
				}
			}
			return choice;
		}
		private static int getInput1() {
			
			Scanner kb = new Scanner(System.in);
			int choice1 = -1;
			while(choice1 < 9000 || choice1 > 9030 ) {
				try {
					System.out.print("\n Enter Plane ID: ");
					choice1 = Integer.parseInt(kb.nextLine());
					}
				catch(NumberFormatException e){
					System.out.println("Invalid choice. Please try again. ");
				}
			}
			return choice1;
				
			}
		//insertion sort array lesson
		public static void listPlanes(Plane arr[]){
		        int n = arr.length; 
		        for (int i = 1; i < n; i++) { 
		            Plane key = arr[i]; 
		            int j = i - 1; 
		  
		            while (j >= 0 && arr[j].getPlaneNum() > key.getPlaneNum()) { 
		                arr[j + 1] = arr[j]; 
		                j = j - 1; 
		            }
		            arr[j + 1] = key; 
		        }
		    }
		//Binary search help from text book
		public static int searchPlanes(Plane [] a, int searchVal) { 
		    { 
		       int lb = 0;
		       int ub =  a.length - 1; 

		       while(lb <= ub) {
		    	   int mid = (lb+ub)/2;
		    	   if (a[mid].getPlaneNum() == searchVal) {
		    		   return mid;
		    	   }
		    	   else if (searchVal > a[mid].getPlaneNum()) {
		    		   lb = mid + 1;
		    	   }
		    	   else {
		    		   ub = mid - 1;
		    	   }
		       }
		       return -1;
		    }
		}
	}

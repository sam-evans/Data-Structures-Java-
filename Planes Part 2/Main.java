
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	static boolean exit;
	
	public static void main(String[] args)throws IOException{
		//scan planes.txt
		Scanner sf = new Scanner(new File("C:\\Users\\wmpsa\\OneDrive\\Documents\\LA Tech School\\Fall 2020 Data Structures java\\prjPlanesPt2\\src\\planes.txt"));
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
			//boolean to read "yes" and "no" as true and false
			Boolean hm = Boolean.parseBoolean(str[3]);
			if (str[3].equals("yes")) {
				hm = true;
			}
			else {
				hm = false;
			}
			int row = Integer.parseInt(str[4]);
			int numPerRow = Integer.parseInt(str[5]);
			arr[i] = new Plane(p, d ,t, hm, row, numPerRow);
			i++;
		}
		sf.close();
		sortPlanes(arr);
		
		
		//scan bookings.csv
		Scanner sc = new Scanner(new File("C:\\Users\\wmpsa\\OneDrive\\Documents\\LA Tech School\\bookings.csv"));
		
		sc.nextLine();
		while(sc.hasNext()) {
			String s = sc.nextLine();
			String[] str = s.split(",");
			int p = Integer.parseInt(str[0]);
			i = searchPlanes(arr,p);
			String n = str[1];
			String fp = str[2];
			if (arr[i].getHasMeal() == false)
				fp = "snack";
			int row = Integer.parseInt(str[3]);
			int seat = Integer.parseInt(str[4]);
			arr[i].addPassenger(n, fp, row, seat);
		}
		
		sc.close();
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
					System.out.println("Plane ID:" + arr[i].getPlaneNum() + "  Destination:" + arr[i].getDestination() + "  Day of travel:" + arr[i].getDayOfTravel() + "  Food:" + arr[i].getHasMeal() + "  Compacity:" + arr[i].getNumOnPlane() + "/" + arr[i].getMaxSeats());
				}
				
				
			case 2:
				if (choice == 2) { 
					int choice1 = getInput1();
					i = searchPlanes(arr, choice1);
					if(i != -1) {
						System.out.println("ID:" + arr[i].getPlaneNum() + "  Des:" + arr[i].getDestination() + " DoT:" + arr[i].getDayOfTravel());
						arr[i].fullPlane();
						if (arr[i].getHasMeal() == true){
							arr[i].foodOps();
						}
						else {
							System.out.println("Meal not included");
						}
						}
					else {
						System.out.println("Plane not found");
					}
					while(choice == 2) {
					menu2();
					int num = getInput();
					switch(num) {
					case 0:
						choice = 1;
					case 1:
						if (num==1) {
						arr[i].passengerList();
						}
					case 2:
						if(num == 2) {
						String name = inputSearchPassenger();
						arr[i].searchPassenger(name);
						}
					case 3:
						if(num == 3) {
						arr[i].displayEmpySeats();
						}
					}
					}
				}

			case 3:
				if(choice == 3) {
					 buyFlight(arr);
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
			System.out.println("2) Search Flight");
			System.out.println("3) Buy Flight");
			System.out.println("0) Exit");
		}
		public static void menu2() {
			System.out.println("\n1) Passenger List");
			System.out.println("2) Search passenger");
			System.out.println("3) View empty seats");
			System.out.println("0) Go back");
		}
		//get input from user
		private static int getInput() {
			Scanner kb = new Scanner(System.in);
			int choice = -1;
			while(choice < 0 || choice > 3 ) {
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
					System.out.print("\nEnter Plane ID: ");
					choice1 = Integer.parseInt(kb.nextLine());
					}
				catch(NumberFormatException e){
					System.out.println("Invalid choice. Please try again. ");
				}
			}
			return choice1;
				
			}
		//works
		public static void buyFlight(Plane[] arr) {
			Scanner kb = new Scanner(System.in);
			int p = -1;
			String n = null;
			String fp = null;
			int row = -1;
			int seat = 0;
			while(seat == 0) {
				try {
					int i;
					System.out.println("Enter Plane Num");
					p = Integer.parseInt(kb.nextLine());
					i = searchPlanes(arr,p);
					arr[i].displayEmpySeats();
					System.out.println("\nEnter Name ");
					
					if(arr[i].getHasMeal() == true) {
						n = kb.nextLine();
						System.out.println("\nEnter Food Preference");
						fp = kb.nextLine();
						
					}
					else {
						n = kb.nextLine();
						fp = "snack";
					}
					System.out.println("\nEnter row");
					row = Integer.parseInt(kb.nextLine());
					System.out.println("\nEnter seat");
					seat = Integer.parseInt(kb.nextLine());
					if(arr[i].emptySeats(row, seat)) {
						arr[i].addNewPassenger(n, fp, row, seat);
						System.out.println("Enjoy your flight!");
					}
					else {
						System.out.println("Seat is taken.");
					}
					
				}
				catch(Exception e) {
					System.out.println("Invalid choice. Please try again. ");
				}
			}
			
		}
		public static String inputSearchPassenger() {
		
			Scanner kn = new Scanner(System.in);
			String input = null;
			while(input == null) {
				try {
					System.out.println("Please enter passengers name: ");
					input = kn.nextLine();
				}
				catch(Exception e) {
					System.out.println("Error has occured. Please try again");
				}
			}
			return input;
		}
		//insertion sort array lesson
		public static void sortPlanes(Plane arr[]){
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

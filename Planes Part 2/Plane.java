
public class Plane{
	//Private variables
	private int PlaneNum;
	private String Destination;
	private int DayOfTravel;
	private boolean HasMeal;
	private int NumOnPlane;
	private int MaxSeats;
	private Passenger[][] Bookings;
;

	
	public Plane(int p, String d, int t, Boolean hm, int row, int numPerRow) {
		PlaneNum = p;
		Destination = d;
		DayOfTravel = t;
		HasMeal = hm;
		MaxSeats = row*numPerRow;
		Bookings = new Passenger[row][numPerRow];
	}

	//setters and getters for all variables
	//planeNum
	public void setPlaneNum(int PlaneNum){
		this.PlaneNum = PlaneNum;
	}
	public int getPlaneNum(){
		return this.PlaneNum;
	}
	
	//Destination
	public void setDestination(String Destination){
		this.Destination = Destination;
	}
	public String getDestination(){
		return this.Destination;
	}
	
	//DayofTravel
	public void setDayOfTravel(int DayOfTravel){
		this.DayOfTravel = DayOfTravel;
	}
	public int getDayOfTravel(){
		return this.DayOfTravel;
	}
	
	//HasMeal
	
	public void setHasMeal(boolean HasMeal){
		this.HasMeal = HasMeal;
	}
	public boolean getHasMeal(){
		return HasMeal;
	}
	
	//NumOnPlane
	public int getNumOnPlane(){
		return NumOnPlane;
	}
	
	//MaxSeats
	public void setMaxSeats(int newMaxSeats){
		MaxSeats = newMaxSeats;
	}
	public int getMaxSeats(){
		return MaxSeats;
	}
	
	//Bookings
	public Passenger[][] getBookings(){
		return this.Bookings;
	}
	//methods
	//add passenger from bookings.csv
	public Boolean addPassenger(String n, String fp, int row, int seat) {
		if((row <= Bookings.length) && (seat <= Bookings[0].length) && (emptySeats(row, seat)))
		{
			if(NumOnPlane < MaxSeats){
				Passenger k = new Passenger(n, fp);
				Bookings[row-1][seat-1] = k;
				NumOnPlane++;
			}
			return true;
		}
		else 
			return false;
	}
	//adds new bookings
	public Boolean addNewPassenger(String n, String fp, int row, int seat) {
		if((row <= Bookings.length) && (seat <= Bookings[0].length) && (emptySeats(row, seat)))
		{
			if(NumOnPlane <= MaxSeats){
				Passenger k = new Passenger(n, fp);
				Bookings[row-1][seat-1] = k;
				NumOnPlane++;
				return true;
			}
			else {
				System.out.println("Plane is full");
				return false;
			}
		}
		else {
			System.out.println("Seat is taken at Row:" + row + " Seat:" + seat);
			return false;
		}
			
	}
	
	// return how many of each FoodPreference are on the plane
	public  void foodOps() {
		int i;
		int j;
		String chicken = "chicken";
		String pasta = "pasta";
		int numChicken = 0;
		int numPasta = 0;
		int numSpecial = 0;
		for (i=0; i<Bookings.length; i++){
			for(j=0; j<Bookings[0].length; j++) {
				if(Bookings[i][j] != null) {
					if(chicken.equalsIgnoreCase(Bookings[i][j].getFoodPreference()))
					{
						numChicken++;
					}
					else if(pasta.equalsIgnoreCase(Bookings[i][j].getFoodPreference()))
					{
						numPasta++;
					}
					else {
						numSpecial++;
					}
				}
			}
			}
		System.out.println("Meals: Chicken " + numChicken + " Pasta " + numPasta + " Special " + numSpecial);
		
	}
	
	//return a list of who's on the plane and in which seat 
	//done 
	public  void passengerList() {
		int i;
		int j;
		for(i=0; i<Bookings.length; i++) {
			for(j=0; j<Bookings[0].length; j++) {
				if(Bookings[i][j] != null)
					System.out.println(Bookings[i][j].getName()  + " " + Bookings[i][j].getFoodPreference() + " Row:" + i + " Seat:" + j);
			}
			}
				
		}

	
	//find a passenger on a plane and return the seat 
	public  void searchPassenger(String name) {
		int i;
		int j;
		for(i=0; i<Bookings.length; i++) {
			for(j=0;j<Bookings[0].length;j++) {
				if(Bookings[i][j] != null) {
					Bookings[i][j].getName().compareTo(name);
					if(Bookings[i][j].getName().equals(name)) {
						System.out.println(name + "\nRow:"+ (i+1) + "\nSeat:" + (j+1) + "\nMeal: " + Bookings[i][j].getFoodPreference());
						break;
					}
				}
			}
		}
	}
	
	//tells user if the plane is full
	//also tells user how many are on plane
	//done
	public void fullPlane() {
		if (getNumOnPlane() == getMaxSeats()) {
			System.out.println("Plane is full :(");
			
		}
		else {
			System.out.println("Passengers on board: "+getNumOnPlane() + "/" + getMaxSeats());
		}
		
		
	}
	
	//tells user if a seat is booked 
	//done
	public Boolean seatAlreadyBooked(int row, int seat) {
		if(Bookings[row-1][seat-1] != null)
			return true;
		else
			return false;
	}
	
	//tells user available seats  
	//done
	public  Boolean emptySeats(int row, int seat) {
		if(Bookings[row-1][seat-1] != null)
			return false;
		else
			return true;
	}
	
	public  void displayEmpySeats() {
		int i;
		int j;
		for(i=0; i<Bookings.length; i++) {
			for(j=0; j<Bookings[0].length; j++) {
				if(Bookings[i][j] == null)
					System.out.println("Row:" + (i+1) + " Seat:" + (j+1));		
		}
		}
			
	}
}

	
	
 
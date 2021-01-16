public class Passenger {
	private String Name;
	private String FoodPreference;
	
	public Passenger(String n, String fp) {
		
		Name = n;
		FoodPreference = fp;
		
	}
	public void setName(String n){
		this.Name = n;
	}
	public String getName(){
		return Name;
	}
	public void setFoodPreference(String fp){
		this.FoodPreference = fp;
	}
	public String getFoodPreference(){
		
		return FoodPreference;
	}
	

}

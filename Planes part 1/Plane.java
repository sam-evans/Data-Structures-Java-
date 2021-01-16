import java.io.*;
import java.util.*;

public class Plane{
	//Private variables
	private int PlaneNum;
	private String Destination;
	private int DayOfTravel;
	
	

	public Plane(int p, String d, int t) {
		
		PlaneNum = p;
		Destination = d;
		DayOfTravel = t;
	}

	//setters and getters for all variables
	//planeNum
	public void setPlaneNum(int newPlaneNum){
		this.PlaneNum = newPlaneNum;
	}
	public int getPlaneNum(){
		return PlaneNum;
	}
	
	//Destination
	public void setDestination(String newDestination){
		this.Destination = newDestination;
	}
	public String getDestination(){
		return Destination;
	}
	
	//DayofTravel
	public void setDayOfTravel(int newDayOfTravel){
		this.DayOfTravel = newDayOfTravel;
	}
	public int getDayOfTravel(){
		return DayOfTravel;
	}
}
	
	
 
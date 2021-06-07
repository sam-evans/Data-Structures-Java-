package math;

//This program brute force proves the only consecutive perfect powers that are less than or equal to 10,000 
//are 8 and 9


import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;
public class Main{


    public static void main(String[] args) {
        
    ArrayList<Integer> arr = new ArrayList(); 
        for(int i= 2; i <= 100; i++){
            int a = 2;
            double result = (Math.pow(i, a));
            if (result <= 10000) {
            	System.out.println(result);
            	arr.add((int) result);
            }
            
            while(result <= 10000) {
            	
            	a++; 
            	result = (Math.pow(i, a));
            	 if (result <= 10000) {
                 	System.out.println(result);
                 	arr.add((int) result);
                 }
            }

           
            
        }
        Collections.sort(arr);
        System.out.println(arr.toString());
    }
       

}
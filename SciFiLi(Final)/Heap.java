
public class Heap {

	

	//code from-https://www.geeksforgeeks.org/heap-sort/
	 void heapify(Book arr[], int n, int i) 
	    { 
	        int largest = i; // Initialize largest as root 
	        int l = 2*i + 1; // left = 2*i + 1 
	        int r = 2*i + 2; // right = 2*i + 2 
	  
	        // If left child is larger than root 
	        if (l < n && arr[l].getPrio() > arr[largest].getPrio()) 
	            largest = l; 
	  
	        // If right child is larger than largest so far 
	        if (r < n && arr[r].getPrio() > arr[largest].getPrio()) 
	            largest = r; 
	  
	        // If largest is not root 
	        if (largest != i) 
	        { 
	            Book swap = arr[i]; 
	            arr[i] = arr[largest]; 
	            arr[largest] = swap; 
	  
	            // Recursively heapify the affected sub-tree 
	            heapify(arr, n, largest); 
	        } 
	    }
	  public void sort(Book arr[]) 
	    { 
	        int n = arr.length; 
	  
	         
	        for (int i = n / 2 - 1; i >= 0; i--) 
	            heapify(arr, n, i); 
	  
	      
	        for (int i=n-1; i>0; i--) 
	        { 
	           
	            Book temp = arr[0]; 
	            arr[0] = arr[i]; 
	            arr[i] = temp; 
	  
	            
	            heapify(arr, i, 0); 
	        } 
}
}

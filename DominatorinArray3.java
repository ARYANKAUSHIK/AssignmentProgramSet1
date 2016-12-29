import java.util.Scanner;
public class DominatorinArray3 {
  
  public int solution(int[] A) {
    //input integer array 
	Scanner s=new Scanner(System.in);
    System.out.println(" Enter number of elements to insert in an array of size N less than 100000 in Size ");
    int n=s.nextInt();
    int arr[]=new int[n];
    System.out.println("\n Enter elements of the array to find Dominator : ");
    for(int i=0;i<n;i++){//for reading array input
        arr[i]=s.nextInt();
    }
    for(int i: arr){ //for printing stored array initially 
        System.out.print("\n Input numbers are "+i);
    }
       // write your code in Java SE 
        int sizecount = 0; int val = 0;
        //We calculate the value of the most value of appear from the array
        //We keep that in the value. 
        for (int i = 0; i < A.length; i++) {
            if(sizecount == 0) { sizecount++; val = A[i];
               } 
			else {
				if (val != A[i]) { sizecount -=1;  } 
	      		else { sizecount++;  }
                 }
        }
        int candidate = -1;
        if(sizecount > 0) {
            candidate = val;
        }
        int index = -1;
        int count = 0;
        // step to determine the most element of the array is more than half of array length or not. 
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) { 
			count++; index = i;
            }
        }
        
        //if it's not more than half we return -1
        
        if(count > (A.length/2)) {
            return index;  //otherwise we return the index... 
        } else {
            return -1;  // Here we don't return the value itself because no Dominatr is found in Array ..
        }
    }
}
import java.io.File;
import java.util.Scanner;
public class OS_Finding {
	// A method to swap elements of the given array
	public static void swap(int[] arr, int left, int right) {
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}// end swap
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int index = left;
		for(int i = left; i <= right - 1; i++) {
			if(arr[i] <= pivot) {
				swap(arr, index,i);
				index++;
			}
		}
		swap(arr, index, right);
		return index;
	} // end partition
	// A method created to get a random number for our random partition
	public static int random(int min, int max){
		return min + (int)(Math.random()*((max-min) + 1));
	    } // end random
	public static int randomizedPartition(int[] arr, int left, int right) {
		int i = random(left, right);
		swap(arr, i, right);
		return partition(arr, left, right);
	}// end Random Partition
	public static int randomizedSelect(int[] A, int p, int r, int i) {
		if(p == r)
			return A[p];
		int q = randomizedPartition(A,p,r); 
		int k = q - p + 1;
		if(i==k) {
			return A[q];
		}
		else if (i<k) {
			return randomizedSelect(A,p,q-1,i);
		}
		else {
			return randomizedSelect(A,q+1,r,i-k);
		}
	}// end randomizedSelect
	public static void main(String[] args) {
		int arg2;
		try {
			arg2 = Integer.parseInt(args[1]);
			File file = new File(args[0]);
			Scanner reader = new Scanner(file);
			int count = 0;
			while(reader.hasNextInt()) {
				count++;
				reader.nextInt();
			}
			int[] A = new int[count];
			Scanner read = new Scanner(file);
			for(int i = 0; i < A.length; i++) {
				A[i] = read.nextInt();
			}
			if(arg2 <= A.length) {
				System.out.println(randomizedSelect(A, 0, A.length - 1, arg2));
			}
			else {
				System.out.println("null");
			}
			reader.close();
			read.close();
			
		}catch(Exception e) {
			return;
		} // end try catch
		
	} // end main
} // end OS_Finding class

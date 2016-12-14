package arrays;

public class ArrayMethods {

    public static void main(String[] args) {
    	int[] a = {5, 4, 3, 2, 1};
    	int[] b = {5, 4, 3, 2, 1, 0};
    	double[] c = {5, 4, 2, 3, 1};
    	int[] d = {1, 2, 3, 4, 5, 7, 8};
    	int[] e = {3,7,4,2,8,6,2,9};
    	//searchUnsorted(a, 5);
    	//searchSorted(a, 5);
    	//isSorted(a);
    	//getStats(c);
    	//reverseOrder(a);
    	//countDifferences(a, b);
    	longestConsecutiveSequence(d); //does not work on codeboard, works on eclipse
    	
    	//generateDistinctItemsList(20); does not work on codeboard, works on eclipse
    	//cycleThrough(e, 49);
    }
    
    public static int searchUnsorted(int[] arrayToSearch, int key){
    	for(int i = 0; i < arrayToSearch.length; i++){
    		if(arrayToSearch[i] == key){
    			System.out.println(key + " was found at index " + i);
    			return i;
    		}	
    	}
    	System.out.println("Key was not found");
    	return -1;
    }
    
    public static int searchSorted(int[] sortedArrayToSearch, int key){
    	if(isSorted(sortedArrayToSearch)){
    		for(int i = 0; i < sortedArrayToSearch.length; i++){	
    			if(sortedArrayToSearch[i] == key){
    				System.out.println(key + " was found at index " + i);
    				return i;
    			}		
    		}
    	}
    	System.out.println("Key was not found");
    	return -1;
    }
    
    public static boolean isSorted(int[] array){
    	for(int i = 1; i < array.length; i++){	
    		if(array[i-1] < array[i]){
    			System.out.println(array[i-1] + " comes after " + array[i]);
    			System.out.println("Array is not sorted");
    			return false;
    		}
    	}
    	System.out.println("Array is sorted");
    	return true;
    }
    
    public static double[] getStats(double[] array){
         double[] stats = new double[6];
         sortArray(array);
         stats[0] = getMean(array);
         stats[1] = array[0];
         stats[2] = array[array.length - 1];
         stats[3] = getMedian(array);
         stats[4] = getNumValuesAboveMean(array, stats[0]);
         stats[5] = getNumValuesBelowMean(array, stats[0]); 
         for(int i = 0; i < stats.length; i++){
        	 System.out.println(stats[i]);
         }
         return stats;
    }
    
    private static double getNumValuesBelowMean(double[] array, double mean) {
    	int numBelow = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] < mean){
				numBelow++;
			}
		}
		return numBelow;
	}

	private static double getNumValuesAboveMean(double[] array, double mean) {
		int numAbove = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] >= mean){
				numAbove++;
			}
		}
		return numAbove;
	}

	private static double getMedian(double[] array) {
    	int split = 0;
		if(array.length % 2 == 1){
			split = (array.length - 1)/2;
			return array[split];
		}
		else{
			split = array.length/2;
			return (array[split] + array[split - 1])/2;
		}
	}

	private static double getMean(double[] array) {
    	double sum = 0.0;
    	double avg = 0.0;
		for(int i = 0; i < array.length; i++){
			sum = sum + array[i];
		}
		avg = sum/array.length;
		System.out.println(avg);
		return avg;
	}

	private static void sortArray(double[] array) {
		for(int i = 0; i < array.length; i++){
			for(int j = i + 1; j < array.length; j++){
				double first = array[i];
				double second = array[j];
				double temp = first;
				if(first < second){
					temp = array[i];
					array[i] = second;
					array[j] = temp;
				}
			}
		}
	}

	public static void reverseOrder(int[] array){
		int split;
		int lastIndex = array.length - 1;
		if(array.length % 2 == 1){
			split = (array.length - 1)/2;
			for(int i = 0; i < split; i++){
				swap(array, i, lastIndex);
				lastIndex--;
			}
		}
		else{
			split = (array.length + 1)/2;
			for(int i = 0; i < split; i++){
				swap(array, i, lastIndex);
				lastIndex--;
			}
		}
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
		}
    }
    
    public static int countDifferences(int[] array1, int[] array2){
    	int count = 0;
    	if(array1.length != array2.length){
    		System.out.println("The length of the arrays are not the same");
    		return 0;
    	}
    	else{
    		for(int i = 0; i < array1.length; i++){
    			if(array1[i] != array2[i]){
    				count++;
    			}
    		}
    		System.out.println("Number of difference(s): " + count);
    		return count;
    	}
    }  

    public static int longestConsecutiveSequence(int[] array1){
        int longestSeq = 1;
        int inOrder = 1;
        for(int i = 1; i < array1.length; i++){
        	if(array1[i - 1] + 1 == array1[i]){
        		inOrder++;
        	}
        	else{
        		if(inOrder > longestSeq){
        			longestSeq = inOrder;
        		}
        		inOrder = 1;
        	}
        }
        System.out.println("Number of consecutive integers: " + longestSeq);
        return longestSeq;
    }

    public static int longestSharedSequence(int[] array1, int[] array2){
        int max = 0;
        int count = 0;
        
        for(int seqStart = 0; seqStart < array1.length; seqStart++){
        	int seqEnd = seqStart;
        	int[] seq = getSequence(seqStart, seqEnd, array1);
        	if(checkSequence(seq, array2)){
        		count++;
        		if(count > max){
        			max = count;
        		}
        	}
        	//reset count after ever seq has been checked
        	count = 0;
        }
        
        return max;
    }

    //returns true if seq is found inside array2
    private static boolean checkSequence(int[] seq, int[] arr) {
		//i checks every value in arr
    	for(int i = 0; i < arr.length; i++){
    		//j checks every element in seq
    		for(int j = 0; j < seq.length; j++){
    			if(j+i < arr.length && seq[j] != arr[j+i]){
    				//breaks out of inner-most for loop unless particular for loop is specified (labels "A:")
    				break;
    			}
    			else if(j == seq.length - 1){
    				return true;
    			}
    		}
    	}
		return false;
	}

	private static int[] getSequence(int seqStart, int seqEnd, int[] array1) {
		// returns sub array containing the elements in array1 from seqStart to seqEnd
		return null;
	}

	public static int[] generateDistinctItemsList(int n){
		int random;
		int[] distinctItems = new int[n];
		for(int i = 0; i < n; i++){
			random = (int)(Math.random()*2*n) + 1;
			for(int j = 0; j < distinctItems.length; j++){
				if(random == distinctItems[j]){
					random = (int)(Math.random()*2*n) + 1;
				}
			}
			distinctItems[i] = random;	
		}
		for(int i = 0; i < distinctItems.length; i++){
			System.out.println(distinctItems[i]);
		}
		System.out.println("Length of array: " + distinctItems.length);
        return distinctItems; 
    }
    
    
    public static void cycleThrough(int[] array, int n){
    	for(int i = 0; i < n; i++){
    		cycleOnce(array);	
    	}
    	for(int i = 0; i < array.length; i++){
    		System.out.println(array[i]);
    	}
    }
    
    private static void cycleOnce(int[] arr){
    	for(int i = 0; i < arr.length - 1; i++){
    		for(int j = 1; j < arr.length; j++){
    			swap(arr, 0, j);
    		}
    	}
    }
    
    private static void swap(int[] arr, int a, int b) {
		int placeholder = arr[a];
		arr[a] = arr[b];
		arr[b] = placeholder;
	}
    
}
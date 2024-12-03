package aoc2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day02 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("words.txt"));
		ArrayList<int[]> arr = new ArrayList<>();
		while(scan.hasNext()) {
			arr.add(stringArrToIntArr(scan.nextLine().split(" ")));
		}
		partOne(arr);
		partTwo(arr);
		scan.close();
	}
	
	public static int[] stringArrToIntArr(String[] arr) {
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = Integer.parseInt(arr[i]);
		}
		return res;
	}
	
	private static void partOne(ArrayList<int[]> arr) {
		int acceptableReports = 0;
		for (int[] is : arr) {
			if((isSortedAscending(is) || isSortedDescending(is)) && isAcceptableJumps(is)){
				acceptableReports++;
			}
		}
		System.out.println(acceptableReports);
	}


	private static void partTwo(ArrayList<int[]> arr) {
	    int safeReports = 0;

	    for (int[] is : arr) {
	        if ((isSortedAscending(is) || isSortedDescending(is)) && isAcceptableJumps(is)) {
	            safeReports++;
	        } else {
	            for (int i = 0; i < is.length; i++) {
	                int[] reducedArr = removeIndex(is, i);
	                if ((isSortedAscending(reducedArr) || isSortedDescending(reducedArr)) && isAcceptableJumps(reducedArr)) {
	                    safeReports++;
	                    break;
	                }
	            }
	        }
	    }

	    System.out.println(safeReports);
	}

	private static int[] removeIndex(int[] arr, int index) {
	    int[] newArr = new int[arr.length - 1];
	    for (int i = 0, j = 0; i < arr.length; i++) {
	        if (i != index) {
	            newArr[j++] = arr[i];
	        }
	    }
	    return newArr;
	}

	
	public static boolean isSortedAscending(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1] || arr[i] == arr[i+1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSortedDescending(int[] arr) {
	    for (int i = 0; i < arr.length - 1; i++) {
	        if (arr[i] < arr[i + 1] || arr[i] == arr[i+1]) {
	            return false;
	        }
	    }
	    return true;
	}

	
	public static boolean isAcceptableJumps(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if(Math.abs(arr[i-1] - arr[i]) > 3) {
				return false;
			}
		}
		return true;
	}
}

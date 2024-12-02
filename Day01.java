import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Day01 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("words.txt"));
		//prepping data
		LinkedList<Integer> rightList = new LinkedList<Integer>();
		LinkedList<Integer> leftList = new LinkedList<Integer>();

		while (scan.hasNextLine()) {
			String[] arr = scan.nextLine().split("   ");

			rightList.add(Integer.parseInt(arr[0]));
			leftList.add(Integer.parseInt(arr[1]));
		}
		
		Collections.sort(rightList);
		Collections.sort(leftList);


		partOne(rightList, leftList);
		partTwo(rightList, leftList);
		scan.close();
	}

	private static void partTwo(LinkedList<Integer> rightList, LinkedList<Integer> leftList) {
		HashMap<Integer, Integer> numOfOccurences = new HashMap<Integer, Integer>();
		for (Integer integer : rightList) {
			numOfOccurences.put(integer, numOfOccurences.getOrDefault(integer, 0) + 1);
		}
		
		int ans = 0;
		
		for(Integer in : leftList) {
			ans += (in *numOfOccurences.getOrDefault(in, 0));
		}
		
		System.out.println("part two's answer is - " + ans);
	}

	private static void partOne(LinkedList<Integer> rightList, LinkedList<Integer> leftList) {
		int ans = 0;
		for (int i = 0; i < rightList.size(); i++) {
			ans += findDistance(rightList.get(i), leftList.get(i));
		}

		System.out.println("part one's answer is - " + ans);
	}

	private static int findDistance(int one, int two) {
		return Math.abs(one - two);
	}
}

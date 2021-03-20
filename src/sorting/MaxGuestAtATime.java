package sorting;

import java.util.Arrays;

/*
 * Given two array of int i.e. arrival and departure
 * find time frame where max people will be present
 */
public class MaxGuestAtATime {
	public static void main(String[] args) {
		int[] arrival= {100,500,700};
		int[] departure= {200,800,800};
		System.out.println(maxGuestAtATime(arrival, departure));
	}

	public static int maxGuestAtATime(int[] arrival, int[] departure) {
		Arrays.sort(arrival);
		Arrays.sort(departure);
		// i for arrival, j for departure
		int i = 1, j = 0, res = 0, curr = 1, n = arrival.length;
		//merge logic
		while (i < n && j < n) {
			if (arrival[i] <= departure[j]) {
				curr++;
				i++;
			} else {
				curr--;
				j++;
			}
			res=Math.max(res, curr);
		}
		return res;
	}

}

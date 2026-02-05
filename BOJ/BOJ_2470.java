package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {
	/*
	 * BOJ 2470: 두 용액
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int l = 0; int r = N - 1;
		int min = Integer.MAX_VALUE; int[] ans = new int[2];
		while (l < r) {
			int sum = arr[l] + arr[r];
			int diff = Math.abs(sum - 0);
			if (diff < min) { 
				min = diff;
				ans[0] = arr[l]; 
				ans[1] = arr[r];
				}
							
			if (sum < 0) l++;
			else if (sum > 0) r--;
			else break;
		}
	
		System.out.println(ans[0] + " " + ans[1]);
	}
}

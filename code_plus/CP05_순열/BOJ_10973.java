package code_plus.CP05_순열;

/*
 * BOJ 10973 : 이전 순열
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10973 {
	static int[] arr;
	
	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static boolean pre_permutation() {
		int i = arr.length - 1;
		
		while (i > 0 && arr[i] >= arr[i - 1]) { i--; }
		if (i == 0) return false;
		
		int j = arr.length - 1;
		
		while (arr[j] >= arr[i - 1]) { j--; }
		
		swap(i - 1, j);
		j = arr.length - 1;
		
		while (i < j) {
			swap(i, j);
			i++;
			j--;
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (pre_permutation()) {
			for (int val : arr)
				sb.append(val).append(" ");
		} else {
			sb.append("-1");
		}
		
		System.out.println(sb);
	}

}

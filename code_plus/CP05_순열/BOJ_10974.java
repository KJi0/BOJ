package code_plus.CP05_순열;

/*
 * BOJ 10974 : 모든 순열
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974 {
	static int N;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void next_permutation() {		
		int i = arr.length - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {	i--; }
		if (i == 0) return;
		
		int j = arr.length - 1;
		while (arr[i - 1] >= arr[j]) { j--; }
		
		swap(i - 1, j);
		
		j = arr.length - 1;
		
		while (i < j) {
			swap(i, j);
			i++;
			j--;
		}
		
		for (int val : arr) {
			sb.append(val).append(" ");
		} sb.append('\n');
		
		next_permutation();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		for (int i = 1; i <= N; i++) {
			arr[i - 1] = i;
			sb.append(i).append(" ");
		} sb.append('\n');
		
		next_permutation();
		
		System.out.println(sb);
	}
}
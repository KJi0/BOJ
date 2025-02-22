package code_plus.CP05_순열;

/*
 * BOJ 10972 : 다음 순열
 * 순열 알고리즘도 잘 알아 둡시다요!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10972 {
	static int arr[];
	
	public static boolean next_permutation () {
		int i = arr.length - 1;
		
		// 1. arr[i-1] < arr[i]를 만족하는 가장 큰 i 찾기
		while (i > 0 && arr[i - 1] >= arr[i]) { i--; }
		if (i == 0) return false;
		
		int j = arr.length - 1;
		
		// 2. j >= i 이면서 arr[j] > arr[i - 1]을 만족하는 최대 j 찾기
		while (arr[i - 1] >= arr[j]) { j--; }
		
		// 3. arr[i - 1]과 arr[j]를 swap
		swap(i - 1, j);
		
		// 4. arr[i]부터 오름차순 정렬
		j = arr.length - 1;
		
		while (i < j) {
			swap(i, j);
			i++;
			j--;
		}
		
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
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
		
		if (next_permutation()) {
			for (int val : arr)
				sb.append(val).append(" ");
		} else {
			sb.append("-1");
		}
		
		System.out.println(sb);
	}
}
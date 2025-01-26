package code_plus.CP02_브루트_포스;

/*
 * BOJ 2309 : 일곱 난쟁이
 * 
 * 찾았으면 바로 return으로 프로그램 종료!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int sum = 0;
		
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		for(int i = 0; i < 8; i++) {
			for(int j = i + 1; j < 9; j++) {
				if (sum - arr[i] - arr[j] == 100) {
					arr[i] = arr[j] = 0;
					Arrays.sort(arr);
					for(int k = 2; k < 9; k++)
						System.out.println(arr[k]);
					
					return;
				}
			}
		}
	}
}
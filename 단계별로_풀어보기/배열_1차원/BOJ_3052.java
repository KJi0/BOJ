package 단계별로_풀어보기.배열_1차원;

/*
 * BOJ 3052 : 나머지
 * 배열을 활용하여 서로 다른 값의 개수를 찾는 문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3052 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] arr = new boolean[42];
		int cnt = 0;
		
		for(int i = 0; i < 10; i++) {
			arr[Integer.parseInt(br.readLine()) % 42] = true;
		}
		
		for(boolean val : arr) {
			if (val)
				cnt++;
		}
		System.out.println(cnt);
	}
}

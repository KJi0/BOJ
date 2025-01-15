package 단계별로_풀어보기.문자열;

/*
 * BOJ 10809 : 알파벳 찾기
 * 한 단어에서 각 알파벳이 처음 등장하는 위치를 찾는 문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[26];
		
		for(int i = 0; i < arr.length; i++)
			arr[i] = -1;
		
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if (arr[ch - 'a'] == -1)
				arr[ch - 'a'] = i;
		}
		
		for(int val : arr)
			System.out.print(val + " ");
	}
}

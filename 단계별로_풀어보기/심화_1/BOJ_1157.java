package 단계별로_풀어보기.심화_1;

/*
 * BOJ 1157 : 단어 공부
 * 주어진 단어에서 가장 많이 사용된 알파벳을 출력하는 문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int[] arr = new int[26];
		int max = -1;
		char alpa = '?';
		
		for(int i = 0; i < str.length(); i++) {
			
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
				arr[str.charAt(i) - 'A']++;
			else
				arr[str.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i < 26; i++) {
			
			if (arr[i] > max) {
				max = arr[i];
				alpa = (char) (i + 'A');
			}
			
			else if (arr[i] == max)
				alpa = '?';
		}
		
		System.out.print(alpa);
	}
}

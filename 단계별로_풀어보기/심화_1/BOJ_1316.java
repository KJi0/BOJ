package 단계별로_풀어보기.심화_1;

/*
 * BOJ 1316 : 그룹 단어 체커
 * 조건에 맞는 문자열을 찾는 문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1316 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			if (check() == true)
				cnt++;
		}
		
		System.out.print(cnt);;
	}
	
	public static boolean check() throws IOException {
		boolean[] check = new boolean[26];
		int prev = 0;
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			int now = str.charAt(i);
		
			if (prev != now) {
				
				if (!check[now - 'a'] ) {
					check[now - 'a'] = true;
					prev = now;
				}
				
				else
					return false;
			}
		}
		return true;
	}
}
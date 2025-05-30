package 단계별로_풀어보기.심화_1;

/*
 * BOJ 2941 : 크로아티아 알파벳
 * 두세 문자가 한 글자로 묶일 수 있을 때 글자의 수를 세는 문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int len = str.length();
		int cnt = 0;
		
		for(int i = 0; i < len; i++) {
			
			char ch = str.charAt(i);
			
			if (ch == 'c' && i < len - 1) {
				if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-')
					i++;
			}
			
			else if (ch == 'd' && i < len - 1) {
				if (str.charAt(i + 1) == 'z' && i < len - 2) {
					if (str.charAt(i + 2) == '=')
						i += 2;
				}
				
				else if (str.charAt(i + 1) == '-')
					i++;
			}
			
			else if ((ch == 'l' || ch == 'n') && i < len - 1) {
				if (str.charAt(i + 1) == 'j')
					i++;
			}
			
			else if ((ch == 's' || ch == 'z') && i < len - 1) {
				if (str.charAt(i + 1) == '=')
					i++;
			}
			
			cnt++;
		}
		System.out.print(cnt);
	}
}
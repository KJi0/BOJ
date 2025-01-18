package 단계별로_풀어보기.심화_1;

/*
 * BOJ 25206 : 너의 평점은
 * 열심히 문제를 푸시는 여러분은 A+입니다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25206 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		
		double sum = 0;
		double grade = 0;
		
		for(int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			double n = Double.parseDouble(st.nextToken());
			String str = st.nextToken();
			
			if (str.equals("P"))
				continue;
			
			sum += n;
			grade += n * check(str);
		}
		
		System.out.printf("%.6f", grade / sum);
	}

	public static double check(String str) throws IOException {
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if (ch == 'A') {
				if (str.charAt(i + 1) == '+')
					return 4.5;
				else if (str.charAt(i + 1) == '0')
					return 4.0;
			}
			
			else if (ch == 'B') {
				if (str.charAt(i + 1) == '+')
					return 3.5;
				else if (str.charAt(i + 1) == '0')
					return 3.0;
			}
			
			else if (ch == 'C') {
				if (str.charAt(i + 1) == '+')
					return 2.5;
				else if (str.charAt(i + 1) == '0')
					return 2.0;
			}
			
			else if (ch == 'D') {
				if (str.charAt(i + 1) == '+')
					return 1.5;
				else if (str.charAt(i + 1) == '0')
					return 1.0;
			}
			
			else if (ch == 'F')
				return 0.0;
		}
		
		return 0;
	}
}

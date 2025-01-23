package code_plus.CP01_수학;

/*
 * BOJ 2609 : 최대공약수와 최소공배수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int d = gcd(a, b);
		
		sb.append(d).append('\n');
		sb.append(a * b / d);
		
		System.out.print(sb);
	}

	
	public static int gcd(int a, int b) {
			if (b == 0)
				return a;
			
			return gcd(b, a % b);
	}
}

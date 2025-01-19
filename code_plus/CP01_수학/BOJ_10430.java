package code_plus.CP01_수학;

/*
 * BOJ 10430 : 나머지
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10430 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		sb.append((A + B) % C).append('\n');
		sb.append(((A % C) + (B % C)) % C).append('\n');
		sb.append((A * B) % C).append('\n');
		sb.append(((A % C) * (B % C)) % C).append('\n');
		
		System.out.print(sb);
	}
}
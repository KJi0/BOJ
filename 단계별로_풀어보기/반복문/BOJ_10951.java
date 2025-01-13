package 단계별로_풀어보기.반복문;

/*
 * BOJ 10951 : A+B - 4
 * 입력이 끝날 때까지 A+B를 출력하는 문제. EOF에 대해 알아 보세요.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10951 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String str;
		
		// EOF == ctrl + Z
		while ((str = br.readLine()) != null) {
			st = new StringTokenizer(str," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			sb.append(A+B).append('\n');
		}
		System.out.print(sb);
	}
}

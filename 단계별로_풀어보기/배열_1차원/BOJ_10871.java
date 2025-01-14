package 단계별로_풀어보기.배열_1차원;

/*
 * BOJ 10870 : X보다 작은 수
 * 배열을 입력받고 X보다 작은 수를 찾는 문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10871 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			int A = Integer.parseInt(st.nextToken());
			
			if (A < X)
				sb.append(A).append(' ');
		}
		System.out.print(sb);
	}
}
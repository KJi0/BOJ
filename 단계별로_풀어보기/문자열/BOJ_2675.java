package 단계별로_풀어보기.문자열;

/*
 * BOJ 2675 : 문자열 반복
 * 각 문자를 반복하여 출력하는 문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2675 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			
			for(int j = 0; j < S.length(); j++) {
				for(int k = 0; k < R; k++)
					System.out.print(S.charAt(j));
			}
			System.out.println();
		}
	}
}

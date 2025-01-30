package code_plus.CP02_브루트_포스;

/*
 * BOJ 1476 : 날짜 계산
 * 1부터 무작정 시작...! 브루트 포스 방식 적응하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int year = 1;
		
		while(true) {
			if (E == 15) E = 0;
			if (S == 28) S = 0;
			if (M == 19) M = 0;
		
			if ((year % 15 == E) && (year % 28 == S) &&
					(year % 19 == M)) {
				System.out.print(year);
				return;
			}
			
			year++;
		}
	}
}
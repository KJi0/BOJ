package 단계별로_풀어보기.배열_1차원;

/*
 * BOJ 10818 : 최소, 최대
 * 최솟값과 최댓값을 찾는 문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10818 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Integer.parseInt(br.readLine()); // 첫 줄 N은 안 쓰이므로 입력만 받음.
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int max = -1000001;
		int min = 1000001;
		
		while(st.hasMoreTokens()) {
			int val = Integer.parseInt(st.nextToken());
			
			if (val < min)
				min = val;
			
			if (val > max)
				max = val;
		}
		
		System.out.print(min + " " + max);
	}
}
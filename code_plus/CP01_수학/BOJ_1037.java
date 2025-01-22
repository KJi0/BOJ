package code_plus.CP01_수학;

/*
 * BOJ 1037 : 약수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1037 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int I = Integer.parseInt(br.readLine());
		int N = 0;
		int max = 1;
		int min = 1000001;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		while(I-- > 0) {
			N = Integer.parseInt(st.nextToken());
			
			max = (N > max) ? N : max;
			min = (N < min) ? N : min;
		}
		
		System.out.print(max * min);
	}
}

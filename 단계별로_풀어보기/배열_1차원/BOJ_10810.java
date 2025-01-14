package 단계별로_풀어보기.배열_1차원;

/*
 * BOJ 10810 : 공 넣기
 * 최댓값이 어디에 있는지 찾는 문제
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10810 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			for(int j = I - 1; j < J; j++)
				arr[j] = K;
		}
		
		for(int k = 0; k < N; k++) {
			bw.write(arr[k]+" ");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
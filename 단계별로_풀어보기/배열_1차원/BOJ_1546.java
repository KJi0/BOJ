package 단계별로_풀어보기.배열_1차원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1546 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		double[] arr = new double[N];
		double sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N; i++)
			sum += (arr[i] / arr[arr.length - 1]) * 100;
		
		System.out.println(sum/N);
	}
}

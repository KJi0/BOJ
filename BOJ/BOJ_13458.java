package BOJ;

/*
 * BOJ 13458 : 시험 감독
 * 시간 초과 주의! 범위 주의!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long man = 0;
		for (int i = 0; i < N; i++) {
			int tmp = A[i] - B;
			man++;
			
			if (tmp > 0) {
				if (tmp % C == 0)
					man += tmp / C;
				else
					man += tmp / C + 1;
			}
		}
		
		System.out.println(man);
	}
}
package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3260 {
	/*
	 * SWEA 3260: 두 수의 덧셈
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			
			int aLen = A.length() - 1;
			int bLen = B.length() - 1;
			int carry = 0;
			
			StringBuilder sb = new StringBuilder();
			// 계산 끝났어도 올림이 남아 있으면 한 번 더 계산
			while (aLen >= 0 || bLen >= 0 || carry > 0) {
				int sum = carry;
				if (aLen >= 0) sum += A.charAt(aLen--) - '0';
				if (bLen >= 0) sum += B.charAt(bLen--) - '0';
				
				sb.append(sum % 10);
				carry = sum / 10;
			}
			
			System.out.println("#" + t + " " + sb.reverse());
		}
	}

}

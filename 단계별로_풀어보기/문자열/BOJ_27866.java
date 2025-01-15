package 단계별로_풀어보기.문자열;

/*
 * BOJ 27866 : 문자와 문자열
 * 문자열을 입력받고 문자열의 특정 위치를 읽어 봅시다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_27866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		int I = Integer.parseInt(br.readLine()) - 1;
		
		System.out.println(S.charAt(I));
	}
}

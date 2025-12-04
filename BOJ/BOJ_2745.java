package BOJ;

/*
BOJ 2745: 진법 변환
진법 문제는 항상 헷갈려
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int exp = 1;
        int sum = 0;
        for (int i = N.length() - 1; i >= 0; i--) {
            char c = N.charAt(i);

            if ('A' <= c && c <= 'Z') {
                sum += (c - 'A' + 10) * exp;
            } else {
                sum += (c - '0') * exp;
            }

            exp *= B;
        }

        System.out.println(sum);
    }
}

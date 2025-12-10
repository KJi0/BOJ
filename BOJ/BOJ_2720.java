package BOJ;

/*
BOJ 2720: 세탁소 사장 동혁
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int C = Integer.parseInt(br.readLine());

            int q = C / 25;
            int d = (C % 25) / 10;
            int n = (C % 25 % 10) / 5;
            int p = C % 25 % 10 % 5;

            System.out.println(q + " " + d + " " + n + " " + p);
        }
    }
}

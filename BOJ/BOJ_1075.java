package BOJ;

/*
BOJ 1075: 나누기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        int rest = N % 100;
        N = N - rest;
        int ans = 0;
        while (N % F != 0) {
            N++;
            ans++;
        }

        if (ans < 10) System.out.println("0" + ans);
        else System.out.println(ans);
    }
}

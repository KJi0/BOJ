package BOJ;

/*
BOJ 2903: 중앙 이동 알고리즘
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = 2; int exp = 1;

        for (int i = 0; i < N; i++) {
            num += exp;
            exp *= 2;
        }

        System.out.println(num * num);
    }
}

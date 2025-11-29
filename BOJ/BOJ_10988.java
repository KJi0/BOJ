package BOJ;

/*
BOJ 10988: 팰린드롬인지 확인하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10988 {
    static char[] c = new char[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        c = br.readLine().toCharArray();

        boolean ans = true;
        for (int i = 0; i < c.length / 2; i++) {
            if (c[i] != c[c.length - 1 - i])
                ans = false;
        }

        System.out.println(ans ? 1 : 0);
    }
}

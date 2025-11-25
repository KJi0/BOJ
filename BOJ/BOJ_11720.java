package BOJ;

/*
BOJ 11720: 숫자의 합
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int sum = 0;
        for (Byte value : br.readLine().getBytes()) {
            sum += (value - '0');
        }

        System.out.println(sum);
    }
}

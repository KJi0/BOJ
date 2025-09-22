package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int range = 2;
        int cnt = 1;

        while (range <= N) {
            range = range + (6 * cnt);
            cnt++;
        }
        System.out.println(cnt);
    }
}
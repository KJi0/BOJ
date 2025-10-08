package BOJ;

/*
BOJ 5597: 과제 안 내신 분...?
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[31];

        int n = Integer.parseInt(br.readLine());
        arr[n] = 1;

        for (int i = 0; i < 27; i++) {
            n = Integer.parseInt(br.readLine());
            arr[n] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 31; i++) {
            if (arr[i] != 1) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}

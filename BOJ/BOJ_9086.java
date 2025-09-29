package BOJ;

/*
BOJ 9086: 문자열
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String str = br.readLine();
            sb.append(str.substring(0,1)).append(str.substring(str.length() - 1, str.length()));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

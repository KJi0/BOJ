package BOJ;

/*
BOJ 2816: 디지털 티비
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2816 {
    static String[] channel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        channel = new String[N];
        for (int i = 0; i < N; i++) {
            channel[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();

        int idx = 0;
        while (!channel[idx].equals("KBS1")) {
            idx++;
            sb.append("1");
        }

        while (idx > 0) {
            swap(idx, idx - 1);
            idx--;
            sb.append("4");
        }

        while (!channel[idx].equals("KBS2")) {
            idx++;
            sb.append("1");
        }

        while (idx > 1) {
            idx--;
            sb.append("4");
        }

        System.out.println(sb);
    }

    public static void swap(int i, int j) {
        String tmp = channel[i];
        channel[i] = channel[j];
        channel[j] = tmp;
    }
}

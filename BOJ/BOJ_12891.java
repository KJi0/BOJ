package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891{
    /*
     * BOJ 12891: DNA 비밀번호
     */

    static int idx(char c) {
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        return 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String DNA = br.readLine();

        int[] need = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) need[i] = Integer.parseInt(st.nextToken());

        int[] cnt = new int[4];
        int pass = 0;

        for (int i = 0; i < 4; i++) {
            if (need[i] == 0) pass++;
        }

        for (int i = 0; i < P; i++) {
            int n = idx(DNA.charAt(i));
            cnt[n]++;
            if (cnt[n] == need[n]) pass++;
        }

        int ans = 0;
        if (pass == 4) ans++;

        for (int i = 1; i <= S - P; i++) {
            int out = idx(DNA.charAt(i - 1));
            if (cnt[out] == need[out]) pass--;
            cnt[out]--;

            int in = idx(DNA.charAt(i + P - 1));
            cnt[in]++;

            if (cnt[in] == need[in]) pass++;

            if (pass == 4) ans++;
        }

        System.out.println(ans);
    }
}
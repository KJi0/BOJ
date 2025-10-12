package BOJ;

/*
BOJ 1205: 등수 구하기
단순히 등수만 구할 때는 꼭 수를 배열에 집어넣지 않고
정말 등수만 비교하면 된다는 것을 명심......
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] scores = new int[P];
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(scores);

        if (N == P && scores[0] >= newScore) {
            System.out.println("-1");
            return;
        }

        int cnt = 1;
        for (int i = P - 1; i >= 0; i--) {
            if (scores[i] > newScore) cnt++;
            else break;
        }
        System.out.println(cnt);
    }
}

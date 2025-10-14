package BOJ;

/*
BOJ 9017: 크로스 컨트리
... 음? ;
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] ranks = new int[N];
            int max = 0;
            Map<Integer, Integer> countMap = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                ranks[i] = n;
                countMap.put(n, countMap.getOrDefault(n, 0) + 1);
                max = Math.max(max, n);
            }

            Map<Integer, Integer> tmpMap = new HashMap<>();
            Map<Integer, Integer> scoreMap = new HashMap<>();
            int score = 1;
            int[] fifth = new int[max + 1];

            for (int rank : ranks) {
                if (countMap.get(rank) == 6) {
                    tmpMap.put(rank, tmpMap.getOrDefault(rank, 0) + 1);

                    if (tmpMap.get(rank) <= 4) {
                        scoreMap.put(rank, scoreMap.getOrDefault(rank, 0) + score);
                    }

                    if (tmpMap.get(rank) == 5) {
                        fifth[rank] = score;
                    }
                    score++;
                }
            }
            int fifthScore = Integer.MAX_VALUE;
            int ans = Integer.MAX_VALUE;
            int teamNum = -1;

            for (Integer key : scoreMap.keySet()) {
                int tmp = scoreMap.get(key);
                if (tmp < ans || (tmp == ans && fifthScore > fifth[key])) {
                    ans = tmp;
                    fifthScore = fifth[key];
                    teamNum = key;
                }
            }
            sb.append(teamNum).append("\n");
        }

        System.out.println(sb);
    }
}

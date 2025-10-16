package BOJ;

/*
BOJ 14002: 가장 긴 증가하는 부분 수열 4
last > A[i] 조건을 추가하지 않았을 때도 백준에서는 맞았는데,
저 조건을 추가해야 정확하다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];

        Arrays.fill(dp, 1);

        int len = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    len = Math.max(len, dp[i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(len + "\n");

        int val = len;
        int last = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            if (val == dp[i] && last > A[i]) {
                stack.push(A[i]);
                last = A[i];
                val--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);
    }
}

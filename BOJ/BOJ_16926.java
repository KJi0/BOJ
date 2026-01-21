package BOJ;

/*
BOJ 16926: 배열 돌리기 1
원소 하나를 tmp로 저장해 두고
'비워진' 원소부터 채우며 옮기기! 명심
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotate();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    private static int[][] rotate() {
        for (int r = 0; r < R; r++) {
            for (int i = 0; i < Math.min(N, M) / 2; i++) {
                int top = i; int bottom = N - 1 - i;
                int left = i; int right = M - 1 - i;

                int tmp = arr[i][i];

                for (int j = left; j < right; j++)
                    arr[top][j] = arr[top][j + 1];

                for (int j = top; j < bottom; j++)
                    arr[j][right] = arr[j + 1][right];

                for (int j = right; j > left; j--)
                    arr[bottom][j] = arr[bottom][j - 1];

                for (int j = bottom; j > top + 1; j--)
                    arr[j][left] = arr[j - 1][left];

                arr[top + 1][left] = tmp;
            }
        }
        return arr;
    }
}
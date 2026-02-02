package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1225 {
    /*
     * SWEA 1225: 암호생성기
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            br.readLine();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[8];

            for (int i = 0; i < 8; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            boolean zero = false;

            while (!zero) {
                for (int i = 1; i <= 5; i++) {
                    int tmp = arr[0] - i;

                    for (int j = 0; j < 7; j++) {
                        arr[j] = arr[j + 1];
                    }

                    if (tmp <= 0) {
                        arr[7] = 0;
                        zero = true;
                        break;
                    }

                    arr[7] = tmp;
                }
            }

            System.out.print("#" + t + " ");
            for (int v : arr) System.out.print(v + " ");
            System.out.println();
        }
    }
}

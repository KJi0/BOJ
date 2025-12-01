package BOJ;

/*
BOJ 10798: 세로읽기
toCharArray()는 글자 길이만큼만 배열이 생성되지만,
charAt()으로 하나하나 넣게 되면 지정해 둔 배열 길이만큼 널 문자로 채워진다!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] c = new char[5][15];
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                c[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (c[j][i] != '\0')
                    System.out.print(c[j][i]);
            }
        }
    }
}

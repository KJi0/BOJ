package BOJ;

/*
BOJ 1032: 명령 프롬프트
처음에는 replace()를 썼는데...
이 명령어는 해당 단어의 모든 oldchar를 바꾸는 거라서 실패했당.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String ans = br.readLine();
        while (N-- > 1) {
            String a = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ans.length(); i++) {
                if (ans.charAt(i) == a.charAt(i)) {
                    sb.append(ans.charAt(i));
                } else {
                    sb.append('?');
                }
            }
            ans = sb.toString();
        }
        System.out.println(ans);
    }
}

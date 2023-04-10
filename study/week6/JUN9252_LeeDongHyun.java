package week6;

import java.util.Scanner;
import java.util.Stack;

public class JUN9252_LeeDongHyun {
    static int[][] map; // LCS를 구하는 표
    static Stack<Character> result = new Stack<>(); // 표에서 LCS를 찾기위해 역순으로 출력하기 위한 stack
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = " " + sc.next();
        String s2 = " " + sc.next();
        int l1 = s1.length();
        int l2 = s2.length();
        map = new int[l2][l1];

        for (int i = 1; i < l2; i++) {
            for (int j = 1; j < l1; j++) {
                if (s1.charAt(j) == s2.charAt(i)) { // 문자가 같다면
                    map[i][j] = map[i - 1][j - 1] + 1; // 이전에 중복된 수 +1
                } else {
                    map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
                    // LCS는 문자열이 연속되지 않아도 되기 때문에 현재 까지 중복된 수를
                    // 계속 저장
                }
            }
        }
        int i = l2 - 1;
        int j = l1 - 1;
        int resultSize = map[i][j]; // 표의 마지막 값 == LCS 길이
        while (result.size() != resultSize) { // LCS 완성될 때 까지
            if (j > 0 && map[i][j] == map[i][j - 1]) {
                j--;
            } else if (i > 0 && map[i][j] == map[i - 1][j]) {
                i--;
            } else { // 중복된 문자
                result.push(s1.charAt(j));
                i--;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append(result.pop());
        }
        System.out.println(resultSize);
        System.out.println(sb.toString());
    }
}

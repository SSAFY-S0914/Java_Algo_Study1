import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static int[][] memo;
    static boolean[][] visit;
    static String str1;
    static String str2;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1= br.readLine();
        str2= br.readLine();

        // 공집합 표현
        memo = new int[str2.length()+1][str1.length()+1];
        visit = new boolean[str2.length()+1][str1.length()+1];

        /*
        *   점화 식.. if(x==y) LCS(x-1,y-1)+1
        *             if(x!=y) max(LCS(xi-1,Yj), LCS(i,j-1));
        */

        for (int i = 1; i <= str2.length(); i++){
            for (int j = 1 ; j <= str1.length(); j++){
                if(str2.charAt(i-1) == str1.charAt(j-1)){
                    memo[i][j] = memo[i-1][j-1]+1;
                }else {
                    memo[i][j] = Math.max(memo[i-1][j],memo[i][j-1]);
                }
            }
        }


        System.out.println(memo[str2.length()][str1.length()]);
        printLCS(str1.length(), str2.length());
        System.out.println(sb.reverse().toString());
    }

    private static void printLCS(int x, int y){ // str1 ->x , str2 -> y
        if(x == 0 || y== 0){
            return ;
        }
        if(memo[y][x] > memo[y][x-1] && memo[y][x] > memo[y-1][x] && memo[y][x] > memo[y-1][x-1]){
            // 앞 3개보다 크면
            sb.append(str1.charAt(x-1));
            printLCS(x-1,y-1);
            return;
        }

        if(memo[y][x-1] > memo[y-1][x] ){
            printLCS(x-1, y);
            return;
        }

        if(memo[y-1][x] > memo[y][x-1]){
            printLCS(x,y-1);
            return;
        }
        if(memo[y-1][x] == memo[y][x-1]  && memo[y-1][x]==memo[y][x]){
            printLCS(x-1,y);
        }
    }



}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] sum;
    /*
    *   소형 기관차 3대/ 소형 기관차는 연속적인 객차 손님을 태울 수 있고, 같은 수의 객차만 몰아야 한다.
    *   입력 : 최대로 끌 수 있는 객차의 수를 주어줌.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        sum = new int[N+1];  // 0값을 갖고 있어야 처리 하기 편해서 +1을 해준다.

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i<= N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }
        int MAX = Integer.parseInt(br.readLine());
        /*
        * memo[small][N(객차 index)] 
        * 소형 기관차를 0개 , 1개 2개선택 3개 선택..까지
        */
        int[][] memo = new int[4][N+1];
        for (int small = 1 ; small <= 3; small++){

            for (int i = small * MAX ; i <=N ; i++){
                memo[small][i] = Math.max( memo[small-1][i-MAX] + (sum[i]- sum[i-MAX]), memo[small][i-1]); 
                // memo[small][i-1] <- 이전 값의 저장된 값 vs
                // memo[small-1][i-MAX]  => 현재 소형 기관차 개수 -1+ (sum[i]- sum[i-MAX]),
            }
        }

        System.out.println(memo[3][N]);
    }
}

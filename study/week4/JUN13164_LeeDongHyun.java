import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUN13164_LeeDongHyun {
    /**
     * 1<=N<=300,000 명의 학생을 키순서로 세우고
     * 1<=K<=N개의 조로 나눔 (조 마다 학생 수 다를 수 있음)
     * 각 조에 학생 수 1 이상
     * 같은 조 인원은 인접해야함
     * 티셔츠 비용 tall - small
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] diff = new int[n - 1]; // 키 차이를 담을 배열
        int result = 0;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        diff[0] = a;
        for (int i = 0; i < diff.length; i++) {
            int b = Integer.parseInt(st.nextToken());
            diff[i] = b - a;
            a = b;
        }
        Arrays.sort(diff); // 키 차이를 정렬
        for (int i = 0; i < n - k; i++) { // 키 차이가 큰 k-1명을 1인 조로 편성해서 더해주지 않음
            result += diff[i]; // 남은 키 차이 전부 하나의 조로 편성
        }
        System.out.println(result);
    }
}

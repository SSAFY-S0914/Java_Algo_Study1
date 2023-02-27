package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUN7453_LeeDongHyun {
    static int n;
    static long cnt;
    static int[] ab, cd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        ab = new int[n * n]; //A원소 + B원소의 모든 경우의 수
        cd = new int[n * n]; //C원소 + D원소의 모든 경우의 수

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        } // 입력

        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[k] = A[i] + B[j]; // A원소 + B원소
                cd[k++] = C[i] + D[j]; // C원소 + D원소
            }
        }
        Arrays.sort(ab); //정렬
        Arrays.sort(cd); //정렬
        // primitive(pivot quicksort) > wrapper(merge sort)
//        Arrays.sort(cd, Comparator.reverseOrder()); -> 시간 초과
        /**
         * Arrays.sort -> 통과
         * Collections.sort -> 시간 초과
         *
         * 정렬에서
         * primitive type -> quicksort ( avg = O(nlog(n)) / worst = O(n^2) )
         * wrapper type -> merge sort, tim sort ( avg, worst = O(nlog(n)) )
         *
         * 병합 정렬이 퀵 정렬보다 빠르다고 생각할 수 있지만
         * 최악의 상황에선 퀵 정렬이 느리지만 보통 퀵 정렬이 더 빠르고 메모리도 적게 먹음
         *
         * 그 이유는 참조 지역성의 원리에 있음
         * 정렬의 실제 동작 시간은 C*시간복잡도+a 라고 할 때 a라는 상수 값은 보통 무시할 수 있지만
         * 곱해지는 C에 대해서 생각해야한다 C라는 변수는 참조 지역성의 원리가 영향을 미친다.
         *
         * Array (primitive)는 메모리적으로 각 값들이 연속적인 주소를 가지고 있기 때문에
         * C 값이 낮다 (캐시 히트 높음)
         *
         * 하지만 Collections은 메모리적으로 산발적인 LinkedList 등이 있기 때문에 참조 인접성이 좋지 않고
         * C의 값이 상대적으로 높다. 그렇기 때문에 퀵 정렬이 아니고 최악의 시간이 낮은 Tim정렬이 평균적으로
         * 더 좋은 성능을 기대할 수 있기 때문에 이용한다.
         * https://d2.naver.com/helloworld/0315536 의 글을 읽어보면
         *
         * 정렬 알고리즘 중 C 값이 가장 작다고 알려진 QuickSort의 상수 C를 Cq라고 할 때,
         * 작은 n에 대하여 Ci * n^2 < Cq * nlog(n) 이 성립한다.
         * 즉, 작은 n에 대하여 insertion sort(tim sort 의 기반의 되는 정렬) 가 빠르다.
         *
         * 따라서 내가 공부한 결론은 보통 Collections.sort 즉 wrapper타입의 정렬이 빠르다.
         * 하지만 알고리즘에서 stable할 필요가 없고 N이 크다면 quick sort가 빠르다.
         */

        int p1 = 0; //ab[] 의 포인터 시작
        int p2 = cd.length - 1; //cd[]의 포인터 시작
        int end = n * n; // 0 ~ n*n

        while (p1 < end && 0 <= p2) {
            int sum = ab[p1] + cd[p2];
            long p1Cnt = 1;
            long p2Cnt = 1;

            if (sum == 0) { ////(a, b, c, d) 쌍 완성
                while (p1 <= end - 2 && ab[p1] == ab[p1 + 1]) { // 같은 값으로 더 있는지
                    p1Cnt++;
                    p1++;
                }

                while (0 < p2 && cd[p2] == cd[p2 - 1]) { // // 같은 값으로 더 있는지
                    p2Cnt++;
                    p2--;
                }
                cnt += p1Cnt * p2Cnt; // 경우의 수 더해주기
                // 모든 A[],B[],C[],D[]의 모든 원소가 값이 같을 때 int 값을 넘음 long 타입 필수
                // long 은 경 단위임
            }
            if (sum < 0) {
                p1++;
            } else {
                p2--;
            }
        }
        System.out.println(cnt);
    }
}









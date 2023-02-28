import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JUN2002_YooSeungAh {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<String> in = new LinkedList<>(); // 터널에 들어가는 순서를 담은 큐
		Queue<String> out = new LinkedList<>(); // 터널에서 나가는 순서를 담은 큐
		
		// 차의 대수 N 입력
		int N = Integer.parseInt(br.readLine());
		
		// 들어가는 차 입력
		for (int i = 0; i < N; i++) {
			in.add(br.readLine());
		}
		
		// 나가는 차 입력
		for (int i = 0; i < N; i++) {
			out.add(br.readLine());
		}
		
		int result = 0;
		ArrayList<String> list = new ArrayList<>(); // 추월 차 담아 둘 리스트
		String inCar = in.poll(); // 들어간 차 하나 꺼내기
		String outCar = out.poll(); // 나간 차 하나 꺼내기
		
		while(!in.isEmpty()) { // 들어간 차가 다 나올 때까지
			
			if(inCar.equals(outCar)) { // 순서에 맞게 나왔다면 다음으로
				inCar = in.poll();
				outCar = out.poll();
			}
			else { // 순서에 맞지 않는다면
				if(list.contains(inCar)) { // 이미 추월해서 나간 차라면
					inCar = in.poll(); // 다음 차 검사하러 감
				}
				else { // 추월 차량이라면
					result++; // 하나 카운트 해주고
					list.add(outCar); // 추월 차 리스트에 담아둠
					outCar = out.poll(); // 다음 차 꺼내줌
				}
			}
		}
		
		// 출력
		System.out.println(result);
	}

}

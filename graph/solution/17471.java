import java.util.*;
import java.io.*;

public class Main {
    static int N, sum;
    static int result = Integer.MAX_VALUE;
    static int[] person;
    static List<Integer>[] link;
    static List<List<Integer>> record = new ArrayList<>();
    
    // divide() -> com() -> checkConnect() -> countMinus()

    // 파라미터로 들어온 지역의 총합과 반대섬의 총합 차이를 계산해서 적용하는 함수
    static void countMinus(List<Integer> one) {
        int arrSum = 0;
        for (int i = 0; i < one.size(); i++) {
            arrSum += person[one.get(i)];
        }
        int minus = Math.abs(sum - arrSum * 2);
        if (minus < result) result = minus;
    }

    // two 리스트가 다 연결된 섬인지 확인하는 함수
    static boolean checkConnect(List<Integer> one, List<Integer> two) {
        List<Integer> checkArr = new ArrayList<>(); // 연결된 섬을 넣을 리스트
        Queue<Integer> que = new LinkedList<>(); // 연결 요소 넣기 위한 큐
        que.add(two.get(0));

        while (!que.isEmpty()) { // 큐가 비어있지 않다면
            int node = que.poll(); // 큐에서 꺼내와서
            List<Integer> nodeList = new ArrayList<>(link[node]);
            nodeList.add(node); // 생성한 리스트에 넣기 + 본인까지
            for (int i = 0; i < nodeList.size(); i++) {
                int num = nodeList.get(i); 
                if (one.contains(num)) continue; // 다른쪽 섬에 있으면 패스
                if (!checkArr.contains(num)) {
                    checkArr.add(num);
                    que.add(num); 
                    // 각 리스트의 요소의 연결 요소가 checkArr에 없으면 넣기
                }
            }
        }
        return checkArr.size() == two.size(); // 두 섬의 사이즈 같은지 여부 반환
    }

    // 두 지역을 나눌 때 조합으로 나누기 위한 함수
    static void com(List<Integer> areaA, int[] arr, boolean[] visit, int start, int r) {
        if (r == 0) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (visit[i]) { // r만큼 전부 모아졌을 때 areaA를 변형시키지 않기 위해 
                    temp.add(arr[i]); // temp에 areaA 부분집합 담기
                }
            }
            List<Integer> areaB = new ArrayList<>();
            for (int i = 0; i < N; i++) { // areaA 부분집합 나머지 지역을 areaB에 저장
                if (!temp.contains(i)) areaB.add(i);
            }

            // temp(areaA 부분집합)과 areaB 각각 하나의 연결된 지역인지 확인
            if (checkConnect(areaB, temp) && checkConnect(temp, areaB)) {
                countMinus(temp); // 다 연결된 지역이면 각각 섬의 함 차이 계산
            }
        }
        for (int i = start; i < N; i++) {
            if (areaA.contains(i)) continue;
            visit[i] = true;
            com(areaA, arr, visit, i + 1, r - 1);
            visit[i] = false;
        }
    }

    // 지역을 두 부분으로 나누기 위한 함수
    static void divide() { 
        int[] arr = new int[N]; // 지역 번호를 전부 모아놓은 함수
        for (int i = 0; i < N; i++) arr[i] = i;

        for (int i = 0; i < N; i++) {
            boolean[] visit = new boolean[N];
            List<Integer> areaA = new ArrayList<>();
            visit[i] = true;
            areaA.add(i); 
            for (int j = 0; j < N - 1; j++) { // i만 포함되었을 때 i와 관련된 섬들 조합 생성
                com(areaA, arr, visit, 0, j); // areaA, arr, visit, start, r
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        person = new int[N]; // 각 도시별 인구 수 입력
        sum = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            person[i] = num;
            sum += num;
        }

        link = new ArrayList[N]; // 각 도시별 연결되어 있는 도시 저장 배열
        for (int i = 0; i < N; i++) link[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                link[i].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        divide();
        result = result == Integer.MAX_VALUE ? -1 : result;
        System.out.println(result);

        br.close();
    }
}

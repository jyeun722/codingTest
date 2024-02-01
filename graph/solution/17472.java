import java.io.*;
import java.util.*;

public class Main {
	static final int MIN_LENGTH = 2;
	static int N, M;
	static int landNum = 2;
	static int[][] island;
	// 0: 바다, 1: 땅
	
	static List<int[]> roads;

    // 3. sumRoad(): 적절한 다리를 더하는 코드(안 이어지면 -1 return)
	static int sumRoad() {
		Collections.sort(roads, (i1, i2) -> i1[2] - i2[2]); // 다리 길이를 오름차순으로 정렬
		int sum = 0; // 다리 길이 총 합
		if (roads.size() == 0) return -1; // 다리 없으면 -1 리턴

		List<Integer> visits = new ArrayList<>(); // 방문한 섬을 저장할 리스트
		visits.add(roads.get(0)[0]); // 가장 짦은 길이를 가진 다리의 시작섬, 끝섬 리스트에 채우기
		visits.add(roads.get(0)[1]);
		sum += roads.get(0)[2]; 
		roads.remove(0); // 저장했으니 제거
		
		int len = roads.size();
		for (int i = 0; i < len; i++) { // 언제 무슨 다리가 들어갈지 모르니 원래 다리 갯수만큼 for문 
			for (int j = 0; j < roads.size(); j++) { // 남아있는 다리의 갯수만큼 for문
				int x = roads.get(j)[0];  // 현재 보고있는 다리
				int y = roads.get(j)[1];
				if (!visits.contains(x) && visits.contains(y)) {
					visits.add(x);
					sum += roads.get(j)[2]; // y섬이 있고 x섬이 없는 경우 더해주기
					roads.remove(j);
					break; // 멈추는 이유는 추가한 섬에 대한 연결이 지나간 경우를 다시 보기 위해서
				} else if (visits.contains(x) && !visits.contains(y)) { 
					visits.add(y);
					sum += roads.get(j)[2]; // x섬이 있고 y섬이 없는 경우 더해주기
					roads.remove(j);
					break;
				}
			}
		}
		if (visits.size() != (landNum - 2)) return -1; // 방문 섬 갯수와 총 섬 갯수 비교
		
		return sum; // 모든 섬을 방문한 경우 합을 리턴
	}
	
	// d: 0(아래), 1(오른쪽), 2(왼쪽), 3(위)
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, 1, -1, 0};
	static void generateRoad(int x, int y, int d, int islandStart) {
		int cnt = 0;
		int nextX = x, nextY = y;
		while (nextX < N && nextY < M) {
			if (island[nextX][nextY] == 0) { // 바다이면 cnt 증가하고 계속
				cnt++;
				nextX += dx[d];
				nextY += dy[d];
				continue;
			}
			if (island[nextX][nextY] != 0) { // 섬 찾았을 때
				if (cnt < MIN_LENGTH) { // 필수 길이보다 작은 다리이면 통과
					break;
				}
				else { // 필수 길이보다 컸을 때
					int islandEnd = island[nextX][nextY]; // 도착 섬 구하기
					int[] road = {islandStart, islandEnd, cnt}; // 시작섬, 도착섬, 다리길이 배열
					if (islandStart != islandEnd) roads.add(road); // 다리 목록에 다리 저장
					break;
				}
			}
		}
	}
	
    // 2. findLand() ~ generatedRoad(): 땅일 때 다음 행, 다음 열이 바다일 때 각가 다리 생성하는 코드
	static void findLand() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (island[i][j] != 0) { // 땅일 때
					if (i + 1 < N && island[i + 1][j] == 0) { // 다음 행 바다일 때
						generateRoad(i + 1, j, 0, island[i][j]); // x, y, d, islandStart
					}
					if (j + 1 < M && island[i][j + 1] == 0) { // 다음 열 바다일 때
						generateRoad(i, j + 1, 1, island[i][j]);
					}
				}
			}
		}
	}
	
	static boolean[][] visited;
	static void bfs(int x, int y) {
		if (x >= N || y >= M || x < 0 || y < 0) return; // 범위 체크
		if (visited[x][y]) return; // 이미 방문했으면 return
		if (island[x][y] == 0) return; // 바다면 return
		
		visited[x][y] = true;
		island[x][y] = landNum;
		
		for (int i = 0; i < 4; i++) {
			bfs(x + dx[i], y + dy[i]);
		}
	}
	
    // 1. resetLand() ~ bfs() : 땅에 번호를 부여하는 코드
	static void resetLand() { // 땅을 2부터 부여하기 위한 코드
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (island[i][j] == 1) {
					bfs(i, j); // bfs를 통해 붙어있는 땅을 전부 같은 번호로 리셋
					landNum++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		island = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				island[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		roads = new ArrayList<>();
		resetLand();
		findLand();
		
		int result = sumRoad();
		System.out.println(result);
		br.close();
	}
}

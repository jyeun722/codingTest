import java.io.*;
import java.util.*;

class Shark {
    int r, c, speed, direction, size;

	public Shark(int r, int c, int speed, int direction, int size) {
		super();
		this.r = r;
		this.c = c;
		this.speed = speed;
		this.direction = direction;
		this.size = size;
	}

	public void setR(int r) {
		this.r = r;
	}

	public void setC(int c) {
		this.c = c;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
}

// fishing() -> [ sharFishing() ] -> [sharkMoving() -> changeX() & changeY() -> duplicationShark()]
public class Main {
	static int R, C, M;
	static int result = 0;
	static Shark[] sharks;
	
    // 상어 이동 후 중복 위치의 상어인 경우 잡아먹도록 하는 함수
	static void duplicationShark() {
		int[][] sharkMap = new int[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(sharkMap[i], -1);
		} // 빈 배열 만들어서 전부 -1 로 세팅
		
		for (int i = 0; i < sharks.length; i++) {
			Shark s = sharks[i]; // 상어 순서대로 꺼내서
			if (s == null) continue;
			if (sharkMap[s.r][s.c] == -1) {
                // 이동하는 위치에 상어 없으면 index 넣기
				sharkMap[s.r][s.c] = i;
			} else {
                // 이동하는 위치에 상어 있으면 상어 크기 비교해서 작은거 제거
				int idx = sharkMap[s.r][s.c];
				Shark beforeS = sharks[idx];
				if (s.size > beforeS.size) {
					sharkMap[s.r][s.c] = i;
					sharks[idx] = null;
				} else {
					sharks[i] = null;
				}
			}
		}
	}
	
	// direction: 0(위), 1(아래), 2(오른쪽), 3(왼쪽)
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
    // 행이 변하는 상어 위치 세팅
	static int changeX(Shark s, int nextX) {
		if (nextX >= 0 && nextX < R) {
			s.setR(nextX); // 이동 후 범위 안에 있으면 세팅 끝
		} else { // 범위 넘어가는 경우
			int d = s.direction == 0 ? 1 : 0; // 상어 방향 체인지
			s.setDirection(d);
			if (nextX < 0) { // 음수인 경우 절댓값
				s.setR(Math.abs(nextX));
				return Math.abs(nextX);
			} else if (nextX >= R) { // 양수인 경우 반대로 넘어가게 해주는 코드
				s.setR(2 * R - nextX - 2);
				return 2 * R - nextX - 2;
			}
		}
		return nextX;
	}
	
    // 열이 변하는 상어 위치 세팅 (changeX()와 동일)
	static int changeY(Shark s, int nextY) {
		if (nextY >= 0 && nextY < C) { 
			s.setC(nextY); 
		} else {
			int d = s.direction == 2 ? 3 : 2;
			s.setDirection(d);
			if (nextY < 0) {
				s.setC(Math.abs(nextY));
				return Math.abs(nextY);
			} else if (nextY >= C) {
				s.setC(2 * C - nextY - 2);
				return 2 * C - nextY - 2;
			}
		}
		return nextY;
	}
	
    // 상어가 이동하는 함수
	static void sharkMoving() { 
		for (Shark s : sharks) {
			if (s == null) continue; // 상어 없으면 넘기기
			int nextX = s.r + s.speed * dx[s.direction]; // 총 이동 행 계산
			int nextY = s.c + s.speed * dy[s.direction]; // 총 이동 열 계산
			if (s.direction == 0 || s.direction == 1) { // 위 아래 이동
				int temp = changeX(s, nextX); 
				while (temp < 0 || temp >= R) {
					temp = changeX(s, temp); // 행 세팅하고 범위 안맞으면 재세팅
				}
			} else { // 왼 오른 이동
				int temp = changeY(s, nextY);
				while (temp < 0 || temp >= C) {
					temp = changeY(s, temp); // 열 세팅하고 범위 안맞으면 재세팅
				}
			}
		}
		duplicationShark(); // 상어 이동 후 중복 상어 계산
	}
	
    // 낚시꾼 위치에 따라서 가장 가까운 상어 잡기
	static void sharkFishing(int col) {
		int minRow = R;
		int minSharkIdx = -1;
		for (int i = 0; i < sharks.length; i++) {
			Shark s = sharks[i]; // 상어를 순서대로 꺼내서
			if (s == null) continue;
			if (s.c == col && s.r < minRow) {
				minRow = s.r; // 제일 위에 있는 상어 index 저장
				minSharkIdx = i;
			}
		}
		if (minSharkIdx != -1) { // 가까운 상어 있으면 제거
			result += sharks[minSharkIdx].size;
			sharks[minSharkIdx] = null;
		}
	}
    
    // 낚시꾼이 열마다 이동하도록 하는 함수
	static void fishing() {
		for (int i = 0; i < C; i++) { // 낚시꾼의 열 이동
			sharkFishing(i); // 상어 잡기
			sharkMoving(); //  상어 이동
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if (M == 0) { // 상어 없으면 리턴
			System.out.println(result);
			br.close();
			return;
		}
		
		sharks = new Shark[M]; 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			Shark s = new Shark(
					Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()));
			sharks[i] = s;
		}

		fishing();
		
		System.out.println(result);
		br.close();
	}
}

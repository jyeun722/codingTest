import java.io.*;
import java.util.*;

public class Main {
	static int N, M, D, all, maxResult;
	static int[][] game;
	static int[] attacker;
    
    // combination() -> attack() -> attackOne()
	
	static int[] attackOne(int me, boolean[][] visit, int line) {
		List<Integer>[] enemy = new ArrayList[D + 1]; // 공격자에서 적의 거리에 따라서 저장할 배열
		for (int i = 1; i < D + 1; i++) enemy[i] = new ArrayList<>();
		
		for (int j = 0; j < M; j++) { // 열 순환
			for (int i = line; i > line - D; i--) { // 내 행에서 거리만큼 떨어진 행 모두 탐색
				if (i < 0 || visit[i][j] == false) continue; // 범위 체크
					
				int distance = Math.abs(line + 1 - i) + Math.abs(attacker[me] - j); // 거리 계산
				if (distance <= D && enemy[distance].size() == 0) { // 가까운 것만 먼저 저장
					enemy[distance].add(i);
					enemy[distance].add(j);
				}
			}
		}
		
		for (int i = 1; i < D + 1; i++) { // 제일 가까운 거리에 있는 적을 반환
			if (enemy[i].size() != 0) return new int[] {enemy[i].get(0), enemy[i].get(1)};
		}
		
		return null;
	}
	
	static int attack(int[] three) {
		int sum = 0;
		boolean[][] visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (game[i][j] == 1) visit[i][j] = true;
			} // 공격자 위치마다 계산해야 하므로 boolean 배열 생성
		}
		
		for (int i = N - 1; i >= 0; i--) { // 맨 아래줄부터 맨 위줄까지 
			List<int[]> remove = new ArrayList<>(); // 제거될 적 위치 저장할 리스트
			for (int j = 0; j < 3; j++) {
				int[] result = attackOne(three[j], visit, i); // 한명의 공격자 공격
				if (result != null) { // 각 공자의 적이 null이 아닌 경우 제거
					remove.add(result);
				}
			}
			for (int[] j : remove) { // 중복인 경우 sum이 한번만 되도록 처리
				if (visit[j[0]][j[1]]) {
					visit[j[0]][j[1]] = false;
					sum++;
				}
			}
			if (sum == all) break; // 모든 적이 처치되었을 경우 break
		}
		return sum;
	}
	
	static int[] threeAttacker = new int[3];
	static void combination(int cnt, int start) {
	    if(cnt == 3) { // 궁수가 3명일 때
	    	int result = attack(threeAttacker); // 궁수 조합으로 공격 시도
	    	maxResult = result > maxResult ? result : maxResult;
	        return;
	    } 

	    for(int i = start; i < M; i++) {
            threeAttacker[cnt] = attacker[i];
	        combination(cnt + 1, i + 1);
	    }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		all = 0;
		maxResult = 0;
		game = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				game[i][j] = num;
				all += num; // 전체 적의 수 입력받기
			}
		}
		attacker = new int[M];
		for (int i = 0; i < M; i++) {
			attacker[i] = i; // 조합에서 사용할 궁수를 찾기 위한 배열
		}
		combination(0, 0); 
		
		System.out.println(maxResult);
	}
}

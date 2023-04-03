import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

static int T, N, A, B, C, D, min;
static int[][] map;
//    static boolean[][] visit;
    static Queue<Node> queue = new ArrayDeque<>();

    // delta
    static int[] dy = {-1, 1, 0, 0 };
    static int[] dx = { 0, 0,-1, 1 };

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
//            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            // 풀이
            // 초기화
            min = Integer.MAX_VALUE;
            queue.clear();

            // 최단거리, 최소시간..=> bfs()
            if( bfs() ) System.out.println("#" + t + " " + min);
            else System.out.println("#" + t + " -1");
        }

}

static boolean bfs() {
    // 시작
    // visit 처리, queue 에 담는다.
//        visit[A][B] = true;
        map[A][B] = 1;
        queue.offer(new Node(A, B, 0));

        while( ! queue.isEmpty() ) {

            // queue 에서 한 개를 꺼낸다.
            // 꺼낸 좌표가 도착지점 확인 => yes 이면 종료, no 이면 꺼낸 좌표로부터 더 갈 수 있는 방향으로 계속 bfs 이어간다.
            Node n = queue.poll();

            // 도착지점 확인
            if( n.y == C && n.x == D ) {
                min = n.cnt;
                return true; // 성공!
            }

            // 미도착 => 탐색 계속
            for (int d = 0; d < 4; d++) {
                int ny = n.y + dy[d];
                int nx = n.x + dx[d];

                // range check
                if( ny < 0 || nx < 0 || ny >= N || nx >= N ) continue;

                // 장애물, 완탐 방문여부
//                if( map[ny][nx] == 1 || visit[ny][nx] ) continue;
                if( map[ny][nx] == 1 ) continue;

                // 소용돌이 처리
                // 0-1-2-3-4-5-
                // x x O x x O-
                // 소용돌이를 만나면 소용돌이가 잠잘 때만 갈 수 있다. 그 외 멈춰 있다.
                if( map[ny][nx] == 2 && n.cnt % 3 != 2 ) {
                    queue.offer(new Node(n.y, n.x, n.cnt + 1)); // 좌표는 그대로 시간은 1초 더 추가해서 queue 에 담는다. 
                }else {
                    //visit[ny][nx] = true;
                    map[ny][nx] = 1;
                    queue.offer(new Node(ny, nx, n.cnt + 1));
                }
            }
        }

        return false;
    }

static class Node{
    int y, x, cnt;
    Node(int y, int x, int cnt){
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}
}
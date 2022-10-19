import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MIN_VALUE;
    static final int WIDTH = 4;
    static final int HEIGHT = 8;
    static int[][][] blocks = {
            {
                    {1, 1},
                    {0, 1}
            },
            {
                    {1, 1},
                    {1, 1}
            },
            {
                    {1, 1, 1}
            },
            {
                    {1},
                    {1},
                    {1}
            },
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] mat = new int[HEIGHT][WIDTH];
        for (int i = 0; i < 50; i++) {


            //////////////////////입력////////////////////////////
            // 주어지는 테트리스의 개수
            int N = Integer.parseInt(br.readLine());

            int[] tetrisArr = new int[N];

            st = new StringTokenizer(br.readLine(), " ");

            for (int k = 0; k < N; k++) {
                tetrisArr[k] = Integer.parseInt(st.nextToken()) - 1;
            }
            //////////////////////입력////////////////////////////
            max = Integer.MIN_VALUE;
            dfs(0, 0, mat, tetrisArr, 0);
            System.out.println(max == Integer.MIN_VALUE ? -1 : max);
        }
    }

    private static void dfs(int pos, int start, int[][] mat, int[] tetrisArr, int cnt) {
        // 한번 다 해봄
        if (pos == tetrisArr.length) {
            max = Math.max(cnt, max);

            return;
        }

        for (int i = start; i < tetrisArr.length; i++) {
            int tetrisIdx = tetrisArr[i];
            int[][] tetris = new int[blocks[tetrisIdx].length][blocks[tetrisIdx][0].length];
            System.arraycopy(blocks[tetrisIdx], 0, tetris, 0, blocks[tetrisIdx].length);

            // 해당 회전된 블록 맨 왼쪽부터 넣어보기
            for (int j = 0; j < WIDTH - tetris[0].length + 1; j++) {
                int tempCnt = 0;
                int[][] tempMat = copyMat(mat);
                boolean isPut = false;
                int k = 0;
                // 아래에서 올라오며 넣을 수 있는 공간 확인
                for (k = 0; k < HEIGHT - tetris.length + 1; k++) {
                    // 비어있으면 한번 넣어봄
                    if (isBlank(tempMat, tetris, j, k)) {
                        isPut = true;
                    } else break;
                }

                // HEIGHT을 넘으면 다음 가로칸으로 continue;
                if (k == 0) continue;

                // 넣을 공간 있으면
                if (isPut) putTetris(tempMat, tetris, j, k - 1);


                // 넣었을 때 부서지는지 확인 후 부숨 (HEIGHT -1)인 이유가
                for (int l = HEIGHT - 1; l >= 0; l--) {
                    // 한 줄이 꽉 차 있으면
                    if (isFillLine(tempMat, l)) {
                        // 그 줄 0으로 만듦
                        fillBlank(tempMat[l]);
                        tempCnt++;
                    }
                }

                // 한 줄이 0인 곳 중력
                tempMat = gravity(tempMat);

                // 그다음 다음 블록으로 넘어감
                dfs(pos + 1, i + 1, tempMat, tetrisArr, cnt + tempCnt);
            }

        }

    }

    private static void fillBlank(int[] tempMat) {
        for (int m = 0; m < WIDTH; m++) {
            tempMat[m] = 0;
        }
    }

    private static int[][] copyMat(int[][] mat) {
        int[][] temp = new int[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            System.arraycopy(mat[i], 0, temp[i], 0, WIDTH);
        }

        return temp;
    }

    private static int[][] gravity(int[][] mat) {
//        int[] temp = new int[WIDTH];
        int[][] tempMat = new int[HEIGHT][WIDTH];
        int k = HEIGHT - 1;

        for (int i = HEIGHT - 1; i >= 0; i--) {
            // 한 줄이 안비어 있으면 복사
            if (!traverseLine(mat, i)) {
                for (int j = 0; j < WIDTH; j++) {
                    tempMat[k][j] = mat[i][j];
                }
                k--;
            }
        }

        return copyMat(tempMat);


    }

    private static boolean traverseLine(int[][] mat, int i) {
        for (int j = 0; j < WIDTH; j++) {
            if (mat[i][j] != 0) return false;
        }
        return true;
    }

    private static boolean isFillLine(int[][] mat, int i) {
        for (int j = 0; j < WIDTH; j++) {
            if (mat[i][j] == 0) return false;
        }
        return true;
    }

    private static void putTetris(int[][] mat, int[][] tetris, int j, int k) {
        int q = 0, w = 0;
        // 해당 K에 넣음
        for (int l = k; l < k + tetris.length; l++) {
            for (int m = j; m < j + tetris[0].length; m++) {
                if (tetris[q][w] == 0) {
                    w++;
                    continue;
                }

                mat[l][m] = tetris[q][w++];
            }
            q++;
            w = 0;
        }
    }

    private static boolean isBlank(int[][] mat, int[][] tetris, int j, int k) {
        for (int l = 0; l < tetris.length; l++) {
            for (int m = 0; m < tetris[0].length; m++) {
                // ㄱ 테트리스 검증 위해 tetris[l][m] == 1 확인
                if (mat[k + l][j + m] != 0 && tetris[l][m] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    // 시계방향 회전
    private static int[][] rotate(int y, int x, int[][] tetris) {
        // x,y 값 회전시 바뀜
        int[][] temp = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp[i][j] = tetris[y - 1 - j][i];
            }
        }

        return temp;
    }
}
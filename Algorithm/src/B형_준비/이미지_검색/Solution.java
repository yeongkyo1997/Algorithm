package B형_준비.이미지_검색;


import java.util.Scanner;

class Solution {

    private static final int MAX_N = 10000;
    private static final int MAX_M = 10;
    private static int seed = 5;
    private static Scanner sc;
    private static UserSolution user = new UserSolution();
    private static char ori_image_list[][][] = new char[MAX_N][MAX_M][MAX_M];
    private static char bak_image_list[][][] = new char[MAX_N][MAX_M][MAX_M];
    private static char dummy[] = new char[5005];
    private static char bak_image[][] = new char[MAX_M][MAX_M];

    private static int pseudo_rand() {
        seed = seed * 214013 + 2531011;
        return (seed >> 16) & 0x7fff;
    }

    static int run(int _score) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        seed = sc.nextInt();
        int ratio = sc.nextInt();
        int query_cnt = sc.nextInt();


        for (int i = 0; i < n; i++) {
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < m; x++) {
                    ori_image_list[i][y][x] = 0;
                    int v = pseudo_rand() % 100;
                    if (v >= ratio) ori_image_list[i][y][x] = 1;

                    bak_image_list[i][y][x] = ori_image_list[i][y][x];
                }
            }
        }

        user.init(n, m, bak_image_list);

        int user_ans, correct_ans;

        for (int query = 0; query < query_cnt; query++) {
            int num = pseudo_rand() % n;

            for (int y = 0; y < m; y++) {
                for (int x = 0; x < m; x++) {
                    bak_image[y][x] = ori_image_list[num][y][x];
                }
            }

            int bad_sector_cnt = pseudo_rand() % 2 + 1;

            for (int i = 0; i < bad_sector_cnt; i++) {
                int by = pseudo_rand() % m;
                int bx = pseudo_rand() % m;

                bak_image[by][bx] ^= 1;
            }

            user_ans = user.findImage(bak_image);
            correct_ans = sc.nextInt();

            if (user_ans != correct_ans) _score = 0;
        }

        return _score;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new java.io.FileInputStream("C:\\SSAFY\\Algorithm\\Algorithm\\src\\B형_준비\\이미지_검색\\sample_input.txt"));

        sc = new Scanner(System.in);

        int tc = sc.nextInt();
        int score = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            int tc_score = run(score);
            System.out.println("#" + t + " " + tc_score);
        }

        sc.close();
    }

    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

}


class UserSolution {
    final int MAX_N = 10000;
    final int MAX_M = 10;

    int fN, fM;

    int[][] images = new int[MAX_N][MAX_M];

    int[] oneCnt = new int[1 << MAX_M];

    int startCache = 0;

    int bitCnt(int num) {
        int ret = 0;

        while (num != 0) {
            num &= (num - 1);
            ret++;
        }
        return ret;
    }

    void init(int N, int M, char[][][] mImageList) {
        fN = N;
        fM = M;

        int cache = startCache;
        int len = 1 << fM;

        while (cache < len) {
            oneCnt[cache] = bitCnt(cache);
            cache++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num = 0;
                for (int k = 0; k < M; k++) {
                    if (mImageList[i][j][k] != 0) num |= 1 << k;
                }
                images[i][j] = num;
            }
        }
        startCache = (1 << fM);
    }

    int findImage(char[][] mImage) {
        int[] fImage = new int[MAX_M];

        for (int i = 0; i < fM; i++) {
            int num = 0;
            for (int j = 0; j < fM; j++)
                if (mImage[i][j] != 0) num |= (1 << j);
            fImage[i] = num;
        }

        int maxSame = -1, fId = -1;

        for (int i = 0; i < fN; i++) {
            int fDiff = 0;
            for (int j = 0; j < fM; j++) {
                int fNum = images[i][j] ^ fImage[j];
                fDiff += oneCnt[fNum];
            }

            int fRate = fM * fM - fDiff;
            if (fRate > maxSame) {
                maxSame = fRate;
                fId = i + 1;
            }
        }
        return fId;
    }
}
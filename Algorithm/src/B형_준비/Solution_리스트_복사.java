package B형_준비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_리스트_복사 {
    private final static int CMD_INIT = 100;
    private final static int CMD_MAKE_LIST = 200;
    private final static int CMD_COPY_LIST = 300;
    private final static int CMD_UNDATE_ELEMENT = 400;
    private final static int CMD_ELEMENT = 500;

    private final static UserSolution usersolution = new UserSolution();

    private static int mSeed;
    private static char[] mName = new char[21];
    private static char[] mDest = new char[21];
    private static char[] mSrc = new char[21];
    private static int[] mListValue = new int[200000];

    private static int pseudo_rand() {
        mSeed = mSeed * 214013 + 2531011;
        return (mSeed >> 16) & 0x7FFF;
    }

    private static void generateName(char[] name, int seed) {
        mSeed = seed;
        int name_len = pseudo_rand() % 20 + 1;
        for (int i = 0; i < name_len; ++i) {
            name[i] = (char) (pseudo_rand() % 26 + 'a');
        }
        name[name_len] = '\0';
    }

    private static int generateList(int[] listValue, int seed) {
        mSeed = seed;
        int length = pseudo_rand() << 15;
        length = (length + pseudo_rand()) % 200000 + 1;
        for (int i = 0; i < length; ++i) {
            listValue[i] = pseudo_rand();
        }
        return length;
    }

    private static boolean run(BufferedReader br) throws Exception {
        StringTokenizer st;

        int numQuery;

        int seed;
        int mIndex, mValue, mCopy, mLength;
        int userAns, ans;
        boolean isCorrect = false;

        numQuery = Integer.parseInt(br.readLine());

        for (int q = 0; q < numQuery; ++q) {
            st = new StringTokenizer(br.readLine(), " ");

            int cmd;
            cmd = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case CMD_INIT:
                    usersolution.init();
                    isCorrect = true;
                    break;
                case CMD_MAKE_LIST:
                    seed = Integer.parseInt((st.nextToken()));
                    generateName(mName, seed);
                    seed = Integer.parseInt((st.nextToken()));
                    mLength = generateList(mListValue, seed);
                    usersolution.makeList(mName, mLength, mListValue);
                    break;
                case CMD_COPY_LIST:
                    seed = Integer.parseInt((st.nextToken()));
                    generateName(mDest, seed);
                    seed = Integer.parseInt((st.nextToken()));
                    generateName(mSrc, seed);
                    mCopy = Integer.parseInt((st.nextToken()));
                    usersolution.copyList(mDest, mSrc, (mCopy != 0));
                    break;
                case CMD_UNDATE_ELEMENT:
                    seed = Integer.parseInt((st.nextToken()));
                    generateName(mName, seed);
                    mIndex = Integer.parseInt((st.nextToken()));
                    mValue = Integer.parseInt((st.nextToken()));
                    usersolution.updateElement(mName, mIndex, mValue);
                    break;
                case CMD_ELEMENT:
                    seed = Integer.parseInt((st.nextToken()));
                    generateName(mName, seed);
                    mIndex = Integer.parseInt((st.nextToken()));
                    userAns = usersolution.element(mName, mIndex);
                    ans = Integer.parseInt((st.nextToken()));
                    if (userAns != ans) {
                        isCorrect = false;
                    }
                    break;
                default:
                    isCorrect = false;
                    break;
            }
        }
        return isCorrect;
    }

    public static void main(String[] args) throws Exception {
        int TC, MARK;

        System.setIn(new java.io.FileInputStream("C:\\SSAFY\\Algorithm\\Algorithm\\src\\B형_준비\\sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        TC = Integer.parseInt(st.nextToken());
        MARK = Integer.parseInt(st.nextToken());

        for (int testcase = 1; testcase <= TC; ++testcase) {
            int score = run(br) ? MARK : 0;
            System.out.println("#" + testcase + " " + score);
        }

        br.close();
    }

    public static class UserSolution {
        static Map<String, User> map;

        public void init() {
            map = new HashMap<>();
        }

        public void makeList(char[] mName, int mLength, int[] mListValue) {
            map.put(Arrays.toString(mName), new User(mListValue, new HashMap<>()));
        }

        public void copyList(char[] mDest, char[] mSrc, boolean mCopy) {
            if (mCopy) {
                map.put(Arrays.toString(mDest), map.get(Arrays.toString(mSrc)));
            } else {
                map.put(Arrays.toString(mDest), new User(map.get(Arrays.toString(mSrc)).ref, new HashMap<>()));
            }
        }

        public void updateElement(char[] mName, int mIndex, int mValue) {
            User user = map.get(Arrays.toString(mName));
            user.map.put(mIndex, mValue);
        }

        public int element(char[] mName, int mIndex) {
            User user = map.get(Arrays.toString(mName));

            if (user.map.containsKey(mIndex)) return user.map.get(mIndex);
            else return user.ref[mIndex];
        }

        static class User {
            int[] ref;
            Map<Integer, Integer> map;

            public User(int[] ref, Map<Integer, Integer> map) {
                this.ref = ref;
                this.map = map;
            }
        }
    }
}
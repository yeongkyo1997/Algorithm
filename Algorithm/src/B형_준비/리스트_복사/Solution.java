package B형_준비.리스트_복사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
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

        System.setIn(new java.io.FileInputStream("C:\\SSAFY\\Algorithm\\Algorithm\\src\\B형_준비\\리스트_복사\\sample_input.txt"));

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
}

class UserSolution {
    static int[][] map;
    static HashMap<String, Integer> main;
    static HashMap<String, String> real;
    static HashMap<String, String> fake;
    static HashMap<String, Integer> update;
    static HashMap<String, String> reverse;
    int mainCnt;

    public void init() {
        mainCnt = 0;
        map = new int[11][200001];
        main = new HashMap<>();
        real = new HashMap<>();
        fake = new HashMap<>();
        update = new HashMap<>();
        reverse = new HashMap<>();
    }

    private String getString(char[] name) {
        StringBuilder a = new StringBuilder();
        int cnt = 0;
        int len = name.length;

        while (cnt < len) {
            if (name[cnt] == 0) break;
            a.append(name[cnt++]);
        }
        return a.toString();
    }

    public void makeList(char[] mName, int mLength, int[] mListValue) {
        String name = getString(mName);
        main.put(name, mainCnt);

        if (mLength >= 0) System.arraycopy(mListValue, 0, map[mainCnt], 0, mLength);
        mainCnt++;
    }

    public void copyList(char[] mDest, char[] mSrc, boolean mCopy) {
        String fakename = getString(mDest);
        String realname = getString(mSrc);
        realname = find(realname);

        if (mCopy) {
            real.put(fakename, realname);
            reverse.put(realname, fakename);
        } else {
            fake.put(fakename, realname);
        }
    }

    private String find(String name) {
        while (fake.containsKey(name)) {
            name = fake.get(name);
        }

        return name;
    }

    public void updateElement(char[] mName, int mIndex, int mValue) {
        String name = getString(mName);

        name = find(name);
        String keyname = name + mIndex;

        if (reverse.containsKey(name)) {
            String immname = reverse.get(name) + mIndex;

            if (!update.containsKey(immname)) update.put(immname, element(name, mIndex));
        }
        update.put(keyname, mValue);
    }

    private int element(String name, int mIndex) {
        String keyname;
        int n;

        while (true) {
            name = find(name);
            keyname = name + mIndex;

            if (update.containsKey(keyname)) {
                n = update.get(keyname);
                break;
            }

            if (main.containsKey(name)) {
                n = map[main.get(name)][mIndex];
                break;
            }
            if (real.containsKey(name)) name = real.get(name);
        }
        return n;
    }

    public int element(char[] mName, int mIndex) {
        String name = getString(mName);
        int n;
        while (true) {
            name = find(name);
            String keyname = name + mIndex;
            if (update.containsKey(keyname)) {
                n = update.get(keyname);
                break;
            }

            if (main.containsKey(name)) {
                n = map[main.get(name)][mIndex];
                break;
            }
            if (real.containsKey(name)) name = real.get(name);
        }
        //System.out.println(n);
        return n;
    }
}


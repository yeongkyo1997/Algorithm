package B형_준비.리스트_복사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    private final static int CMD_INIT = 100;
    private final static int CMD_MAKE_LIST = 200;
    private final static int CMD_COPY_LIST = 300;
    private final static int CMD_UNDATE_ELEMENT = 400;
    private final static int CMD_ELEMENT = 500;

    private final static UserSolution usersolution = new UserSolution();

    private static int mSeed;

    private static int pseudo_rand() {
        mSeed = mSeed * 214013 + 2531011;
        return (mSeed >> 16) & 0x7FFF;
    }

    private static final char[] mName = new char[21];
    private static final char[] mDest = new char[21];
    private static final char[] mSrc = new char[21];
    private static final int[] mListValue = new int[200000];

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

        System.setIn(new java.io.FileInputStream("/Users/yeongkyoin/Algorithm/Algorithm/src/B형_준비/sample_input.txt"));

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
    short[][] arr = new short[10][200000];
    Map<String, Integer> srcIdx = new HashMap<>();
    int srcCnt;

    Map<String, Integer> addrIdx = new HashMap<>();
    int addrCnt;

    private String chToStr(char[] mName) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; mName[i] != 0; i++) {
            sb.append(mName[i]);
        }

        return sb.toString();
    }

    class History {
        int idx;
        short value;
    }

    History[] Histories = new History[105500];

    int hisCnt;

    int[] lastHis = new int[6000];
    int[] preHis = new int[105500];

    void init() {
        srcCnt = 0;
        addrCnt = 0;
        hisCnt = 0;
    }

    void makeList(char[] mName, int mLength, int[] mListValue) {
        for (int i = 0; i < mLength; i++) arr[srcCnt][i] = (short) mListValue[i];
        srcIdx.put(chToStr(mName), srcCnt);

        addrIdx.put(chToStr(mName), addrCnt);

        Histories[hisCnt] = new History();
        Histories[hisCnt].idx = -1;
        Histories[hisCnt].value = (short) srcCnt;
        lastHis[addrCnt] = hisCnt;
        preHis[hisCnt] = -1;

        addrCnt++;
        srcCnt++;
        hisCnt++;
    }

    void copyList(char[] mDest, char[] mSrc, boolean mCopy) {
        String dName = chToStr(mDest);

        String sName = chToStr(mSrc);

        if (mCopy) {
            addrIdx.put(dName, addrCnt);

            int sAddr = addrIdx.get(sName);

            Histories[hisCnt] = new History();
            Histories[hisCnt].idx = -1;
            Histories[hisCnt].value = -1;

            int srcLHis = lastHis[sAddr];

            preHis[hisCnt] = srcLHis;

            lastHis[addrCnt] = hisCnt;

            addrCnt++;
            hisCnt++;
        } else addrIdx.put(dName, addrIdx.get(sName));
    }

    void updateElement(char[] mName, int mIndex, int mValue) {
        String name = chToStr(mName);
        int addr = addrIdx.get(name);
        int last_log = lastHis[addr];
        Histories[hisCnt] = new History();
        Histories[hisCnt].idx = mIndex;
        Histories[hisCnt].value = (short) mValue;
        preHis[hisCnt] = last_log;
        lastHis[addr] = hisCnt;
        hisCnt++;
    }

    int element(char[] mName, int mIndex) {
        String name = chToStr(mName);
        int addr = addrIdx.get(name);

        int tHis = lastHis[addr];

        while (preHis[tHis] != -1) {
            if (Histories[tHis].idx == mIndex) return Histories[tHis].value;
            tHis = preHis[tHis];
        }

        int src = Histories[tHis].value;
        return arr[src][mIndex];
    }
}
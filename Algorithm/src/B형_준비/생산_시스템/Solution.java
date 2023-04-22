package B형_준비.생산_시스템;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private final static int CMD_INIT = 1;
    private final static int CMD_REQUEST = 2;
    private final static int CMD_STATUS = 3;

    private final static UserSolution usersolution = new UserSolution();

    private static boolean run(BufferedReader br) throws Exception {
        int q = Integer.parseInt(br.readLine());

        int l, m, timestamp, pid, mline, eid, mtime;
        int cmd, ans, ret = 0;
        boolean okay = false;

        for (int i = 0; i < q; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case CMD_INIT:
                    l = Integer.parseInt(st.nextToken());
                    m = Integer.parseInt(st.nextToken());
                    usersolution.init(l, m);
                    okay = true;
                    break;
                case CMD_REQUEST:
                    timestamp = Integer.parseInt(st.nextToken());
                    pid = Integer.parseInt(st.nextToken());
                    mline = Integer.parseInt(st.nextToken());
                    eid = Integer.parseInt(st.nextToken());
                    mtime = Integer.parseInt(st.nextToken());
                    ans = Integer.parseInt(st.nextToken());
                    ret = usersolution.request(timestamp, pid, mline, eid, mtime);
                    if (ret != ans) okay = false;
                    break;
                case CMD_STATUS:
                    timestamp = Integer.parseInt(st.nextToken());
                    pid = Integer.parseInt(st.nextToken());
                    ans = Integer.parseInt(st.nextToken());
                    ret = usersolution.status(timestamp, pid);
                    if (ret != ans) okay = false;
                    break;
                default:
                    okay = false;
                    break;
            }
        }
        return okay;
    }

    public static void main(String[] args) throws Exception {
        int TC, MARK;

        System.setIn(new java.io.FileInputStream("/Users/yeongkyoin/Algorithm/Algorithm/src/B형_준비/생산_시스템/sample_input.txt"));

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
    class Process {
        int pID, eID, lineID, time;

        Process(int p, int e, int l, int t) {
            pID = p;
            eID = e;
            lineID = l;
            time = t;
        }

    }

    class Request implements Comparable<Request> {
        int eTime;
        Process p;

        Request(int e, Process _p) {
            eTime = e;
            p = _p;
        }

        @Override
        public int compareTo(Request o) {
            return eTime - o.eTime;
        }
    }

    int lineNums, eNums;
    int curTime;
    ArrayDeque<Process>[] lineDeq;
    PriorityQueue<Request> totalPq;
    HashMap<Integer, Integer> pIDStatus;

    boolean[] eUse;
    int[] lineUse;
    final int MAX_LINE = 1000;


    void init(int L, int M) {
        lineNums = L;
        eNums = M;
        lineDeq = new ArrayDeque[L];

        for (int i = 0; i < L; i++)
            lineDeq[i] = new ArrayDeque<>();

        totalPq = new PriorityQueue<>();
        eUse = new boolean[MAX_LINE];
        lineUse = new int[MAX_LINE];
        Arrays.fill(lineUse, -1);
        pIDStatus = new HashMap<>();
    }


    void timeFlow(int tStamp) {
        while (!totalPq.isEmpty() && totalPq.peek().eTime <= tStamp) {
            curTime = totalPq.peek().eTime;

            while (!totalPq.isEmpty() && totalPq.peek().eTime == curTime) {
                Process currP = totalPq.poll().p;

                if (currP.pID < 0) continue;

                pIDStatus.put(currP.pID, 3);
                eUse[currP.eID] = false;
                lineUse[currP.lineID] = -1;
            }

            for (int i = 0; i < lineNums; i++) {
                if (lineUse[i] == -1 && !lineDeq[i].isEmpty()) {
                    Process currP = lineDeq[i].peekFirst();

                    if (eUse[currP.eID]) continue;


                    eUse[currP.eID] = true;
                    pIDStatus.put(currP.pID, 2);
                    lineUse[i] = currP.pID;


                    totalPq.add(new Request(curTime + currP.time, currP));
                    lineDeq[i].poll();
                }
            }
        }
    }

    int request(int tStamp, int pId, int mLine, int eId, int mTime) {

        timeFlow(tStamp - 1);

        lineDeq[mLine].add(new Process(pId, eId, mLine, mTime));
        pIDStatus.put(pId, 1);

        totalPq.add(new Request(tStamp, new Process(-1, 0, 0, 0)));

        curTime = tStamp;
        timeFlow(tStamp);

        return lineUse[mLine];
    }

    int status(int tStamp, int pId) {
        timeFlow(tStamp);
        if (!pIDStatus.containsKey(pId)) return 0;
        return pIDStatus.get(pId);
    }
}
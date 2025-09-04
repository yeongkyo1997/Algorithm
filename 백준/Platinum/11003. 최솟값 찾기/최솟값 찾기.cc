#include <bits/stdc++.h>
using namespace std;

#ifdef _WIN32
  #define GETCHAR getchar
#else
  #define GETCHAR getchar_unlocked
#endif

struct FastScanner {
    inline bool readInt(int &out) {
        int c = GETCHAR();
        while (c <= ' ' && c != EOF) c = GETCHAR();
        if (c == EOF) return false;
        int sign = 1;
        if (c == '-') { sign = -1; c = GETCHAR(); }
        int x = 0;
        while ('0' <= c && c <= '9') {
            x = x * 10 + (c - '0');
            c = GETCHAR();
        }
        out = x * sign;
        return true;
    }
} In;

struct FastOutput {
    static const size_t BUFSIZE = 1 << 20; // 1MB
    char buf[BUFSIZE];
    size_t idx = 0;

    ~FastOutput() { flush(); }

    inline void flush() {
        if (idx) {
            fwrite(buf, 1, idx, stdout);
            idx = 0;
        }
    }
    inline void writeChar(char c) {
        if (idx >= BUFSIZE) flush();
        buf[idx++] = c;
    }
    inline void writeInt(int x) {
        if (idx + 32 >= BUFSIZE) flush();
        if (x == 0) { buf[idx++] = '0'; return; }
        if (x < 0) { buf[idx++] = '-'; x = -x; }
        char s[12];
        int n = 0;
        while (x) { s[n++] = char('0' + (x % 10)); x /= 10; }
        while (n--) buf[idx++] = s[n];
    }
} Out;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, L;
    if (!In.readInt(N)) return 0;
    In.readInt(L);

    // 단조 증가 덱을 배열로 직접 구현 (값, 인덱스)
    vector<int> qVal(N);
    vector<int> qIdx(N);
    int head = 0, tail = 0; // [head, tail)

    for (int i = 0; i < N; ++i) {
        int a; In.readInt(a);

        // 뒤에서부터 현재 값보다 큰 값 제거 (단조 증가 유지)
        while (tail > head && qVal[tail - 1] > a) --tail;

        qVal[tail] = a;
        qIdx[tail] = i;
        ++tail;

        // 윈도우 범위를 벗어난 원소 제거
        while (head < tail && qIdx[head] <= i - L) ++head;

        // 현재 윈도우의 최솟값 출력
        Out.writeInt(qVal[head]);
        if (i + 1 < N) Out.writeChar(' ');
    }
    Out.writeChar('\n');
    Out.flush();
    return 0;
}
//#include <cstdio>
//#include <stack>
//#include <algorithm>
//using namespace std;
//
//        int main(void)
//        {
//        int t;
//        scanf("%d", &t);
//
//        while (t--)
//        {
//        //program data
//        int mem[100000] = { 0 };
//        char code[4096] = { 0 };
//        char inputdata[4096] = { 0 };
//        int cptr = 0, wptr = 0, mptr = 0;
//
//
//        int memsize, codelen, inputlen;
//        scanf("%d %d %d", &memsize, &codelen, &inputlen);
//        scanf("%s", code);
//        scanf("%s", inputdata);
//
//        //짝 맞는 괄호 찾아두기
//        int braket_left[4096], braket_right[4096] = { 0 };
//        //braket_left에는 짝에 맞는 ']'가 있음.
//        stack<int> s;
//        for (int i = 0; i < codelen; ++i) {
//        if (code[i] == '[')
//        s.push(i);
//
//        if (code[i] == ']') {
//        braket_right[i] = s.top();
//        braket_left[s.top()] = i;
//        s.pop();
//        }
//        }
//
//        int runtime = 0;
//        int mincptr, maxcptr;
//
//        while (cptr < codelen)
//        {
//        if (runtime == 50000000) {
//        mincptr = maxcptr = cptr;
//        }
//        if (runtime >= 100000000) {
//        printf("Loops %d %d\n", mincptr - 1, maxcptr);
//        break;
//        }
//        //=================   start  ================
//
//        if (code[cptr] == '-')
//        {
//        mem[mptr]--;
//        if (mem[mptr] < 0)
//        mem[mptr] = 255;
//        cptr++;
//        }
//        else if (code[cptr] == '+')
//        {
//        mem[mptr]++;
//        if (mem[mptr] > 255)
//        mem[mptr] = 0;
//        cptr++;
//        }
//        else if (code[cptr] == '<')
//        {
//        mptr--;
//        if (mptr < 0)
//        mptr = memsize - 1;
//        cptr++;
//        }
//        else if (code[cptr] == '>')
//        {
//        mptr++;
//        if (mptr > memsize - 1)
//        mptr = 0;
//        cptr++;
//        }
//        else if (code[cptr] == '[')
//        {
//        //lets find ']'
//        if (mem[mptr] == 0)
//        cptr = braket_left[cptr];
//
//        cptr++;
//        }
//        else if (code[cptr] == ']')
//        {
//        //lets find '['
//        if (mem[mptr] != 0)
//        cptr = braket_right[cptr];
//
//        cptr++;
//        }
//        else if (code[cptr] == '.')
//        {
//        //ignore output
//        cptr++;
//        }
//        else if (code[cptr] == ',')
//        {
//        if (wptr < inputlen)
//        mem[mptr] = inputdata[wptr++];
//        else if (wptr == inputlen)
//        {
//        mem[mptr] = 255;
//        }
//        cptr++;
//        }
//        ++runtime;
//        if (runtime > 50000000) {
//        mincptr = min(cptr, mincptr);
//        maxcptr = max(cptr, maxcptr);
//        }
//        }
//
//        if (cptr == codelen)
//        printf("Terminates\n");
//
//        }
//        return 0;
//        }
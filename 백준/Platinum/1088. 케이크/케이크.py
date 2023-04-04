import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


class Info:
    def __init__(self, val, idx, cnt):
        self.val = val
        self.idx = idx
        self.cnt = cnt

    def __lt__(self, i):
        return self.val < i.val


def sol(v, m):
    n = len(v)
    PQ = []
    for i in range(n):
        PQ.append(Info(v[i], i, 1))
    PQ.sort(reverse=True)
    mn = min(v)
    ret = PQ[0].val - mn
    for i in range(m):
        val, idx, cnt = PQ[0].val, PQ[0].idx, PQ[0].cnt
        PQ.pop(0)
        val = v[idx] / (cnt + 1)
        PQ.append(Info(val, idx, cnt + 1))
        PQ.sort(reverse=True)
        mn = min(mn, val)
        ret = min(ret, PQ[0].val - mn)
    return ret


n = int(input())
v = list(map(float, input().split()))
m = int(input())
print(f'{sol(v, m):.12f}')
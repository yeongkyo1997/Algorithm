import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, S = map(int, input().split())
A = [*map(int, input().split())]


def rightSeq(mid, sum):
    if mid == N:
        subsum[sum] += 1
        return
    rightSeq(mid + 1, sum + A[mid])
    rightSeq(mid + 1, sum)


def leftSeq(st, sum):
    if st == N // 2:
        cnt[0] += subsum[S - sum]
        return
    leftSeq(st + 1, sum + A[st])
    leftSeq(st + 1, sum)


subsum = collections.defaultdict(int)
cnt = [0]
rightSeq(N // 2, 0)
leftSeq(0, 0)
print(cnt[0] - 1 if S == 0 else cnt[0])

import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

from collections import Counter

n = int(input())
arr = [int(input()) for _ in range(n)]
arr.sort()

print(round(sum(arr) / n))

print(arr[n // 2])

cnt = Counter(arr)
cnt = cnt.most_common()
if len(cnt) > 1 and cnt[0][1] == cnt[1][1]:
    print(cnt[1][0])
else:
    print(cnt[0][0])

print(arr[-1] - arr[0])

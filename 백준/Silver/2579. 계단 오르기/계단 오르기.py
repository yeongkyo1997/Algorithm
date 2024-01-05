from collections import defaultdict
import sys
sys.setrecursionlimit(10 ** 5)
def input(): return sys.stdin.readline().strip()


n = int(input())
arr = [0] + [int(input()) for _ in range(n)]
lib = defaultdict(lambda: -1)


def solve(idx):
    if idx <= 0:
        return 0

    if lib[idx] != -1:
        return lib[idx]

    lib[idx] = max(solve(idx - 2) + arr[idx],
                   solve(idx - 3) + arr[idx - 1] + arr[idx])
    return lib[idx]


print(solve(n))
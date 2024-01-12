import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())
arr = sorted([list(map(int, input().split()))
              for _ in range(N)], key=lambda x: (x[1], x[0]))

for a, b in arr:
    print(a, b)
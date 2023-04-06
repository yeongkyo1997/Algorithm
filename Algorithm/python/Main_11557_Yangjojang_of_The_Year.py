import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

T = int(input())
for _ in range(T):
    N = int(input())
    alchol = []
    for _ in range(N):
        S, L = input().split()
        alchol.append((int(L), S))
    alchol.sort(reverse=True)
    print(alchol[0][1])

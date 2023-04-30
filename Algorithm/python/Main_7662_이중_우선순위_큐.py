import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

T = int(input())
for _ in range(T):
    k = int(input())
    q = []
    for _ in range(k):
        c, n = input().split()
        if c == "I":
            q.append(int(n))
        elif c == "D":
            if len(q) == 0:
                continue
            elif n == "1":
                q.remove(max(q))
            elif n == "-1":
                q.remove(min(q))
    if len(q) == 0:
        print("EMPTY")
    else:
        print(max(q), min(q))

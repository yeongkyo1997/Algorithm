import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())
lib = [0] * 10001

for _ in range(N):
    lib[int(input())] += 1

for i in range(1, 10001):
    for j in range(lib[i]):
        print(i)
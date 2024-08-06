import sys

input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
a = set()
b = set()

for _ in range(N):
    a.add(input())

for _ in range(M):
    b.add(input())

uni = a.intersection(b)
print(len(uni))
print(*sorted(uni), sep='\n')
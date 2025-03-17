import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()

S = list(input())
T = list(input())

while len(S) != len(T):
    alpha = T.pop()
    if alpha == "B":
        T = T[::-1]
print(int(S == T))

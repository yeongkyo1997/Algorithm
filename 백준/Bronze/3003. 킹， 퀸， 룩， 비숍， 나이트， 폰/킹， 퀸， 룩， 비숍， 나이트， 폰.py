import sys

input = sys.stdin.readline

chess = [1, 1, 2, 2, 2, 8]

print(*list(a - b for a, b in zip(chess, map(int, input().split()))))

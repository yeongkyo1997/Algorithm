import sys

input = sys.stdin.readline

chess = [1, 1, 2, 2, 2, 8]

print(*list(arr - b for arr, b in zip(chess, map(int, input().split()))))

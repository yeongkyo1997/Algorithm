import sys

input = sys.stdin.readline

x = int(input())
N = int(input())
arr = [map(int, input().split()) for _ in range(N)]

print("Yes" if sum(i * j for i, j in arr) == x else "No")

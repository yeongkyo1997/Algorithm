import sys

input = sys.stdin.readline

x = int(input())
n = int(input())
arr = [map(int, input().split()) for _ in range(n)]

print("Yes" if sum(i * j for i, j in arr) == x else "No")

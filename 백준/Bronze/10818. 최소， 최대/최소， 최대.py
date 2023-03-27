import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
print(f"{min(arr)} {max(arr)}")

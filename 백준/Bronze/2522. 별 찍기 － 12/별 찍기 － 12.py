import sys

input = sys.stdin.readline

N = int(input())

for i in range(N - 1, -N, -1):
    print(f"{' ' * abs(i)}{'*' * (N - abs(i))}")

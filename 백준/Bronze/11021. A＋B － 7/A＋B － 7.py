import sys


def input(): return sys.stdin.readline().rstrip()


T = int(input())

for i in range(T):
    print(f'Case #{i + 1}: {sum(map(int, input().split()))}')
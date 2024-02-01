import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())
arr = [input().split() for _ in range(N)]

result = sorted(arr, key=lambda x: (-int(x[1]), int(x[2]), -int(x[3]), x[0]))
print(*[i[0] for i in result], sep='\n')
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = set()
for _ in range(n):
    arr.add(input())
arr = list(arr)
arr.sort(key=lambda x: (len(x), x))
print('\n'.join(arr))

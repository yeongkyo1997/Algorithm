import sys


input = lambda: sys.stdin.readline().rstrip()

N = int(input())

arr = set(input() for _ in range(N))

arr = sorted(arr, key=lambda x: (len(x), x))
print("\n".join(arr))

import sys


def input(): return sys.stdin.readline().rstrip()


arr = list(map(lambda x: x if x > 40 else 40,
           [int(input()) for _ in range(5)]))
print(sum(arr) // len(arr))
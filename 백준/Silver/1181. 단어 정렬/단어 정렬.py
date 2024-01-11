import sys


def input(): return sys.stdin.readline().strip()


n = int(input())

print(*sorted(set(input() for _ in range(n)),
      key=lambda x: (len(x), x)), sep='\n')
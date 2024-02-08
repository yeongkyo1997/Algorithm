import sys


def input(): return sys.stdin.readline().rstrip()


s = input()
print(*[s[j:j + 10] for j in range(0, len(s), 10)], sep='\n')
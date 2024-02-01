import sys


def input(): return sys.stdin.readline().rstrip()


S = input()

print(*sorted(S[i:] for i in range(len(S))), sep='\n')
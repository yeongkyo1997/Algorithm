import sys


def input(): return sys.stdin.readline().rstrip()


H, M = map(int, input().split())


M -= 45

if M < 0:
    H -= 1
    M += 60

if H < 0:
    H = 23
print(H, M)
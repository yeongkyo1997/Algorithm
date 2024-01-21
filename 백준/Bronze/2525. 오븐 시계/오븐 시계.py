import sys


def input(): return sys.stdin.readline().rstrip()


A, B = map(int, input().split())
C = int(input())

print((A + (B + C) // 60) % 24, (B + C) % 60)
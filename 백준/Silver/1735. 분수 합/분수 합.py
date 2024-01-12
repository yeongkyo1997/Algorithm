import sys


def input(): return sys.stdin.readline().rstrip()


A1, B1 = map(int, input().split())
A2, B2 = map(int, input().split())

r1 = (A1 * B2) + (A2 * B1)
r2 = (B1 * B2)


def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


g = gcd(r1, r2)

print((r1 // g), (r2//g))
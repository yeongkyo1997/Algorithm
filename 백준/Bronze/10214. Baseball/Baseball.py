import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

T = int(input())
for _ in range(T):
    yonsei = 0
    korea = 0
    for i in range(9):
        y, k = map(int, input().split())
        yonsei += y
        korea += k
    if yonsei > korea:
        print("Yonsei")
    elif yonsei < korea:
        print("Korea")
    else:
        print("Draw")
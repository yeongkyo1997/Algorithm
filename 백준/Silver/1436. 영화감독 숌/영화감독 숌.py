import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
cnt = 0
num = 666
while True:
    if '666' in str(num):
        cnt += 1
    if cnt == n:
        print(num)
        break
    num += 1
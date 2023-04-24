import collections
import sys

input = lambda: sys.stdin.readline().rstrip()

dic = collections.defaultdict(int)

for _ in range(int(input())):
    n = int(input())
    dic[n] += 1

for i in range(10001):
    while dic[i] != 0:
        print(i)
        dic[i] -= 1

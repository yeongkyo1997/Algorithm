import collections
import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

dic = collections.defaultdict(lambda: 0)
for _ in range(int(input())):
    dic[input()] += 1

max_value = max(dic.values())
for i in sorted(dic):
    if dic[i] == max_value:
        print(i)
        break

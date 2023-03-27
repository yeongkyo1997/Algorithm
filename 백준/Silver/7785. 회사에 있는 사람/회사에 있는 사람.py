import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

M = collections.defaultdict(lambda: False)

for _ in range(int(input())):
    name, status = input().split()
    if status == 'enter':
        M[name] = True
    else:
        M[name] = False

arr = []

for key, val in M.items():
    if val:
        arr.append(key)

arr = sorted(arr)[::-1]

for i in arr:
    print(i)

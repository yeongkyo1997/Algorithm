import sys


def input(): return sys.stdin.readline().rstrip()


arr = list(map(int, input().split()))
s = set(arr)

if len(s) == 1:
    print(10000 + arr[0] * 1000)
elif len(s) == 2:
    for i in s:
        if arr.count(i) == 2:
            print(1000 + i * 100)
else:
    print(max(arr) * 100)
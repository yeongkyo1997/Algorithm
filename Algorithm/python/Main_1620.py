import sys

input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
pocketMon = {}
strArr = [''] * (n + 1)

for i in range(1, n + 1):
    name = input()
    pocketMon[name] = i
    strArr[i] = name

for i in range(m):
    string = input()
    if string in pocketMon:
        print(pocketMon[string])
    else:
        print(strArr[int(string)])

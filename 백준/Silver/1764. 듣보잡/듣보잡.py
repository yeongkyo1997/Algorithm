import sys

input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
dic = {}
arr = []

for i in range(n + m):
    string = input()
    if string not in dic:
        dic[string] = 1
    else:
        dic[string] += 1
    if dic[string] > 1:
        arr.append(string)

arr.sort()

print(len(arr))

for o in arr:
    print(o)

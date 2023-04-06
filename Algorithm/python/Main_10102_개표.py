import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

arr = int(input())
string = input()

a = 0
b = 0

for i in range(arr):
    c = string[i]
    if c == 'A':
        a += 1
    elif c == 'B':
        b += 1

if a > b:
    print('A')
elif a < b:
    print('B')

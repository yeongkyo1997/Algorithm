import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

hight = 10
string = input()

for i in range(1, len(string)):
    if string[i - 1] == string[i]:
        hight += 5
    else:
        hight += 10
print(hight)

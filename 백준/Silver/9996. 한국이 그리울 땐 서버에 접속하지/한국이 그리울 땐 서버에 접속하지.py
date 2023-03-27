import re
import sys

input = sys.stdin.readline

N = int(input())
p = re.compile(input().strip().replace('*', '(.+)?'))

for i in range(N):
    string = input().strip()
    if re.fullmatch(p, string):
        print('DA')
    else:
        print('NE')

import sys
import re

input = sys.stdin.readline

n = int(input())
p = re.compile(input().strip().replace('*', '(.+)?'))

for i in range(n):
    string = input().strip()
    if re.fullmatch(p, string):
        print('DA')
    else:
        print('NE')

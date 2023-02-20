import re
import sys

input = sys.stdin.readline

p = re.compile('^[A-F]?A+F+C+[A-F]?$')

for i in range(int(input())):
    if re.fullmatch(p, input().strip()):
        print('Infected!')
    else:
        print('Good')

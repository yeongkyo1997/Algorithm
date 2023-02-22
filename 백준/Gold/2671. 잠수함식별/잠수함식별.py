import re
import sys

input = sys.stdin.readline

p = re.compile('(10(0)+(1)+|01)+')

if re.fullmatch(p, input().strip()):
    print('SUBMARINE')
else:
    print('NOISE')

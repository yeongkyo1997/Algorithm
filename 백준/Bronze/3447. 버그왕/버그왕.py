import re
import sys

input = sys.stdin.read

p = re.compile('(BUG)+')

string = input()

while re.findall(p, string):
    string = re.sub(p, '', string)
print(string)

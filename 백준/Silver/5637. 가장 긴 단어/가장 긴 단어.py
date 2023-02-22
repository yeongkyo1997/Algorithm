import re
import sys
input = sys.stdin.read

p = re.compile('[a-zA-Z-]+')

result = ''
for i in re.findall(p, input()):
    if len(result) < len(i) and i != 'E-N-D':
        result = i
print(result.lower())

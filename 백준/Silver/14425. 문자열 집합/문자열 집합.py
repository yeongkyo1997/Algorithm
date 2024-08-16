import sys

input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
set_strings = [input() for _ in range(n)]
check_strings = [input() for _ in range(m)]

set_s = set(set_strings)

result = 0
for string in check_strings:
    if string in set_s:
        result += 1

print(result)
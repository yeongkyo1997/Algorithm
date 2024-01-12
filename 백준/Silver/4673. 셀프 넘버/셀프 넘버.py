import sys


def d(n):
    return n + sum(map(int, str(n)))


s = set()
for i in range(1, 10001):
    s.add(d(i))

for i in range(1, 10001):
    if not i in s:
        print(i)
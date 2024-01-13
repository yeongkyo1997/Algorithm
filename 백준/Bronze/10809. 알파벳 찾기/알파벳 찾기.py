import sys


def input(): return sys.stdin.readline().rstrip()


s = input()


result = []


for i in range(ord('a'), ord('z') + 1):
    result.append(s.find(chr(i)))

print(*result)
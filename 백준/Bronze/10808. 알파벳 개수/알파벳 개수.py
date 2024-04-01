import sys


def input(): return sys.stdin.readline().strip()


word = input()

result = [0] * 26

for char in word:
    result[ord(char) - ord('a')] += 1

print(*result)
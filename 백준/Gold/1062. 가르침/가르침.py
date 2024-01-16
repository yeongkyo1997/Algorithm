import sys
from itertools import combinations as comb


def input(): return sys.stdin.readline().rstrip()


N, K = map(int, input().split())


words = [0] * N

for i in range(N):
    word = input()
    checked = 0
    for letter in word:
        checked |= 1 << (ord(letter) - ord('a'))

    words[i] = checked


result = float('-inf')

checked = 0
for i in 'acint':
    checked |= 1 << (ord(i) - ord('a'))

if K < 5:
    print(0)
    exit(0)

for c in comb(range(26), K - 5):
    visited = checked
    for v in c:
        visited |= 1 << v

    cnt = 0
    for word in words:
        if visited & word == word:
            cnt += 1
    result = max(result, cnt)

print(result)
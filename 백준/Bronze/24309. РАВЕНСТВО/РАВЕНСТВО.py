import sys

tokens = sys.stdin.read().split()
a = int(tokens[0])
b = int(tokens[1])
c = int(tokens[2])

# 문제에서 x가 정수라고 보장
x = (b - c) // a
print(x)
import sys


def input(): return sys.stdin.readline().rstrip()


a = input()
b = input()

stack = []
for i in range(len(a)):
    stack.append(a[i])
    if ''.join(stack[-len(b):]) == b:
        for _ in range(len(b)):
            stack.pop()

print(''.join(stack) if stack else 'FRULA')
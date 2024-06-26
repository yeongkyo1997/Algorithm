import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())

stack = []
for _ in range(N):
    command = input().split()
    if command[0] == '1':
        stack.append(command[1])
    elif command[0] == '2':
        print(stack.pop() if stack else '-1')
    elif command[0] == '3':
        print(len(stack))
    elif command[0] == '4':
        print(int(not stack))
    elif command[0] == '5':
        print(stack[-1] if stack else -1)
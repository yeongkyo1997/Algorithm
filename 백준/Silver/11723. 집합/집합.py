import sys

input = lambda: sys.stdin.readline().rstrip()

s = set()
M = int(input())

for _ in range(M):
    command = input().split()

    if 'add' == command[0]:
        s.add(int(command[1]))
    elif 'remove' == command[0]:
        s.discard(int(command[1]))
    elif 'check' == command[0]:
        print(1 if int(command[1]) in s else 0)
    elif 'toggle' == command[0]:
        if int(command[1]) in s:
            s.discard(int(command[1]))
        else:
            s.add(int(command[1]))
    elif 'all' == command[0]:
        s = set(range(1, 21))
    else:
        s = set()
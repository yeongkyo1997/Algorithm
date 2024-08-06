import sys

input = lambda: sys.stdin.readline().rstrip()

s = set()
for _ in range(int(input())):
    command = input().rstrip().split()

    if command[0] == 'add':
        s.add(int(command[1]))
    elif command[0] == 'remove':
        s.discard(int(command[1]))
    elif command[0] == 'check':
        print(int(int(command[1]) in s))
    elif command[0] == 'toggle':
        val = int(command[1])
        if val in s:
            s.discard(val)
        else:
            s.add(val)
    elif command[0] == 'all':
        s = set(range(1, 21))
    else:
        s = set()
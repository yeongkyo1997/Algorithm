import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    stack = []
    for _ in range(n):
        cmd = input().split()
        if cmd[0] == 'push':
            stack.append(cmd[1])
        elif cmd[0] == 'pop':
            if stack:
                print(stack.pop())
            else:
                print(-1)
        elif cmd[0] == 'size':
            print(len(stack))
        elif cmd[0] == 'empty':
            if stack:
                print(0)
            else:
                print(1)
        elif cmd[0] == 'top':
            if stack:
                print(stack[-1])
            else:
                print(-1)


if __name__ == '__main__':
    main()
import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    deq = []
    for _ in range(n):
        cmd = input().split()
        if cmd[0] == 'push_front':
            deq.insert(0, cmd[1])
        elif cmd[0] == 'push_back':
            deq.append(cmd[1])
        elif cmd[0] == 'pop_front':
            if len(deq) == 0:
                print(-1)
            else:
                print(deq.pop(0))
        elif cmd[0] == 'pop_back':
            if len(deq) == 0:
                print(-1)
            else:
                print(deq.pop())
        elif cmd[0] == 'size':
            print(len(deq))
        elif cmd[0] == 'empty':
            if len(deq) == 0:
                print(1)
            else:
                print(0)
        elif cmd[0] == 'front':
            if len(deq) == 0:
                print(-1)
            else:
                print(deq[0])
        elif cmd[0] == 'back':
            if len(deq) == 0:
                print(-1)
            else:
                print(deq[-1])


if __name__ == '__main__':
    main()
import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N = int(input())
    s = set()
    for _ in range(N):
        cmd = input().split()
        if len(cmd) == 1:
            if cmd[0] == 'all':
                s = set([i for i in range(1, 21)])
            else:
                s = set()
        else:
            cmd, x = cmd
            x = int(x)
            if cmd == 'add':
                s.add(x)
            elif cmd == 'remove':
                s.discard(x)
            elif cmd == 'check':
                print(1 if x in s else 0)
            elif cmd == 'toggle':
                if x in s:
                    s.discard(x)
                else:
                    s.add(x)

if __name__ == '__main__':
    main()
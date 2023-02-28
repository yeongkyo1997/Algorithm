import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 9019 DSLR
def main():
    t = int(input())
    for _ in range(t):
        a, b = map(int, input().split())
        print(bfs(a, b))


def bfs(a, b):
    q = [(a, '')]
    visited = [0] * 10000

    while q:
        x, cmd = q.pop(0)
        if x == b:
            return cmd
        if visited[x] == 0:
            visited[x] = 1
            q.append((D(x), cmd + 'D'))
            q.append((S(x), cmd + 'S'))
            q.append((L(x), cmd + 'L'))
            q.append((R(x), cmd + 'R'))


def D(x):
    return (2 * x) % 10000


def S(x):
    return 9999 if x == 0 else x - 1


def L(x):
    return (x % 1000) * 10 + x // 1000


def R(x):
    return (x % 10) * 1000 + x // 10


if __name__ == '__main__':
    main()

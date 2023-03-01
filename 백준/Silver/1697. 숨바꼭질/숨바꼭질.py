import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    N, K = map(int, input().split())

    visited = [False] * 100001

    queue = collections.deque()
    queue.append((N, 0))

    while queue:
        cur, depth = queue.popleft()
        if cur == K:
            print(depth)
            break

        if cur + 1 <= 100000 and not visited[cur + 1]:
            visited[cur + 1] = True
            queue.append((cur + 1, depth + 1))
        if 0 <= cur - 1 and not visited[cur - 1]:
            visited[cur - 1] = True
            queue.append((cur - 1, depth + 1))
        if 0 <= cur * 2 <= 100000 and not visited[cur * 2]:
            visited[cur * 2] = True
            queue.append((cur * 2, depth + 1))


if __name__ == '__main__':
    main()
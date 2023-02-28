import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    tree = [[] for _ in range(N + 1)]
    for _ in range(N - 1):
        a, b = map(int, input().split())
        tree[a].append(b)
        tree[b].append(a)

    depth = [0] * (N + 1)
    parent = [[0] * 21 for _ in range(N + 1)]
    stack = [1]
    while stack:
        node = stack.pop()
        for next_node in tree[node]:
            if depth[next_node] == 0:
                depth[next_node] = depth[node] + 1
                parent[next_node][0] = node
                stack.append(next_node)

    for i in range(1, 21):
        for j in range(1, N + 1):
            parent[j][i] = parent[parent[j][i - 1]][i - 1]

    M = int(input())
    for _ in range(M):
        a, b = map(int, input().split())
        if depth[a] < depth[b]:
            a, b = b, a

        for i in range(20, -1, -1):
            if depth[a] - depth[b] >= (1 << i):
                a = parent[a][i]

        if a != b:
            for i in range(20, -1, -1):
                if parent[a][i] != parent[b][i]:
                    a = parent[a][i]
                    b = parent[b][i]
            a = parent[a][0]

        print(a)


if __name__ == '__main__':
    main()

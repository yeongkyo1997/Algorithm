import sys

sys.setrecursionlimit(10 ** 6)

input = lambda: sys.stdin.readline().rstrip()


def dfs(n, v, visited, num):
    if num[n] != 0:
        return num[n]
    visited[n] = True
    ret = 1
    for next_node in v[n]:
        if visited[next_node]:
            continue
        ret += dfs(next_node, v, visited, num)
    num[n] = ret
    return ret


def main():
    node, root, query = map(int, input().split())

    v = [[] for _ in range(node + 1)]
    visited = [False] * (node + 1)
    num = [0] * (node + 1)

    for _ in range(node - 1):
        s, e = map(int, input().split())
        v[s].append(e)
        v[e].append(s)

    num[root] = dfs(root, v, visited, num)

    for _ in range(query):
        s = int(input().strip())
        print(num[s])


if __name__ == "__main__":
    main()
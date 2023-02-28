import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    n = int(input())
    tree = [[] for _ in range(n + 1)]
    for _ in range(n - 1):
        a, b = map(int, input().split())
        tree[a].append(b)
        tree[b].append(a)
    depth = [0] * (n + 1)
    parent = [[0] * 20 for _ in range(n + 1)]
    
    def dfs(x, d):
        depth[x] = d
        for y in tree[x]:
            if not depth[y]:
                parent[y][0] = x
                dfs(y, d + 1)
    
    dfs(1, 1)
    
    for j in range(1, 20):
        for i in range(1, n + 1):
            parent[i][j] = parent[parent[i][j - 1]][j - 1]
    m = int(input())
    
    for _ in range(m):
        a, b = map(int, input().split())
        if depth[a] < depth[b]:
            a, b = b, a
        for i in range(19, -1, -1):
            if depth[a] - depth[b] >= 2 ** i:
                a = parent[a][i]
        if a != b:
            for i in range(19, -1, -1):
                if parent[a][i] != parent[b][i]:
                    a = parent[a][i]
                    b = parent[b][i]
            a = parent[a][0]
        print(a)

if __name__ == '__main__':
    main()
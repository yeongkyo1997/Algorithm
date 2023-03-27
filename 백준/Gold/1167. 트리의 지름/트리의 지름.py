import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N = int(input())
    tree = [[] for _ in range(N + 1)]
    for i in range(N):
        line = list(map(int, input().split()))
        for j in range(1, len(line) - 1, 2):
            tree[line[0]].append((line[j], line[j + 1]))
    print(dfs(dfs(1, tree)[0], tree)[1])

def dfs(start, tree):
    visited = [False] * (len(tree) + 1)
    stack = [(start, 0)]
    visited[start] = True
    result = (start, 0)
    while stack:
        node, dist = stack.pop()
        if dist > result[1]:
            result = (node, dist)
        for i in range(len(tree[node])):
            if not visited[tree[node][i][0]]:
                stack.append((tree[node][i][0], dist + tree[node][i][1]))
                visited[tree[node][i][0]] = True
    return result

if __name__ == '__main__':
    main()
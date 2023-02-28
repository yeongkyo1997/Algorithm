import collections
import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

visited = []
computer = collections.defaultdict(list)

def main():
    global visited
    N = int(input())
    M = int(input())
    visited = [False] * (N + 1)
    
    for _ in range(M):
        a, b = map(int, input().split())
        computer[a].append(b)
        computer[b].append(a)
    
    print(dfs(1) - 1)

def dfs(start):
    global visited
    if visited[start]:
        return 0
    visited[start] = True
    ret = 1
    for i in computer[start]:
        ret += dfs(i)
    return ret

if __name__ == '__main__':
    main()
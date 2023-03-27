import sys

input = sys.stdin.readline
INF = int(1e9)

def solve(start):
    dist = [INF] * (N + 1)
    dist[start] = 0
    
    for i in range(N):
        for edge in graph:
            cur = edge[0]
            nxt = edge[1]
            cost = edge[2]
            
            if dist[nxt] > cost + dist[cur]:
                dist[nxt] = cost + dist[cur]
                if i == N - 1:
                    return True
    
    return False

for _ in range(int(input())):
    N, M, W = map(int, input().split())
    graph = []
    
    for _ in range(M):
        S, E, T = map(int, input().split())
        graph.append((S, E, T))
        graph.append((E, S, T))
    
    for _ in range(W):
        S, E, T = map(int, input().split())
        graph.append((S, E, -T))
    
    if solve(1):
        print("YES")
    else:
        print("NO")
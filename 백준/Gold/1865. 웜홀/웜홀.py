import sys

INF = 987654321

class Edge:
    def __init__(self, node, time):
        self.node = node
        self.time = time

def bellman_ford(N, dis, road):
    dis[1] = 0

    for i in range(1, N):
        for j in range(1, len(road)):
            for next in road[j]:
                if dis[j] + next.time < dis[next.node]:
                    dis[next.node] = dis[j] + next.time

    for j in range(1, len(road)):
        for next in road[j]:
            if dis[j] + next.time < dis[next.node]:
                return True

    return False

def main():
    tc = int(sys.stdin.readline())
    for i in range(tc):
        n, m, w = map(int, sys.stdin.readline().split())
        dis = [INF] * (n + 1)
        road = [ [] for _ in range(n + 1)]

        for j in range(m):
            a, b, c = map(int, sys.stdin.readline().split())
            road[a].append(Edge(b, c))
            road[b].append(Edge(a, c))

        for j in range(w):
            a, b, c = map(int, sys.stdin.readline().split())
            road[a].append(Edge(b, -c))

        if bellman_ford(n, dis, road):
            print("YES")
        else:
            print("NO")

if __name__ == "__main__":
    main()
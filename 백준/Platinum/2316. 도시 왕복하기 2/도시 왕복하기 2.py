import sys
from collections import deque

INF = 987654321
MAXN = 803

def minimum_cut(source, sink, vertex_num, capacity, flow):
    total_flow = 0

    while True:
        parent = [-1] * vertex_num
        q = deque()
        parent[source] = source
        q.append(source)

        while q and parent[sink] == -1:
            u = q.popleft()

            for v in range(2, vertex_num):
                if capacity[u][v] - flow[u][v] > 0 and parent[v] == -1:
                    q.append(v)
                    parent[v] = u

        if parent[sink] == -1:
            break

        amount = INF
        p = sink
        while p != source:
            amount = min(capacity[parent[p]][p] - flow[parent[p]][p], amount)
            p = parent[p]

        p = sink
        while p != source:
            flow[parent[p]][p] += amount
            flow[p][parent[p]] -= amount
            p = parent[p]

        total_flow += amount

    return total_flow

def main():
    city_num, path_num = map(int, input().split())

    capacity = [[0] * MAXN for _ in range(MAXN)]
    flow = [[0] * MAXN for _ in range(MAXN)]
    vertex_num = (city_num + 1) * 2

    for i in range(2, vertex_num, 2):
        capacity[i][i + 1] = 1

    for i in range(path_num):
        u, v = map(int, input().split())
        u_in, u_out = u * 2, u * 2 + 1
        v_in, v_out = v * 2, v * 2 + 1

        capacity[u_out][v_in] = INF
        capacity[v_out][u_in] = INF

    source_out, sink_in = 3, 4
    print(minimum_cut(source_out, sink_in, vertex_num, capacity, flow))

if __name__ == "__main__":
    main()
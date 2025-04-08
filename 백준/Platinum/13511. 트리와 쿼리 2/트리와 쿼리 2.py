import sys
import math


sys.setrecursionlimit(100000 + 5)

input = sys.stdin.readline


N = int(input())

MAX_LOG = math.ceil(math.log2(N)) + 1


adj = [[] for _ in range(N + 1)]
for _ in range(N - 1):
    u, v, w = map(int, input().split())
    adj[u].append((v, w))
    adj[v].append((u, w))


depth = [-1] * (N + 1)
dist = [-1] * (N + 1)

parent = [[0] * MAX_LOG for _ in range(N + 1)]


def dfs(curr, par, d, current_dist):
    depth[curr] = d
    dist[curr] = current_dist
    parent[curr][0] = par

    for neighbor, weight in adj[curr]:

        if neighbor != par:
            dfs(neighbor, curr, d + 1, current_dist + weight)


def build_tables():

    for i in range(1, MAX_LOG):

        for node in range(1, N + 1):

            p_prev = parent[node][i - 1]

            if p_prev != 0:

                parent[node][i] = parent[p_prev][i - 1]


def lca(u, v):

    if depth[u] < depth[v]:
        u, v = v, u

    diff = depth[u] - depth[v]

    for i in range(MAX_LOG - 1, -1, -1):
        if (diff >> i) & 1:
            u = parent[u][i]

    if u == v:
        return u

    for i in range(MAX_LOG - 1, -1, -1):

        if parent[u][i] != parent[v][i]:
            u = parent[u][i]
            v = parent[v][i]

    return parent[u][0]


def get_kth_ancestor(node, k):
    """Finds the k-th ancestor of 'node' (0-th ancestor is node itself)."""

    if k < 0:
        return -1

    if k == 0:
        return node

    for i in range(MAX_LOG - 1, -1, -1):

        if (k >> i) & 1:

            node = parent[node][i]

            if node == 0:
                return -1

    return node


dfs(1, 0, 0, 0)


build_tables()


M = int(input())
results = []
for _ in range(M):
    query = list(map(int, input().split()))
    q_type = query[0]
    u, v = query[1], query[2]

    common_ancestor = lca(u, v)

    if q_type == 1:

        path_cost = dist[u] + dist[v] - 2 * dist[common_ancestor]
        results.append(str(path_cost))
    else:

        k = query[3]

        nodes_on_u_to_lca = depth[u] - depth[common_ancestor] + 1

        if k <= nodes_on_u_to_lca:

            target_node = get_kth_ancestor(u, k - 1)
        else:

            total_nodes_on_path = depth[u] + depth[v] - 2 * depth[common_ancestor] + 1

            steps_up_from_v = total_nodes_on_path - k

            target_node = get_kth_ancestor(v, steps_up_from_v)

        results.append(str(target_node))


print("\n".join(results))

import collections
import sys

input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
    n, m = map(int, input().split())
    parent = list(range(2 * n))
    rank = [0] * (2 * n)  # 각 노드의 rank를 저장


    def find(u):
        if parent[u] != u:
            parent[u] = find(parent[u])  # 경로 압축
        return parent[u]


    def union(a, b):
        a = find(a)
        b = find(b)
        if a == b:
            return
        # rank를 비교하여 더 작은 쪽을 더 큰 쪽에 합침
        if rank[a] > rank[b]:
            parent[b] = a
        elif rank[a] < rank[b]:
            parent[a] = b
        else:
            parent[b] = a
            rank[a] += 1  # 같은 높이라면 한쪽의 rank를 증가


    for _ in range(m):
        a, b = map(int, input().split())
        a -= 1
        b -= 1
        x = a
        y = n + b
        union(x, y)

    comps = collections.defaultdict(lambda: {'x': 0, 'y': 0})
    for i in range(2 * n):
        root = find(i)
        if i < n:
            comps[root]['x'] += 1
        else:
            comps[root]['y'] += 1

    comp_list = []
    for comp in comps.values():
        comp_list.append((comp['x'], comp['y']))

    max_k = n // 2
    dp = set()
    dp.add((0, 0))
    for cnt_x, cnt_y in comp_list:
        new_dp = set()
        for (sx, sy) in dp:
            new_sx = sx + cnt_x
            new_sy = sy + cnt_y
            if new_sx <= max_k and new_sy <= max_k:
                new_dp.add((new_sx, new_sy))
        dp.update(new_dp)

    for k in range(max_k, -1, -1):
        if (k, k) in dp:
            print(k)
            exit(0)

    print(0)
import math
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def dijk(start):
    dist = [INF] * (N + 1)
    dist[start] = 0
    q = [(0, start)]
    while q:
        curDist, cur = q.pop()
        if dist[cur] < curDist:
            continue
        for next, nextDist in v[cur]:
            if dist[next] > curDist + nextDist:
                dist[next] = curDist + nextDist
                q.append((dist[next], next))
    return dist


INF = math.inf
N, E = map(int, input().split())
v = [[] for _ in range(N + 1)]
for _ in range(E):
    a, b, c = map(int, input().split())
    v[a].append((b, c))
    v[b].append((a, c))

v1, v2 = map(int, input().split())

sToV1, sToV2 = dijk(1)[v1], dijk(1)[v2]
V1ToV2, V1ToN = dijk(v1)[v2], dijk(v1)[N]
V2ToN = dijk(v2)[N]

res = min(sToV1 + V1ToV2 + V2ToN, sToV2 + V1ToV2 + V1ToN)
print(res if res != INF else -1)

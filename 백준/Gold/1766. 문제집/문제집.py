import heapq
import sys

input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
    N, M = map(int, input().split())
    graph = [[] for _ in range(N + 1)]
    in_degree = [0] * (N + 1)

    # 그래프와 진입 차수 초기화
    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        in_degree[b] += 1

    heap = []
    # 진입 차수가 0인 노드를 큐에 추가
    for i in range(1, N + 1):
        if in_degree[i] == 0:
            heap.append(i)

    heapq.heapify(heap)

    result = []
    # 위상 정렬 수행
    while heap:
        node = heapq.heappop(heap)
        result.append(node)

        # 현재 노드와 연결된 노드들의 진입 차수를 감소시키고, 0이 되면 큐에 추가
        for g in graph[node]:
            in_degree[g] -= 1
            if in_degree[g] == 0:
                heapq.heappush(heap, g)

    # 결과 출력
    print(*result)
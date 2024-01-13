from collections import defaultdict, deque


def solution(n, edges, start, end):
    graph = defaultdict(list)
    reverse_graph = defaultdict(list)
    in_degree = [0] * (n + 1)
    time_to_reach = [0] * (n + 1)
    for u, v, t in edges:
        graph[u].append((v, t))
        reverse_graph[v].append((u, t))
        in_degree[v] += 1

    queue = deque()
    queue.append(start)

    while queue:
        node = queue.popleft()
        for neighbor, time in graph[node]:
            in_degree[neighbor] -= 1
            if in_degree[neighbor] == 0:
                queue.append(neighbor)
            time_to_reach[neighbor] = max(
                time_to_reach[neighbor], time_to_reach[node] + time)

    longest_time = time_to_reach[end]

    critical_path_count = 0
    queue = deque()
    queue.append(end)
    visited = set()
    while queue:
        node = queue.popleft()
        for neighbor, time in reverse_graph[node]:
            if time_to_reach[node] - time_to_reach[neighbor] == time:
                critical_path_count += 1
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append(neighbor)

    return longest_time, critical_path_count


N = int(input())
M = int(input())
edges = [list(map(int, input().split())) for _ in range(M)]

start, end = map(int, input().split())


print(*solution(N, edges, start, end), sep='\n')
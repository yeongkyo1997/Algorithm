import heapq
import sys
from collections import defaultdict, deque

input = sys.stdin.read
data = input().split()

index = 0
N = int(data[index])
index += 1
M = int(data[index])
index += 1
K = int(data[index])
index += 1

graph = defaultdict(list)
for _ in range(M):
    s = int(data[index])
    index += 1
    e = int(data[index])
    index += 1
    d = int(data[index])
    index += 1
    graph[s].append((e, d))
    graph[e].append((s, d))

def dijkstra(start, n):
    distances = [float('inf')] * (n + 1)
    distances[start] = 0
    priority_queue = [(0, start)]
    
    while priority_queue:
        current_distance, current_node = heapq.heappop(priority_queue)
        
        if current_distance > distances[current_node]:
            continue
        
        for neighbor, weight in graph[current_node]:
            distance = current_distance + weight
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(priority_queue, (distance, neighbor))
    
    return distances

distances_from_communication_rooms = []
for i in range(1, K + 1):
    distances_from_communication_rooms.append(dijkstra(i, N))

result = []
for room in range(K + 1, N + 1):
    distances = [distances_from_communication_rooms[i][room] for i in range(K)]
    distances.sort()
    result.append(distances[1])  

print(" ".join(map(str, result)))
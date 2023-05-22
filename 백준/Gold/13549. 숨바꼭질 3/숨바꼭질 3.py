from collections import deque

class Node:
    def __init__(self, x, time):
        self.x = x
        self.time = time

n, k = map(int, input().split())

visited = [False] * (100000 + 1)
min_time = float('inf')

def bfs():
    global min_time
    q = deque()
    q.append(Node(n, 0))

    while q:
        node = q.popleft()
        visited[node.x] = True
        if node.x == k:
            min_time = min(min_time, node.time)

        if node.x * 2 <= 100000 and not visited[node.x * 2]:
            q.append(Node(node.x * 2, node.time))
        if node.x + 1 <= 100000 and not visited[node.x + 1]:
            q.append(Node(node.x + 1, node.time + 1))
        if node.x - 1 >= 0 and not visited[node.x - 1]:
            q.append(Node(node.x - 1, node.time + 1))

bfs()
print(min_time)
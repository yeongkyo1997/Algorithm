import sys

input = lambda: sys.stdin.readline().rstrip()
print = lambda x: sys.stdout.write(str(x) + '\n')

V, E = map(int, input().split())
parent = [i for i in range(V + 1)]
Edges = []
for _ in range(E):
    a, b, c = map(int, input().split())
    Edges.append((a, b, c))

Edges.sort(key=lambda x: x[2])

def find(a):
    if parent[a] == a:
        return a
    
    parent[a] = find(parent[a])
    return parent[a]

def union(a, b):
    a, b = find(a), find(b)
    
    if a == b:
        return False
    
    parent[max(a, b)] = min(a, b)
    
    return True

result = 0

for a, b, cost in Edges:
    if union(a, b):
        result += cost

print(result)
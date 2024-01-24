n = int(input())

max_w, max_h = float('-inf'), float('-inf')
min_w, min_h = float('inf'), float('inf')
for _ in range(n):
    a, b = map(int, input().split())
    max_w = max(max_w, a)
    min_w = min(min_w, a)
    max_h = max(max_h, b)
    min_h = min(min_h, b)

print((max_w - min_w) * (max_h - min_h))
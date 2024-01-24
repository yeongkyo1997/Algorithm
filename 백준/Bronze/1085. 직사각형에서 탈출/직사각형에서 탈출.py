x, y, w, h = map(int, input().split())
print(min(abs(x - w), abs(y - h), abs(x - 0), abs(y - 0)))
N, X = map(int, input().split())
arr = list(filter(lambda a: a < X, map(int, input().split())))
print(*arr)
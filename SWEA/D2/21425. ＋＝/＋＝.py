def dfs(a, b, c, depth):
    if depth >= 1:
        if a > c or b > c:
            print(depth)
            return

    dfs(a + b, max(a, b), c, depth + 1)


for _ in range(int(input())):
    a, b, c = map(int, input().split())
    dfs(max(a, b), min(a, b), c, 0)

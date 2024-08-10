T = int(input())


def dfs(total, depth):
    global result
    if depth == 13:
        result = min(total, result)
        return

    if depth + 1 <= 13:
        dfs(total + day * arr[depth], depth + 1)
        dfs(total + month, depth + 1)
    if depth + 3 <= 13:
        dfs(total + three_month, depth + 3)


for t in range(1, T + 1):
    day, month, three_month, year = map(int, input().split())
    result = year
    arr = [0] + list(map(int, input().split()))
    dfs(0, 1)
    print(f'#{t} {result}')

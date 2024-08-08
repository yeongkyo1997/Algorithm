T = int(input())


def dfs(total, n):
    if total >= n:
        if total == n:
            return 1
        else:
            return 0

    result = 0

    for i in range(1, 4):
        result += dfs(total + i, n)

    return result


for _ in range(T):
    print(dfs(0, int(input())))
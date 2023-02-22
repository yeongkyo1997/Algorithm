MARK = 1 << 29


def dist():
    arr = [[MARK] * 12 for _ in range(12)]

    for i in range(12):
        x = i % 3
        y = i // 3
        for j in range(12):
            nx = j % 3
            ny = j // 3

            dx = abs(nx - x)
            dy = abs(ny - y)

            arr[i][j] = min(dx, dy) * 3 + abs(dx - dy) * 2
            if dx == 0 and dy == 0:
                arr[i][j] = 1

    return arr


def solution(numbers):
    arr = dist()

    n = len(numbers)
    n_case = 12 ** 2

    DP = [[MARK] * (n_case + 1) for _ in range(n + 1)]

    DP[0][(4 - 1) * 12 + (6 - 1)] = 0

    for i in range(1, n + 1):
        cur = ord(numbers[i - 1]) - ord('0') - 1
        if numbers[i - 1] == '*':
            cur = 9

        if numbers[i - 1] == '0':
            cur = 10

        if numbers[i - 1] == '#':
            cur = 11

        for t in range(n_case):
            if DP[i - 1][t] != MARK:
                x = t // 12
                y = t % 12

                dx = arr[x][cur]
                dy = arr[y][cur]

                if cur != y:
                    DP[i][min(cur, y) * 12 + max(cur, y)] = min(DP[i][min(cur, y) * 12 + max(cur, y)],
                                                                DP[i - 1][t] + dx)
                if cur != x:
                    DP[i][min(cur, x) * 12 + max(cur, x)] = min(DP[i][min(cur, x) * 12 + max(cur, x)],
                                                                DP[i - 1][t] + dy)

    result = MARK

    for v in DP[n]:
        result = min(v, result)

    return result
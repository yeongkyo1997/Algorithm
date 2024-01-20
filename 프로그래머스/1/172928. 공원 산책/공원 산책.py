def solution(park, routes):
    n, m = len(park), len(park[0])

    def check(x, y):
        if x < 0 or x >= n or y < 0 or y >= m or park[x][y] == 'X':
            return False
        return True

    d = {
        'N': (-1, 0),
        'S': (1, 0),
        'W': (0, -1),
        'E': (0, 1)
    }
    for i in range(len(park)):
        for j in range(len(park[0])):
            if park[i][j] == 'S':
                x, y = i, j
                break
        else:
            continue
        break

    for r in routes:
        a, b = r.split()
        b = int(b)

        dx, dy = d[a]

        nx, ny = x + dx, y + dy
        if not check(nx, ny):
            continue
        b -= 1
        while b:
            nx, ny = nx + dx, ny + dy
            if not check(nx, ny):
                break
            b -= 1
        else:
            x, y = nx, ny

    return [x, y]


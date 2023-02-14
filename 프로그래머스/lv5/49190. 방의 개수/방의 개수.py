dx = [0, 1, 1, 1, 0, -1, -1, -1]
dy = [1, 1, 0, -1, -1, -1, 0, 1]
v = set()
e = set()


def solution(arrows):
    x = y = nx = ny = 0
    v.add((0, 0))

    for a in arrows:
        for i in range(2):
            nx = x + dx[a]
            ny = y + dy[a]
            tmp_v = (x, y)
            tmp_e = (nx, ny)

            v.add(tmp_e)

            if tmp_v > tmp_e:
                tmp_v, tmp_e = tmp_e, tmp_v

            e.add((tmp_v, tmp_e))
            x = nx
            y = ny

    result = len(e) - len(v) + 1

    return result

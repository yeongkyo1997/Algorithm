import collections



def r_calc(board):
    ret = []
    max_len = 0
    for row in range(len(board)):
        tmp = []
        row_arr = [b for b in board[row] if b != 0]
        counter = collections.Counter(row_arr)
        row_arr.sort(key=lambda x: (counter[x], x))
        visited = set()
        for val in row_arr:
            if val == 0:
                continue
            if val in visited:
                continue
            visited.add(val)
            tmp.append(val)
            tmp.append(counter[val])
        tmp = tmp[:100]
        max_len = max(max_len, len(tmp))

        ret.append(tmp[:100])
        for idx, r in enumerate(ret):
            while len(r) != max_len:
                ret[idx].append(0)

    return ret


if __name__ == '__main__':
    R, C, K = map(int, input().split())
    R -= 1
    C -= 1
    board = [list(map(int, input().split())) for _ in range(3)]

    result = -1
    for t in range(101):
        try:
            # 확인하기
            if board[R][C] == K:
                result = t
                break
        except:
            pass
        # 행이 길거나 같다면
        if len(board) >= len(board[0]):
            board = r_calc(board)
        else:
            board = list(map(list, zip(*board)))
            board = r_calc(board)
            board = list(map(list, zip(*board)))

        # board를 100개까지만 남기고 자르기
        # board = [b[:100] for b in board]

    print(result)
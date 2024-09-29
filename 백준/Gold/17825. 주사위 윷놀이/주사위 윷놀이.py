import sys



def dfs(pieces, depth, total):
    if depth == 10:
        return total

    ret = 0
    # 4개의 조각 중 하나를 선택
    for i in range(4):
        # 선택한 조각의 위치
        cur = pieces[i]
        if cur == 32:
            continue

        # 파란칸이라면
        if len(pos[cur]) == 2:
            # 파란 화살표로 한칸 이동
            cur = pos[cur][1]
        else:
            cur = pos[cur][0]

        for _ in range(arr[depth] - 1):
            cur = pos[cur][0]

        # 이동 후 갈 수 있는지 확인
        if cur not in pieces or cur == 32:
            tmp = pieces[:]
            tmp[i] = cur

            # 이동
            ret = max(ret, dfs(tmp, depth + 1, total + score[cur]))

    return ret


if __name__ == '__main__':
    pos = [[1], [2], [3], [4], [5], [6, 21],
           [7], [8], [9], [10], [11, 25],
           [12], [13], [14], [15], [16, 27],
           [17], [18], [19], [20], [32],
           [22], [23], [24], [30],
           [26], [24],
           [28], [29], [24], [31], [20], [32]]

    score = [0, 2, 4, 6, 8, 10,
             12, 14, 16, 18, 20, 22, 24, 26, 28, 30,
             32, 34, 36, 38, 40,
             13, 16, 19, 25,
             22, 24, 28, 27, 26,
             30, 35, 0]

    arr = list(map(int, input().split()))
    pieces = [0, 0, 0, 0]
    print(dfs(pieces, 0, 0))
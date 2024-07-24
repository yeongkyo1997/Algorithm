T = int(input())


def check(arr):
    visited = [False] * N
    for i in range(N - 1):
        if arr[i] == arr[i + 1]:
            continue
        if abs(arr[i] - arr[i + 1]) > 1:
            return False

        # 다음이 더 클 경우
        if arr[i] < arr[i + 1]:
            for j in range(i, i - X, -1):
                if 0 <= j < N:
                    if visited[j]:
                        return False
                    if arr[i] != arr[j]:
                        return False
                    visited[j] = True
                else:
                    return False

        # 다음이 더 작을 경우
        else:
            for j in range(i + 1, i + X + 1):
                if 0 <= j < N:
                    if visited[j]:
                        return False
                    if arr[i + 1] != arr[j]:
                        return False
                    visited[j] = True
                else:
                    return False
    return True


for t in range(1, T + 1):
    N, X = map(int, input().rstrip().split())

    board = [list(map(int, input().rstrip().split())) for _ in range(N)]
    result = 0
    for b in board:
        if check(b):
            result += 1

    for col in range(N):
        arr = []
        for row in range(N):
            arr.append(board[row][col])
        if check(arr):
            result += 1

    print(f'#{t} {result}')

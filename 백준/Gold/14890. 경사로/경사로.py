N, L = map(int, input().rstrip().split())

board = [list(map(int, input().rstrip().split())) for _ in range(N)]


def check(arr):
    visited = [False] * N
    for i in range(N - 1):
        if abs(arr[i] - arr[i + 1]) > 1:
            return False

        if arr[i] == arr[i + 1]:
            continue
        # 다음이 더 크다면
        elif arr[i] < arr[i + 1]:
            for j in range(i, i - L, -1):
                if 0 <= j < N:
                    if arr[i] != arr[j] or visited[j]:
                        return False
                    visited[j] = True
                else:
                    return False

        # 다음이 더 작으면
        else:
            for j in range(i + 1, i + L + 1):
                if 0 <= j < N:
                    if arr[i + 1] != arr[j] or visited[j]:
                        return False
                    visited[j] = True
                else:
                    return False
    return True


result = 0
# 행
for i in range(N):
    if check(board[i]):
        result += 1

# 열
for col in range(N):
    arr = []
    for row in range(N):
        arr.append(board[row][col])

    if check(arr):
        result += 1

print(result)
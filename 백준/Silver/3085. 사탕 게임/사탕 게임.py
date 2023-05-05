import sys

input = lambda: sys.stdin.readline().rstrip()


def check_x():
    global result, cnt
    for i in range(n):
        cnt = 1
        for j in range(n):
            if j == n - 1:
                result = max(result, cnt)
                break
            if arr[i][j] == arr[i][j + 1]:
                cnt += 1
            else:
                result = max(result, cnt)
                cnt = 1


def check_y():
    global result, cnt
    for i in range(n):
        cnt = 1
        for j in range(n):
            if j == n - 1:
                result = max(result, cnt)
                break
            if arr[j][i] == arr[j + 1][i]:
                cnt += 1
            else:
                result = max(result, cnt)
                cnt = 1


n = int(input())
arr = [list(input()) for _ in range(n)]
result = 0
cnt = 1

for i in range(n):
    for j in range(n - 1):
        arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]
        check_y()
        check_x()
        arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]

for i in range(n):
    for j in range(n - 1):
        arr[j][i], arr[j + 1][i] = arr[j + 1][i], arr[j][i]
        check_y()
        check_x()
        arr[j][i], arr[j + 1][i] = arr[j + 1][i], arr[j][i]

print(result)
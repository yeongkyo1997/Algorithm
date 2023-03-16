n, m = map(int, input().split())
lamp = [list(map(int, input())) for _ in range(n)]
k = int(input())

arr = []
for i in range(n):
    tmp = 0
    num = 0
    for j in range(m):
        tmp = tmp * 2 + lamp[i][j]
        num += lamp[i][j] == 0
    if num > k or (k - num) % 2 != 0:
        continue
    arr.append(tmp)

arr.sort()
if not arr:
    print(0)
    exit()

searchArr = [0] * len(arr)
searchArr[0] = 1
mx = 1
for i in range(1, len(arr)):
    if arr[i] == arr[i - 1]:
        searchArr[i] = searchArr[i - 1] + 1
        mx = max(mx, searchArr[i])
    else:
        searchArr[i] = 1

print(mx)
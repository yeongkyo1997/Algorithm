N, K = map(int, input().split())

visited = [0] * 1000001


def swap(now, i, j):
    arr = list(str(now))
    temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp

    if arr[0] == '0':
        return 0

    return int(''.join(arr))


def bfs():
    global N, K
    arr = [N]
    while arr and K > 0:
        size = len(arr)
        for _ in range(size):
            now = arr.pop(0)

            for i in range(length - 1):
                for j in range(i + 1, length):
                    next = swap(now, i, j)

                    if next != 0 and visited[next] != K:
                        arr.append(next)
                        visited[next] = K

        K -= 1

    if not arr:
        print(-1)
    else:
        print(max(arr))


length = 0
while N // (10 ** length) != 0:
    length += 1

bfs()

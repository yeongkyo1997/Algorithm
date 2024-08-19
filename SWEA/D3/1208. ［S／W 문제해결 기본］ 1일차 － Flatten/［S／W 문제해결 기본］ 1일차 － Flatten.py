for t in range(1, 11):
    N = int(input())
    arr = list(map(int, input().split()))
    swap = 0

    while True:
        arr.sort()
        if arr[-1] - arr[0] <= 1:
            break
        if swap >= N:
            break
        arr[-1] -= 1
        arr[0] += 1
        swap += 1

    print(f'#{t} {max(arr) - min(arr)}')

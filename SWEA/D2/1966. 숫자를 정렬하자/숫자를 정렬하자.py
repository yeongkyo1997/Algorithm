T = int(input())

for t in range(1, T + 1):
    N = int(input())
    arr = list(map(int, input().rstrip().split()))

    arr.sort()

    print(f'#{t}', end=' ')
    print(*arr)

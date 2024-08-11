for t in range(1, int(input()) + 1):
    N = int(input())
    arr = []
    mod = [50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10]
    for m in mod:
        arr.append(N // m)
        N %= m

    print(f'#{t}', end='\n')
    print(*arr)

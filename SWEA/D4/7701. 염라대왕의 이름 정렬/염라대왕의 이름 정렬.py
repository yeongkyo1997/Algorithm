for t in range(1, int(input()) + 1):
    N = int(input())
    arr = set(input() for _ in range(N))
    arr = sorted(arr, key=lambda x: (len(x), x))
    print(f'#{t}')
    print(*arr, sep='\n')

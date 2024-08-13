for t in range(1, int(input()) + 1):
    input()

    print(f'#{t}', end=' ')
    print(*sorted(map(int, input().split())))

for t in range(1, int(input()) + 1):
    a, b = map(int, input().split())
    div, mod = divmod(a, b)
    print(f'#{t} {div} {mod}')

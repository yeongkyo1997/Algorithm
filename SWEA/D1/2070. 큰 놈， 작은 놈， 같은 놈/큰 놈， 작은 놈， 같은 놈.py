for t in range(1, int(input()) + 1):
    a, b = map(int, input().split())
    print(f'#{t}', end=' ')
    if a == b:
        print('=')
    elif a > b:
        print('>')
    else:
        print('<')

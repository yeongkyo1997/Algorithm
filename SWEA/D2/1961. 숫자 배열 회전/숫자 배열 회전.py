for t in range(1, int(input()) + 1):
    N = int(input())
    board = [list(map(str, input().split())) for _ in range(N)]
    result = []
    for _ in range(3):
        board = list(map(list, zip(*board[::-1])))
        result.append(board)

    result = list(map(list, zip(*result)))
    print(f'#{t}')
    for r in result:
        print(*map(lambda x: ''.join(x), r))

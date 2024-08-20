for t in range(1, int(input()) + 1):
    N = int(input())
    visited = set()
    num = N
    while len(visited) < 10:
        visited.update(str(num))
        num += N
    print(f'#{t} {num - N}')
def pow(N, M):
    if M == 1:
        return N
    mid = M // 2

    if M % 2 == 0:
        return pow(N, mid) * pow(N, mid)
    else:
        return pow(N, mid) * pow(N, mid + 1)


for _ in range(1, 11):
    t = int(input())
    N, M = map(int, input().split())

    print(f'#{t} {pow(N, M)}')

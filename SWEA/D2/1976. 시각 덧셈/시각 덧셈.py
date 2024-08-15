for t in range(1, int(input()) + 1):
    a, b, c, d = map(int, input().split())
    hour = (a + c + (b + d) // 60) % 12
    minute = (b + d) % 60
    print(f'#{t} {hour if hour != 0 else 12} {minute}')

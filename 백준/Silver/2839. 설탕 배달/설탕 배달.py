N = int(input())

result = 0

if N % 5 == 0:
    print(N // 5)

else:
    while N > 0:
        N -= 3
        result += 1
        if N % 5 == 0:
            result += N // 5
            print(result)
            break
        elif N == 1 or N == 2:
            print(-1)
            break
        elif N == 0:
            print(result)
            break
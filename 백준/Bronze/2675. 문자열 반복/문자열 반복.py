for i in range(int(input())):
    R, S = input().split()
    R = int(R)
    S = list(S)

    for i in S:
        print(f'{i}' * R, end='')
    print()
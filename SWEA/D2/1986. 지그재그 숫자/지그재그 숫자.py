for t in range(1,int(input())+1):
    N=int(input())
    print(f'#{t} {N - N // 2 if N % 2 != 0 else -(N // 2)}')

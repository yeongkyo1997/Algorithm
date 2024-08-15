for t in range(1, int(input()) + 1):
    K = int(input())
    s = input()
    prefix = [s[-i:] for i in range(1, len(s) + 1)]
    prefix.sort()
    print(f'#{t} {prefix[K - 1]}')

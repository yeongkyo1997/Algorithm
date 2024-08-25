alpha = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]

for t in range(1, int(input()) + 1):
    _, N = input().split()
    N = int(N)
    arr = input().split()
    arr.sort(key=lambda x: alpha.index(x))
    print(f'#{t}')
    print(*arr)

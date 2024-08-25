alpha = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]

for t in range(1, int(input()) + 1):
    input()
    arr = input().split()
    arr.sort(key=alpha.index)
    print(f'#{t}', *arr)
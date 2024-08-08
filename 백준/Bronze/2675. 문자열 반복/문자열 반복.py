T = int(input())

for _ in range(T):
    R, S = input().split()
    R = int(R)
    for e in S:
        print(e * R, end='')
    print()
S = int(input())
sum = 0
N = 0

while sum < S:
    N += 1
    sum += N

if sum > S:
    N -= 1

print(N)
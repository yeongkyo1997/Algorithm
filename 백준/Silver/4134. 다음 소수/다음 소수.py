def is_prime(N):
    if N == 1 or N == 0:
        return False
    for i in range(2, int(N ** 0.5) + 1):
        if N % i == 0:
            return False
    return True


for _ in range(int(input())):
    n = int(input())
    while not is_prime(n):
        n += 1
    print(n)
N = int(input())

arr = list(map(int, input().split()))


def is_prime(n):
    if n == 1:
        return False
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False

    return True


print(sum(1 for a in arr if is_prime(a)))

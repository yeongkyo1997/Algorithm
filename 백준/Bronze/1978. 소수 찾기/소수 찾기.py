N = int(input())


def is_prime(n):
    if n == 1:
        return False

    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False

    return True


arr = list(map(int, input().split()))
print(sum([1 for i in arr if is_prime(i)]))
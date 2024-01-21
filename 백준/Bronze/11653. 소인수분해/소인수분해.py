n = int(input())


def is_prime(n):
    if n == 1:
        return False

    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True


while True:
    for i in range(2, int(n ** 0.5) + 1):
        while is_prime(i) and n % i == 0:
            print(i)
            n //= i
    if is_prime(n) or n == 1:
        break

if n != 1:
    print(n)
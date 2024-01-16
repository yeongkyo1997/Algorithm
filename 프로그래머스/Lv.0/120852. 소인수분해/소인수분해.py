def solution(n):
    prime = [True] * 10001
    prime[0] = prime[1] = False

    for i in range(2, 10001):
        if prime[i] == False:
            continue
        for j in range(i * 2, 10001, i):
            prime[j] = False

    result = set()

    while n != 1:
        for i in range(2, 10001):
            if prime[i] and n % i == 0:
                result.add(i)
                n //= i
    return sorted(result)



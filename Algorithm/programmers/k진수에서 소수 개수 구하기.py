prime = [True] * 1000001
prime[0], prime[1] = False, False

for i in range(2, 1000001):
    if prime[i]:
        for j in range(i * 2, 1000001, i):
            prime[j] = False


def change(n, k):
    result = ''

    while n != 0:
        result += str(n % k)
        n //= k

    return result[::-1]


def reverse_change(n, k):
    result = 0
    start = len(str(n)) - 1

    for i in list(n):
        result += int(i) * (k ** start)

    return result


def solution(n, k):
    string = change(n, k)
    print(string)
    arr = string.split('0')
    print(list(arr))
    arr = map(int, filter(lambda x: x != '', arr))

    result = len(list(filter(lambda x: prime[x], arr)))
    return result


N, k = map(int, input().split())
print(solution(N, k))

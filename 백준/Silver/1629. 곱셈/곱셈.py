a, b, c = map(int, input().split())


def solution(a, n):
    if n == 1:
        return a % c

    result = solution(a, n // 2)

    if n % 2 == 0:
        return result ** 2 % c
    else:
        return result ** 2 * a % c


print(solution(a, b))
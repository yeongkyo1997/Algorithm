import sys


N = int(input())
star = ['***', '* *', '***']


def solution(star):
    size = len(star)

    result = []
    for i in star:
        result.append(i * 3)
    for i in star:
        result.append(i + ' ' * size + i)
    for i in star:
        result.append(i * 3)

    return result


while len(star) < N:
    star = solution(star)
print('\n'.join(star))
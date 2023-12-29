def solution(n, arr1, arr2):
    return [''.join('#' if int(a, 2) | int(b, 2) else ' ' for a, b in zip(format(i, f'0{n}b'), format(j, f'0{n}b'))) for i, j in zip(arr1, arr2)]


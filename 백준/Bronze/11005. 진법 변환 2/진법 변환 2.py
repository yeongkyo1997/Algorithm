s = ''.join(str(i) for i in range(10))
s += ''.join(chr(i) for i in range(ord('A'), ord('Z') + 1))

N, B = map(int, input().split())


def change(N, B):
    result = ''

    while N:
        result += s[N % B]
        N //= B

    return result[::-1]


print(change(N, B))
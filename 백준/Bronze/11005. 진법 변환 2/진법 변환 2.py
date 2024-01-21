s = ''.join(str(i) for i in range(10))
s += ''.join(chr(i) for i in range(ord('A'), ord('Z') + 1))

N, B = map(int, input().split())


def change(N, B):
    if not N:
        return ''

    return change(N // B, B) + s[N % B]


print(change(N, B))
N = int(input())


def score():
    idx = 0
    cur = 1
    result = 0
    while idx < len(s):
        if s[idx] == 'O':
            result += cur
            cur += 1
        else:
            cur = 1
        idx += 1
    return result


for _ in range(N):
    s = input()
    print(score())

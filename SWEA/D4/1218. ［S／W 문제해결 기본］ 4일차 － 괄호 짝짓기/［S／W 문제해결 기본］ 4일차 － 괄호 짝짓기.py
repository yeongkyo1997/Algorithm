bracket = {
    ')': '(',
    ']': '[',
    '}': '{',
    '>': '<'
}


def check():
    stack = []
    for a in arr:
        if a in ('(', '[', '{', '<'):
            stack.append(a)
        else:
            if stack:
                if stack.pop() != bracket[a]:
                    return 0

    return int(not bool(stack))


for t in range(1, 11):
    input()
    arr = list(input())
    print(f'#{t} {check()}')

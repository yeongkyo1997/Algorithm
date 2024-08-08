N = int(input())

for _ in range(N):
    stack = []

    for i in input():
        if i == '(':
            stack.append('(')
        else:
            if not stack:
                print('NO')
                break
            else:
                if stack.pop() != '(':
                    print('NO')
                    break
    else:
        if stack:
            print('NO')
        else:
            print('YES')
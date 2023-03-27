def main():
    for _ in range(int(input())):
        print(isVPS(list(input())))


def isVPS(vps):
    stack = []

    for i in vps:
        if i == '(':
            stack.append('(')
        else:
            if stack:
                stack.pop()
            else:
                return 'NO'
    if stack:
        return 'NO'
    return 'YES'


if __name__ == '__main__':
    main()
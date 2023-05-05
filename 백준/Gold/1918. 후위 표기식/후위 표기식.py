import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    s = input()
    op = []
    for i in range(len(s)):
        if s[i].isalpha():
            print(s[i], end='')
        else:
            if s[i] == '(':
                op.append(s[i])
            elif s[i] == '*' or s[i] == '/':
                while op and (op[-1] == '*' or op[-1] == '/'):
                    print(op.pop(), end='')
                op.append(s[i])
            elif s[i] == '+' or s[i] == '-':
                while op and op[-1] != '(':
                    print(op.pop(), end='')
                op.append(s[i])
            elif s[i] == ')':
                while op and op[-1] != '(':
                    print(op.pop(), end='')
                op.pop()
    while op:
        print(op.pop(), end='')


if __name__ == '__main__':
    main()
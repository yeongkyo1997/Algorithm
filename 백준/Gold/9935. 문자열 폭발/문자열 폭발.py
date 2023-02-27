import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    string = list(input())
    bomb = list(input())
    stack = []
    for i in range(len(string)):
        stack.append(string[i])
        if string[i] == bomb[-1]:
            if stack[-len(bomb):] == bomb:
                del stack[-len(bomb):]
    if stack:
        print(''.join(stack))
    else:
        print('FRULA')

if __name__ == '__main__':
    main()
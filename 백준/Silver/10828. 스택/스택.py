import sys

input = lambda: sys.stdin.readline().rstrip()


class Node:
    def __init__(self, val):
        self.val = val
        self.next = None


class Stack:
    def __init__(self):
        self.header = None
        self.size = 0

    def is_empty(self):
        return 1 if self.header is None else 0

    def push(self, x):
        node = Node(x)
        self.size += 1

        node.next = self.header
        self.header = node

    def pop(self):

        node = self.header
        if node is None:
            return -1
        self.size -= 1
        self.header = node.next

        return node.val

    def top(self):
        if self.is_empty():
            return -1
        return self.header.val


if __name__ == '__main__':
    stack = Stack()

    N = int(input())

    for _ in range(N):
        query, *data = input().split()

        if query == 'push':
            x = data[0]
            stack.push(x)
        elif query == 'pop':
            print(stack.pop())
        elif query == 'size':
            print(stack.size)
        elif query == 'empty':
            print(stack.is_empty())
        elif query == 'top':
            print(stack.top())
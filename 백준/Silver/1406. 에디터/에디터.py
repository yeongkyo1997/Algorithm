import sys

input = lambda: sys.stdin.readline().rstrip()
print = sys.stdout.write


class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None


def print_list(head):
    temp = head.next
    while temp:
        print(temp.data)
        temp = temp.next
    print('\n')


if __name__ == "__main__":
    head = Node('!')
    cur = head

    text = input()
    for char in text:
        new_node = Node(char)
        new_node.prev = cur
        cur.next = new_node
        cur = new_node

    n = int(input())
    for _ in range(n):
        command = input().split()
        c = command[0]

        if c == 'L':
            if cur.prev:
                cur = cur.prev
        elif c == 'D':
            if cur.next:
                cur = cur.next
        elif c == 'B':
            if cur.prev is None:
                continue
            del_node = cur
            cur = del_node.prev
            if del_node.next:
                cur.next = del_node.next
                del_node.next.prev = cur
            else:
                cur.next = None

        elif c == 'P':
            char = command[1]
            new_node = Node(char)
            new_node.prev = cur
            if cur.next:
                new_node.next = cur.next
                cur.next.prev = new_node
            else:
                new_node.next = None
            cur.next = new_node
            cur = cur.next

    head = head.next
    while head:
        print(head.data)
        head = head.next
class Node:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

def insertNode(temp, root, left, right):
    if temp.value == root:
        temp.left = Node(left) if left != '.' else None
        temp.right = Node(right) if right != '.' else None
    else:
        if temp.left is not None:
            insertNode(temp.left, root, left, right)
        if temp.right is not None:
            insertNode(temp.right, root, left, right)

def preOrder(node):
    if node is None:
        return
    print(node.value, end='')
    preOrder(node.left)
    preOrder(node.right)

def inOrder(node):
    if node is None:
        return
    inOrder(node.left)
    print(node.value, end='')
    inOrder(node.right)

def postOrder(node):
    if node is None:
        return
    postOrder(node.left)
    postOrder(node.right)
    print(node.value, end='')

n = int(input())
head = Node('A')

for _ in range(n):
    root, left, right = input().split()
    insertNode(head, root, left, right)

preOrder(head)
print()
inOrder(head)
print()
postOrder(head)
print()
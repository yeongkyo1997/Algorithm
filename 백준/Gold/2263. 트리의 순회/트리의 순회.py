import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N = int(input())
    inorder = list(map(int, input().split()))
    postorder = list(map(int, input().split()))
    inorder_index = [0] * (N + 1)
    for i in range(N):
        inorder_index[inorder[i]] = i
    
    def preorder(inorder_start, inorder_end, postorder_start, postorder_end):
        if inorder_start > inorder_end or postorder_start > postorder_end:
            return
        root = postorder[postorder_end]
        print(root, end=' ')
        left = inorder_index[root] - inorder_start
        preorder(inorder_start, inorder_index[root] - 1, postorder_start, postorder_start + left - 1)
        preorder(inorder_index[root] + 1, inorder_end, postorder_start + left, postorder_end - 1)
    
    preorder(0, N - 1, 0, N - 1)

if __name__ == '__main__':
    main()
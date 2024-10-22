import collections
import sys

input = lambda: sys.stdin.readline().rstrip()


class Node:
    def __init__(self):
        self.children = {}
        self.is_end = False

    def __repr__(self):
        return f'{self.children}, {self.is_end}'


class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, word):
        node = self.root

        for char in word:
            if char not in node.children:
                node.children[char] = Node()
            node = node.children[char]

        node.is_end = True

    def make(self, word):
        node = self.root
        ret = ''
        for char in word:
            if char in node.children:
                ret += char
                node = node.children[char]
            else:
                ret += char
                break

        return ret


if __name__ == '__main__':
    N = int(input())

    trie = Trie()
    same_name = collections.defaultdict(int)

    for _ in range(N):
        word = input()
        same_name[word] += 1
        if same_name[word] >= 2:
            print(f'{trie.make(word)}{same_name[word]}')
        else:
            print(trie.make(word))
        trie.insert(word)
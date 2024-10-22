class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root

        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()

            node = node.children[char]

        node.is_end = True

    def search(self, word):
        node = self.root

        for char in word:
            if char not in node.children:
                return False
            node = node.children[char]

        return node.is_end

    def starts_with(self, prefix):
        node = self.root

        for char in prefix:
            if char not in node.children:
                return False
            node = node.children[char]

        return True


if __name__ == '__main__':
    for _ in range(int(input())):
        arr = [input() for _ in range(int(input()))]
        arr.sort(key=lambda x: -len(x))

        trie = Trie()
        for a in arr:
            if trie.starts_with(a):
                print('NO')
                break
            else:
                trie.insert(a)
        else:
            print('YES')
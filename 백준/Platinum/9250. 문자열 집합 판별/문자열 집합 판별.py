import sys
from collections import deque, defaultdict


class AhoCorasick:
    def __init__(self):
        self.trie = {}
        self.output = defaultdict(list)
        self.fail = {}

    def add_word(self, word):
        cur = self.trie
        for l in word:
            if l not in cur:
                cur[l] = {}
            cur = cur[l]
        self.output[id(cur)].append(word)

    def build(self):
        q = deque()
        for l, node in self.trie.items():
            self.fail[id(node)] = self.trie
            q.append(node)

        while q:
            cur = q.popleft()
            for l, n_node in cur.items():
                q.append(n_node)
                fail_state = self.fail[id(cur)]
                while fail_state is not None and l not in fail_state:
                    fail_state = self.fail.get(id(fail_state))
                self.fail[id(n_node)] = fail_state[l] if fail_state else self.trie
                self.output[id(n_node)].extend(self.output.get(id(self.fail[id(n_node)]), []))

    def search(self, text):
        cur = self.trie
        for l in text:
            while cur is not None and l not in cur:
                cur = self.fail.get(id(cur))
            if cur is None:
                cur = self.trie
                continue
            cur = cur[l]
            if self.output.get(id(cur)):
                return True
        return False


input = lambda: sys.stdin.readline().rstrip()

N = int(input())
ac = AhoCorasick()
for _ in range(N):
    word = input()
    ac.add_word(word)
ac.build()

Q = int(input())
for _ in range(Q):
    query = input()
    if ac.search(query):
        print("YES")
    else:
        print("NO")
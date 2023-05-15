class Trie:
    def __init__(self):
        self.is_word_end = False
        self.children = [None] * 26

    def add_and_get_child(self, c):
        if not self.children[ord(c) - ord('a')]:
            self.children[ord(c) - ord('a')] = Trie()
        return self.children[ord(c) - ord('a')]

    def get_child(self, c):
        return self.children[ord(c) - ord('a')]

    def set_word_end(self):
        self.is_word_end = True

class Main:
    def __init__(self):
        self.c_trie = Trie()
        self.n_set = set()
        self.c_min = self.n_min = 1001
        self.c_max = self.n_max = 0

    def search_team_name(self, s):
        length = len(s)
        iter = self.c_trie
        
        for i in range(length):
            if length - i < self.n_min:
                break
            
            iter = iter.get_child(s[i])
            if iter is None:
                break
            
            if iter.is_word_end:
                if s[i+1:] in self.n_set:
                    return True
        
        return False

    def solution(self):
        c, n = map(int, input().split())

        for _ in range(c):
            cur = input().strip()
            length = len(cur)
            self.c_min = min(self.c_min, length)
            self.c_max = max(self.c_max, length)

            iter = self.c_trie
            for j in range(length):
                iter = iter.add_and_get_child(cur[j])
            iter.set_word_end()

        for _ in range(n):
            cur = input().strip()
            length = len(cur)
            self.n_min = min(self.n_min, length)
            self.n_max = max(self.n_max, length)
            self.n_set.add(cur)

        q = int(input().strip())
        result = []

        for _ in range(q):
            cur = input().strip()
            chk = False if len(cur) > self.c_max + self.n_max else self.search_team_name(cur)
            result.append('Yes' if chk else 'No')

        print('\n'.join(result))

if __name__ == '__main__':
    main = Main()
    main.solution()
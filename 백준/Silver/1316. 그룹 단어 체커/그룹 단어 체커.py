import sys


def input(): return sys.stdin.readline().rstrip()

N = int(input())
count = 0

for _ in range(N):
    word = input()
    unique_chars = set()
    is_group_word = True
    
    for i in range(len(word)):
        char = word[i]
        
        if char in unique_chars:
            if word[i - 1] != char:
                is_group_word = False
                break
        else:
            unique_chars.add(char)
            
    if is_group_word:
        count += 1

print(count)
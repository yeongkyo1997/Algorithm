import re

def solution(s):
    words = re.split(r'(\s+)', s)
    capitalized_words = [word[0].upper() + word[1:].lower() if word.strip() else word for word in words]
    return ''.join(capitalized_words)

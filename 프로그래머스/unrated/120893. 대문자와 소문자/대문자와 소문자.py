def solution(my_string):
    return ''.join(map(lambda x:change(x), my_string))

def change(char):
    if char.isupper():
        return char.lower()
    else:
        return char.upper()
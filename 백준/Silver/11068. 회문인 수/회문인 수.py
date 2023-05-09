def is_palindrome(s):
    return s == s[::-1]

def convert_base(n, b):
    digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/"
    q, r = divmod(n, b)
    if q == 0:
        return digits[r]
    else:
        return convert_base(q, b) + digits[r]

t = int(input())

for _ in range(t):
    n = int(input())
    palindrome = False
    for b in range(2, 65):
        s = convert_base(n, b)
        if is_palindrome(s):
            palindrome = True
            break
    print(1 if palindrome else 0)
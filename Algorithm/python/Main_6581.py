import sys

input = lambda: sys.stdin.readline().rstrip()

result = ''

while True:
    try:
        string = input()
        if string == '<br>':
            result += '\n'
        elif string == '<hr>':
            result += '-' * 80 + '\n'
        else:
            if len(result.split('\n')[-1]) + len(string) + 1 > 80:
                result += '\n'
            result += string + ' '
    except:
        break

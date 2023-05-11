def solution(myString, pat):
    pat_len = len(pat)
    max_len = 0
    max_substring = ""

    for i in range(len(myString)):
        for j in range(i + pat_len, len(myString) + 1):
            substring = myString[i:j]
            if substring.endswith(pat) and len(substring) > max_len:
                max_len = len(substring)
                max_substring = substring

    return max_substring



def KMP(S, P):
    def LPS(pattern):
        lps = [0] * len(pattern)
        length = 0
        i = 1

        while i < len(pattern):
            if pattern[i] == pattern[length]:
                length += 1
                lps[i] = length
                i += 1
            else:
                if length != 0:
                    length = lps[length - 1]
                else:
                    lps[i] = 0
                    i += 1
        return lps

    n = len(S)
    m = len(P)
    lps = LPS(P)

    i = 0  
    j = 0  

    while i < n:
        if S[i] == P[j]:
            i += 1
            j += 1

        if j == m:
            return 1
        elif i < n and S[i] != P[j]:
            if j != 0:
                j = lps[j - 1]
            else:
                i += 1
    return 0


S = input()
P = input()
print(KMP(S, P))
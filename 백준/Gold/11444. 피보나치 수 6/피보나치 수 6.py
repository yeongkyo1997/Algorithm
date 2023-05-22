MOD = 1000000007

def pow(A, exp):
    if exp == 1 or exp == 0:
        return A
    
    ret = pow(A, exp // 2)
    ret = multiply(ret, ret)
    
    if exp % 2 == 1:
        ret = multiply(ret, origin)
    
    return ret

def multiply(o1, o2):
    ret = [[0] * 2 for _ in range(2)]

    ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD
    ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD
    ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD
    ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD
    
    return ret

origin = [[1, 1], [1, 0]]
A = [[1, 1], [1, 0]]

N = int(input())

print(pow(A, N - 1)[0][0])
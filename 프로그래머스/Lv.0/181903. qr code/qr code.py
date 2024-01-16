def solution(q, r, code):
    return ''.join(alpha for idx, alpha in enumerate(code) if idx % q == r)

def solution(h1, m1, s1, h2, m2, s2):
    def get_cnt(h, m, s):
        h_deg = (h * 30 + m * 0.5 + s * 0.5 / 60) % 360
        m_deg = (m * 6 + s * 0.1) % 360
        s_deg = s * 6
        ret = -1  
        if s_deg >= m_deg:
            ret += 1
        if s_deg >= h_deg:
            ret += 1

        ret += (h * 60 + m) * 2  
        ret -= h 
        if h >= 12:
            ret -= 2
        return ret

    ret = get_cnt(h2, m2, s2) - get_cnt(h1, m1, s1)
    if (h1 == 0 or h1 == 12) and m1 == 0 and s1 == 0:
        ret += 1
    return ret


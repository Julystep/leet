from math import ceil


# 吃香蕉的速度取决于每小时吃多少香蕉，吃香蕉的数量为 1 - max之间，如果时间不够则加快速度，否则减慢速度

def minEatingSpeed(self, piles, h):
    piles.sort()
    L, R = 1, piles[-1]
    while L <= R:
        M = L + ((R - L) >> 1)
        need = sum([ceil(x / M) for x in piles])
        if need > h:
            L = M + 1
        else:
            R = M - 1
    return L

    # piles.sort()
    # L, R = 1, piles[-1]
    # while L <= R:
    #     M = L + ((R - L) >> 1)
    #     need = sum([ceil(x / M) for x in piles])
    #     if need > h:
    #         L = M + 1
    #     else:
    #         R = M - 1
    # return L

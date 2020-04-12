## 思路
'''
判断点是否在线段上

设线段的两端点为 s， e，如果点 p 在该线段上，
那么 distance(p,s) + distance(p,e) == distance(s, e)，
否则p就不在该线段上。
'''

## Unfinished 
class Solution:
    def intersection(self, start1: List[int], end1: List[int], start2: List[int], end2: List[int]) -> List[float]:
        k1 = float('inf')
        k2 = float('inf')
        b1 = False
        b2 = False
        flag = False
        x1 = False
        x2 = False
        y1 = False
        y2 = False
        perpen1 = False
        perpen2 = False
        if (end1[0]-start1[0] == 0):
            x1 = start1[0] ## vertical line
            flag = True
            perpen1 = True
            # print("x1:{}".format(x1))
        else:
            k1 = (end1[1]-start1[1])/(end1[0]-start1[0])
        if (end2[0]-start2[0] == 0):
            perpen2 = True
            x2 = start2[0] ## vertical line
            # print("x2:{}".format(x2))
            if flag:
                if (x1 == x2):
                    if (start2[1] > end2[1]):
                        if (start1[1] > start2[1] and end1[1] > start2[1]):
                            return []
                    elif (start2[1] < end2[1]):
                        if (start1[1] < start2[1] and end1[1] < start2[1]):
                            return []

                    if (max(start1[1],end1[1])>=max(start2[1],end2[1])):
                        if (end1[1] < start1[1]):
                            if (end2[1] < start2[1]):
                                if (end1[1] <= start2[1]):
                                    return [x1,end1[1]]
                                else:
                                    return []
                            elif (end2[1] > start2[1]):
                                if (end1[1] <= end2[1]):
                                    return [x1,end1[1]]
                                else:
                                    return []
                        elif (end1[1] > start1[1]):
                            if (end2[1] < start2[1]):
                                if (start1[1] <= start2[1]):
                                    return [x1,start1[1]]
                                else:
                                    return []
                            elif (end2[1] > start2[1]):
                                if (start1[1] <= end2[1]):
                                    return [x1,start1[1]]
                                else:
                                    return []
                    else:
                        if (end1[1] < start1[1]):
                            if (end2[1] < start2[1]):
                                if (end2[1] <= start1[1]):
                                    return [x1,end2[1]]
                                else:
                                    return []
                            elif (end2[1] > start2[1]):
                                if (start2[1] <= start1[1]):
                                    return [x1,start2[1]]
                                else:
                                    return []
                        elif (end1[1] > start1[1]):
                            if (end2[1] < start2[1]):
                                if (end2[1] <= end1[1]):
                                    return [x1,end2[1]]
                                else:
                                    return []
                            elif (end2[1] > start2[1]):
                                if (start2[1] <= end1[1]):
                                    return [x1,start2[1]]
                                else:
                                    return []
                else:
                    return []
        else:
            k2 = (end2[1]-start2[1])/(end2[0]-start2[0])
        
        ## k = 0
        if (k1 == 0 and k2 == 0):
            y1,y2 = end1[1],end2[1]
            if (start2[0] > end2[0]):
                if (start1[0] > start2[0] and end1[0] > start2[0]):
                    return []
            elif (start2[0] < end2[0]):
                if (start1[0] < start2[0] and end1[0] < start2[0]):
                    return []
            if (max(start1[0],end1[0])>=max(start2[0],end2[0])):
                if (end1[0] < start1[0]):
                    if (end2[0] < start2[0]):
                        if (end1[0] <= start2[0]):
                            return [end1[0],y1]
                        else:
                            return []
                    elif (end2[0] > start2[0]):
                        if (end1[0] <= end2[0]):
                            return [end1[0],y1]
                        else:
                            return []
                elif (end1[0] > start1[0]):
                    if (end2[0] < start2[0]):
                        if (start1[0] <= start2[0]):
                            return [start1[0],y1]
                        else:
                            return []
                    elif (end2[0] > start2[0]):
                        if (start1[0] <= end2[0]):
                            return [start1[0],y1]
                        else:
                            return []
            else:
                if (end1[0] < start1[0]):
                    if (end2[0] < start2[0]):
                        if (end2[0] <= start1[0]):
                            return [end2[0],y2]
                        else:
                            return []
                    elif (end2[0] > start2[0]):
                        if (start2[0] <= start1[0]):
                            return [start2[0],y2]
                        else:
                            return []
                elif (end1[0] > start1[0]):
                    if (end2[0] < start2[0]):
                        if (end2[0] <= end1[0]):
                            return [end2[0],y2]
                        else:
                            return []
                    elif (end2[0] > start2[0]):
                        if (start2[0] <= end1[0]):
                            return [start2[0],y2]
                        else:
                            return []
        if k1:
            b1 = end1[1] - k1 * end1[0]
            # assert(start1[1]=k1*start1[0]+b1)
        if k2:
            b2 = end2[1] - k2 * end2[0]
            # assert(start2[1]=k2*start2[0]+b2)

        if (k1 == 0):
            if (y1 >= start2[1] and y1 <= end2[1] || y1 <= start2[1] and y1 >= end2[1]):
                x = (y1 - b2)/k2
                if (x >= start2[0] and x <= end2[0] || x <= start2[0] and x >= end2[0]):
                    return [x, y1]
                else:
                    return []
            else:
                return []
        if (k2 == 0):
            if (y2 >= start1[1] and y2 <= end1[1] || y2 <= start1[1] and y2 >= end1[1]):
                x = (y2 - b1)/k1
                if (x >= start1[0] and x <= end1[0] || x <= start1[0] and x >= end1[0]):
                    return [x, y2]
                else:
                    return []
            else:
                return []

        if k1 and perpen2:
            if (start1[1]<end1[1]):
                # 考虑一个垂直一个有斜率的情况 没做完
                if (x2 >= start1[0] and x2 <= end1[0]):
                    return [x2, k1*x2+b1]
                else:
                    return []
            
        
        if k2 and perpen1:
            if (x1 >= start2[0] and x1 <= end2[0]):
                return [x1, k2*x1+b2]
            else:
                return []

        if (k1 == k2):
            if (b1 == b2):
                if (start2[1] > end2[1]):
                    if (start1[1] > start2[1] and end1[1] > start2[1]):
                        return []
                elif (start2[1] < end2[1]):
                    if (start1[1] < start2[1] and end1[1] < start2[1]):
                        return []

                if (max(start1[1],end1[1])>=max(start2[1],end2[1])):
                    if (end1[1] < start1[1]):
                        if (end2[1] < start2[1]):
                            if (end1[1] <= start2[1]):
                                return [(end1[1]-b1)/k1,end1[1]]
                            else:
                                return []
                        elif (end2[1] > start2[1]):
                            if (end1[1] <= end2[1]):
                                return [(end1[1]-b1)/k1,end1[1]]
                            else:
                                return []
                    elif (end1[1] > start1[1]):
                        if (end2[1] < start2[1]):
                            if (start1[1] <= start2[1]):
                                return [(end1[1]-b1)/k1,start1[1]]
                            else:
                                return []
                        elif (end2[1] > start2[1]):
                            if (start1[1] <= end2[1]):
                                return [(end1[1]-b1)/k1,start1[1]]
                            else:
                                return []
                else:
                    if (end1[1] < start1[1]):
                        if (end2[1] < start2[1]):
                            if (end2[1] <= start1[1]):
                                return [(end2[1]-b2)/k2,end2[1]]
                            else:
                                return []
                        elif (end2[1] > start2[1]):
                            if (start2[1] <= start1[1]):
                                return [(start2[1]-b2)/k2,start2[1]]
                            else:
                                return []
                    elif (end1[1] > start1[1]):
                        if (end2[1] < start2[1]):
                            if (end2[1] <= end1[1]):
                                return [(end2[1]-b2)/k2,end2[1]]
                            else:
                                return []
                        elif (end2[1] > start2[1]):
                            if (start2[1] <= end1[1]):
                                return [(start2[1]-b2)/k2,start2[1]]
                            else:
                                return []
            else:
                return []
        else:
            return [(b2-b1)/(k1-k2),k1*(b2-b1)/(k1-k2)+b1]


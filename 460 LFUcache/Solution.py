class LFUCache:

    def __init__(self, capacity: int):
        self.c, self.__count = capacity, 0
        self.keys = {}  # {key: int, value = [value, fre, time]}

    def get(self, key: int) -> int:
        self.__count += 1

        if key in self.keys:
            self.keys[key][1] += 1
            self.keys[key][2] = self.__count
            return self.keys[key][0]
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        self.__count += 1

        if self.c == 0:
            return
        #  如果key不存在
        if key not in self.keys:
            if len(self.keys) >= self.c:
                #  寻找使用次数最少的key
                min_keys = []
                min_fre = self.keys[min(self.keys, key=lambda x:self.keys[x][1])][1]
                for k in self.keys:
                    if self.keys[k][1] == min_fre:
                        min_keys.append(k)
                #  在使用次数最少的key中寻找最近没有使用的
                min_time, least_key = 1e8, 0
                for k in min_keys:
                    if self.keys[k][2] < min_time:
                        min_time = self.keys[k][2]
                        least_key = k
                #  删除the least frequently used key
                del self.keys[least_key]
            self.keys[key] = [value, 1, self.__count]
        #  如果key存在
        else:
            self.keys[key][0] = value
            self.keys[key][1] += 1
            self.keys[key][2] = self.__count

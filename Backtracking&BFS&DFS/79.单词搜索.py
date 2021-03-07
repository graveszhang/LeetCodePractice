class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        direction = [(1,0),(0,1),(-1,0),(0,-1)]
        visited = set()
        h = len(board)
        w = len(board[0])
        def check(i,j,k):
            if board[i][j] != word[k]: return False
            if k == len(word)-1: return True
            visited.add((i,j))
            res = False
            for di,dj in direction:
                mi,mj = di+i, dj+j
                if 0<=mi<h and 0<=mj<w and (mi,mj) not in visited and check(mi,mj,k+1):
                    return True
                    break
            visited.remove((i,j))
            return res
        for i in range(h):
            for j in range(w):
                if check(i,j,0):
                    return True
        return False
        
        
        
        



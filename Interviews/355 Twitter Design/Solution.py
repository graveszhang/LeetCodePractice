class Twitter:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.user = defaultdict(set) # every user with a followee set
        self.tweets = [] 

    def postTweet(self, userId: int, tweetId: int) -> None:
        """
        Compose a new tweet.
        """
        self.tweets.append((userId, tweetId))
        
    def getNewsFeed(self, userId: int) -> List[int]:
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        """
        users = self.user[userId]
        users.add(userId)
        ans = []
        for i in range(len(self.tweets)-1, -1, -1):
            if self.tweets[i][0] in users:
                ans.append(self.tweets[i][1])
            if len(ans) == 10:
                break
        return ans
        
    def follow(self, followerId: int, followeeId: int) -> None:
        """
        Follower follows a followee. If the operation is invalid, it should be a no-op.
        """
        self.user[followerId].add(followeeId)
        

    def unfollow(self, followerId: int, followeeId: int) -> None:
        """
        Follower unfollows a followee. If the operation is invalid, it should be a no-op.
        """
        if followeeId in self.user[followerId]:
            self.user[followerId].remove(followeeId)
        


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)

class Solution1 {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        for (int i=0;i<nums.size();++i){
            for (int j=i+1;j<nums.size();++j){
                if (nums[i]+nums[j]==target){
                    result.push_back(i);
                    result.push_back(j);
                    break;
                }
            }
        }
    return result;
    }
};

// 执行用时 : 452 ms, 在所有 cpp 提交中击败了 10.08% 的用户
// 内存消耗 : 9 MB, 在所有 cpp 提交中击败了 98.74% 的用户

class Solution2 {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int,int> a; // hash
        vector<int> b(2,-1); // 初始化一个大小为2，值为-1的容器b
        for(int i=0;i<nums.size();i++)
        {
            if(a.count(target-nums[i])>0){ // 判断需要的值是否在数组中出现超过0次
                b[0]=a[target-nums[i]];
                b[1]=i;
                break;
            }
            //a.insert({nums[i],i});
            //insert函数插入相同的key不会覆盖value，但下面这句可以
            a[nums[i]]=i;
            // 这个map的key是数组的值，value是对应的index
        }
        return b;
    };
};
// 执行用时 : 12 ms, 在所有 cpp 提交中击败了 87.61% 的用户
// 内存消耗 : 10 MB, 在所有 cpp 提交中击败了 42.82% 的用户

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        for (int i=0;i<nums.size();++i){
            for (int j=i+1;j<nums.size();++j){
                if (nums[i]+nums[j]==target){
                    result.push_back(i);
                    result.push_back(j);
                }
            }
        }
    return result;
    }
};

//执行用时 : 452 ms, 在所有 cpp 提交中击败了 10.08% 的用户
//内存消耗 : 9 MB, 在所有 cpp 提交中击败了 98.74% 的用户

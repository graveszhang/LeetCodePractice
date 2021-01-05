/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *result = new ListNode(-1); // 初始化
        ListNode *pre = result; 
        ListNode *l11 = l1; 
        ListNode *l22 = l2;
        
        // 对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，
        // 该指针的下一个节点指向真正的头结点head。使用预先指针的目的在于链表初始化时无可用节点值，
        // 而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
        
        bool addone = false; // 判断是否进位
        while(l1->next!=NULL || l2->next!=NULL){ // 位数不同时补0使得位数相同
            if(l1->next == NULL && l2->next!=NULL){
                l1->next = new ListNode(0);
            }
            else if (l1->next != NULL && l2->next==NULL){
                l2->next = new ListNode(0);
            }
            l1 = l1->next;
            l2 = l2->next;
        }

        while(l11!=NULL && l22!=NULL){
            if (l11->val+l22->val+addone<10){ // 每一位都要考虑加上上一位的进位
                result->next = new ListNode(l11->val+l22->val+addone); // 直接从第二位开始保存结果，不存在当前位的原因是下一位难以初始化
                addone = false; 
            }
            else{
                result->next = new ListNode((l11->val+l22->val+addone)%10);
                addone = true;
            }
            l11 = l11->next;
            l22 = l22->next;
            result = result->next;
        }
        if(addone){ // 最后一位的进位问题
            result->next = new ListNode(1);
            result = result->next;
        }
        return pre->next; // pre指向result的第一位是初始化产生的-1，从next开始是结果
    }
};

// 执行用时 : 20 ms, 在所有 cpp 提交中击败了 98.55% 的用户
// 内存消耗 : 10.4 MB, 在所有 cpp 提交中击败了 79.80% 的用户

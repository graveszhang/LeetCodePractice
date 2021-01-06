class Solution {
    public boolean isValid(String s) {
        if (s.length()%2 == 1) return false;

        Map<Character, Character> parenthesis = new HashMap<Character, Character>();
        Stack<Character> stack = new Stack<Character>();
        parenthesis.put(')', '(');
        parenthesis.put(']', '[');
        parenthesis.put('}', '{');

        for (char c : s.toCharArray()){
            if (parenthesis.containsKey(c)){
                if (stack.isEmpty()) return false;
                if (stack.pop() != parenthesis.get(c)){
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        // return true; // wrong, 最后还要确认stack是否为空
        return stack.isEmpty();
    }
}

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        int value = 0;

        for(String token : tokens) {

            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();

                if(token.equals("+")){
                    value = b+a;
                } else if (token.equals("-")){
                    value = b-a;
                } else if(token.equals("*")) {
                    value = b*a;
                } else {
                    value = b/a;
                }

                stack.push(value);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
        
    }
}

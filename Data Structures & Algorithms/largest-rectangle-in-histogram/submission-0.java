class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        Stack<Integer> stack = new Stack<>();
        int[] nsl = new int[n];
        int[] nsr = new int[n];

        //nearer smaller right
        for(int i = n-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            nsr[i] = stack.isEmpty() ? n :stack.peek();
            stack.push(i);
        }

        stack.clear();

        // nearer smaller left
        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            nsl[i] = stack.isEmpty() ? -1 :stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for(int i = 0; i<n; i++){
            int width = nsr[i] - nsl[i] - 1;
            int currArea = heights[i] * width;
            ans = Math.max(ans,currArea);
        }
        return ans;
    }
}

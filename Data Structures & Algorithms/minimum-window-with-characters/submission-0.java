class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if (t.length() > n) return "";

        int[] map = new int[128];


        int left = 0;
        int start = 0;
        int requiredCount = 0;
        int minLength = Integer.MAX_VALUE;

        for(char ch : t.toCharArray()) {
            map[ch]++;
        }

        for(int right = 0; right<n; right++){
            char rightChar = s.charAt(right);

            if(map[rightChar] > 0){
                requiredCount++;
            }

            map[rightChar]--;

            while(requiredCount == t.length()){
                int windowLength = right - left + 1;

                if(windowLength<minLength) {
                    minLength = windowLength;
                    start = left;
                }

                char leftChar = s.charAt(left);
                map[leftChar]++;
                
                if(map[leftChar]>0){
                    requiredCount --;
                }
                left ++;
            }
        }
        return minLength == Integer.MAX_VALUE? "" : s.substring(start, start + minLength);
        
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        int left = 0, maxLength = 0;

        for(int right = 0; right<s.length();right++){
            char ch = s.charAt(right);

            if(hash[ch] != -1 && hash[ch] >= left){
                left = hash[ch]+1;
            }

            hash[ch] = right;
            maxLength = Math.max(right-left+1, maxLength);

        }
        return maxLength;
    }
}

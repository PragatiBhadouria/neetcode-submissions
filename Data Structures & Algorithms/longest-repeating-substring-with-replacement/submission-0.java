class Solution {
    public int characterReplacement(String s, int k) {

        int l = 0, r = 0;
        int maxFrequency = 0, maxLength = 0;
        int hash[] = new int[26];

        while(r<s.length()){
            char ch = s.charAt(r);
            hash[ch - 'A'] ++;

            maxFrequency = Math.max(maxFrequency, hash[ch-'A']);
            while((r-l+1) - maxFrequency>k){
                hash[s.charAt(l) - 'A']--;
                l++;
            }
            maxLength = Math.max(maxLength, r-l+1);
            r++;
        } 
        return maxLength;
        
    }
}

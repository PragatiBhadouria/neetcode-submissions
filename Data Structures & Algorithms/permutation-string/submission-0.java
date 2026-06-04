class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        if(n1>n2) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(char ch : s1.toCharArray()){
            s1Count[ch - 'a']++;
        }
        int left = 0;
        for(int right = 0; right<n2; right++){
            s2Count[s2.charAt(right) - 'a']++;
        
            if((right-left+1)>n1){
                s2Count[s2.charAt(left)- 'a']--;
                left++;
            }

            if(matches(s1Count, s2Count)){
                return true;
            }
        }
        return false;
    }

    private boolean matches(int[]s1, int[]s2){
        for(int i = 0; i<26; i++){
            if(s1[i] != s2[i]) return false;
        }
        return true;
    }
}

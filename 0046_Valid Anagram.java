class Solution{
    public boolean anagramStrings(String s,String t){
        if(s.length()!=t.length())return false;
        int[] f1=new int[26],f2=new int[26];
        for(char c:s.toCharArray())f1[c-'a']++; //anagram 
        for(char c:t.toCharArray())f2[c-'a']++; //nagaram
        for(int i=0;i<26;i++){                  //compare freq of both anagram and nagaram 
            if(f1[i]!=f2[i])return false;
        }
        return true;
    }
}

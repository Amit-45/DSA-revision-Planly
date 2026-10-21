
class Solution{
    public List<Character> frequencySort(String s){
        Pair[] freq=new Pair[26];
        for(int i=0;i<26;i++)freq[i]=new Pair(0,(char)(i+'a')); //(0,a), (0,b)......
        for(char ch:s.toCharArray())freq[ch-'a'].freq++;// (2,a)(0,b)(7,c)(0,d).......
        Arrays.sort(freq,(p1,p2)->{
            if(p1.freq!=p2.freq)return p2.freq-p1.freq; // (7,c)(2,a)(0,b)(0,d)......
            return p1.ch-p2.ch; //highest to lowest sorting
        });
        List<Character> result=new ArrayList<>();
        for(Pair p:freq){
            if(p.freq>0)result.add(p.ch);           //(7,c)(2,a) only 
        }
        return result;
    }
    class Pair{
        int freq;
        char ch;
        Pair(int f,char c){
            this.freq=f;
            this.ch=c;
        }
    }
}

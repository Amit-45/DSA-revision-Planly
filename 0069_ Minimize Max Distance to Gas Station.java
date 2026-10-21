class Solution{
    private int numberOfGasStationsRequired(double dist,int[] arr){
        int cnt=0;
        for(int i=1;i<arr.length;i++){
            // Count stations needed in current gap
            int numberInBetween=(int)((arr[i]-arr[i-1])/dist);

            // Adjust if distance fits exactly
            if((arr[i]-arr[i-1])==dist*numberInBetween)numberInBetween--;

            cnt+=numberInBetween;
        }
        return cnt;
    }

    public double minimiseMaxDistance(int[] arr,int k){
        double l=0,h=0;

        // Find maximum existing gap
        for(int i=0;i<arr.length-1;i++){
            h=Math.max(h,arr[i+1]-arr[i]);
        }

        double diff=1e-6;
        while(h-l>diff){
            double mid=(l+h)/2.0;
            int cnt=numberOfGasStationsRequired(mid,arr);

            if(cnt>k)l=mid; // Too many stations: increase distance
            else h=mid; // Possible: try smaller distance
        }
        return h;
    }
}

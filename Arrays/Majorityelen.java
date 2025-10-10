package Arrays;

public class Majorityelen {
    // public static void major(int arr[],int n){
    //     HashMap<Integer,Integer> mpp=new HashMap<>();
    //     for(int i=0;i<n;i++){
    //         int value=mpp.getOrDefault(arr[i], 0);
    //         mpp.put(arr[i], value+1);

    //     }
    //     for(Map.Entry<Integer,Integer> it:mpp.entrySet()){
    //         if(it.getValue()>(n/2)){
    //             System.out.println(it.getKey());
    //         }
    //     }
    // }

    public static void major(int arr[],int n){
        int cnt=0;
        int ele=0;
        for(int i=0;i<n;i++){
            if(cnt==0){
                cnt=1;
                ele=arr[i];
            }
            else if(ele==arr[i]){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        int cnt1=0;
        for(int i=0;i<n;i++){
            if(ele==arr[i]) cnt1++;
        }
        if(cnt1>n/2){
            System.out.println(ele);
        }
    }
    public static void main(String[] args) {
        int arr[]={2,2,3,3,1,2,2};
        int n=arr.length;
        major(arr,n);
    }
}

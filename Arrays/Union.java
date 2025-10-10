package Arrays;

import java.util.ArrayList;

public class Union {
    // public static void Unionbrute(int arr1[],int arr2[],int n,int m){
    //     HashSet<Integer> hs=new HashSet<>();
    //     for(int i=0;i<n;i++){
    //         hs.add(arr1[i]);
    //     }
    //     for(int i=0;i<m;i++){
    //         hs.add(arr2[i]);
    //     }
    //     ArrayList<Integer> s=new ArrayList<>();
    //     for(int it:hs){
    //         s.add(it);
    //     }
    //     System.out.println(s);

    // } 
    public static void Unionoptimal(int arr1[],int arr2[],int n,int m){
       int i=0;
       int j=0;
       ArrayList<Integer> Union=new ArrayList<>();
       while(i<n && j<m){
        if(arr1[i]<=arr2[j]){
            if(Union.size()==0 || Union.get(Union.size()-1)!=arr1[i]){
                Union.add(arr1[i]);
            }
            i++;
        }
        else{
            if(Union.size()==0 || Union.get(Union.size()-1)!=arr2[j]){
                Union.add(arr2[j]);
            }
            j++;
        }

       }
       while(i<n){
        if(Union.size()==0 || Union.get(Union.size()-1)!=arr1[i]){
            Union.add(arr1[i]);
        }
        i++;
       }    
       while(j<m){
        if(Union.size()==0 || Union.get(Union.size()-1)!=arr2[j]){
            Union.add(arr2[j]);
        }
        j++;
       }     
       System.out.println(Union);   
    }
    
    public static void main(String[] args) {
        int arr1[]={1,2,3,4,4};
        int arr2[]={1,1,2,3,4};
        int n=5;
        int m=5;
        Unionoptimal(arr1,arr2,n,m);

    }
}

package Greedy;

    import java.util.*;

public class FractionalKnapsack {
   static class Item {
        int value;
        int weight;
        double ratio;
        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio=(double)value/weight;
        }
    }
    static class ItemComparator implements Comparator<Item>{
        public int compare(Item a,Item b){
            double r1=(double) a.value/(double) a.weight;
            double r2=(double) b.value/(double) b.weight;
            return Double.compare(r2, r1);
        }
    }
    public static double getmaxval(int W,Item[] arr,int n){
         //Arrays.sort(arr,new ItemComparator()); //sort item base on value/weight ratio
         Arrays.sort(arr, (a, b) -> Double.compare(b.ratio, a.ratio));
         double currw=0.0;
         double finalval=0.0;
         for(int i=0;i<n;i++){

             // If the current item can be fully added to the knapsack
            if(currw+arr[i].weight<=W){
                currw+=arr[i].weight;
                finalval+=arr[i].value;  // Add the full value of the item
            }else{
                // If the current item can't be fully added, take the fractional part
                double remain=W-currw;
                finalval+=(arr[i].value/(double)arr[i].weight)*(double)remain;
                break;
            }
         }
         return finalval;
         
    }
    public static void main(String[] args) {
        int n=3,weight=50;
        Item[] arr={new Item(100,20),new Item(60,100),new Item(120,30)};
        double ans=getmaxval(weight,arr,n);
        System.out.println(ans);
    }
}

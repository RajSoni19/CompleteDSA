package Heaps;
import java.util.*;
public class HandsofStraigth {

    public static boolean gethand(int arr[],int grp){
        if(arr.length % grp != 0) return false;
        TreeMap<Integer,Integer> freq=new TreeMap<>(); //storing all card with freq with order(bcs card value ineach grp form seq of groupsize consecutive integer)
        for(int card:arr){
            freq.put(card,freq.getOrDefault(card, 0)+1);
        }
        while(!freq.isEmpty()){
          int start=freq.firstKey(); //picking first card (smallest) so greedy that is start of grp
          int count=freq.get(start); //no. of  grps to form starting from this card
          for(int i=0;i<grp;i++){ //build grp of grpsize
            int card=start+i; // checking next card is there or not 
            if(!freq.containsKey(card) || freq.get(card)<count) return false; //if next card not availble or next card freq less than current card building freq then false

            //decrease freq If the frequency of the next card is exactly the same as the count(current card)
            if(freq.get(card)==count) freq.remove(card);
             else freq.put(card,freq.get(card)-count); //when you have more of a card than you actually need right now.
          }    
        }
        return true;
    }
    public static void main(String[] args){
        int[] arr={1,2,3,6,2,3,4,7,8};
        int grp=3;
        System.out.println(gethand(arr,grp));
    }
}

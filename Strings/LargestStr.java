package Strings;

public class LargestStr {
    //Lexographically largest string
    public static void main(String[] args) {
        String fruits[]={"apple","banana","mango","kiwi"};
        String largest=fruits[0];
        for(int i=1;i<fruits.length;i++){
            if(largest.compareTo(fruits[i])<0){
                largest=fruits[i];
            }
            // if(fruits[i].compareTo(largest)>0){
            //     largest=fruits[i];
            // }
           
        }
        System.out.println(largest);
    }
    
}

package Greedy;

public class LemondeChange {

    public static boolean  getchange(int[] bills) {
        int five = 0; //counter for 5$ bill
        int ten = 0;  //counter for 10$ bill
        for (int bill : bills) {
            if (bill == 5) {
                five++; //accept 5 (no change needed)
            }
            else if (bill == 10) { 
                if (five > 0) {
                    five--; // give one 5 as change
                    ten++;  // and accept 10 change
                }
                else{
                   return false; // cannot give change
                }

            }

            else{ // if bill is 20$
                if(five>0 && ten>0){ 
                    ten--; // give one 10 as change
                    five--; // give one 5 as change
                }
                else if(five>=3){
                    five-=3; // give three 5 as change
                }
                else{
                    return false; // cannot give change
                }
            }
        

        }
        return true; // successfully given change
    }

    public static void main(String[] args) {
        int bills[] = { 5, 5, 10, 10, 20 };
        System.out.println(getchange(bills));
    }
}

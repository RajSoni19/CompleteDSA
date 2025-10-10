import java.util.*;

public class PalindromePartition {

    public static List<List<String>> parti(String s){
        List<List<String>> result=new ArrayList<>();
        List<String> path=new ArrayList<>();
        func(0,s,result,path);
        return result;
    }

    public static boolean ispali(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
            
        }
        return true;
    }
    public static void func(int index,String s,List<List<String>> result,List<String> path){
        if(index==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(ispali(s,index,i)){
                path.add(s.substring(index,i+1));
                func(i+1,s,result,path);
                path.remove(path.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        String s="aab";
        List<List<String>> ans=new ArrayList<>();
        
        ans=parti(s);
        System.out.println(ans);

    }
}

import java.util.*;
public class LetterCombinationphone {

    public static List<String> letterp(String digits){
        List<String> result=new ArrayList<>();
        if(digits==null || digits.length()==0) return result;
        String[] map={
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };

        backtrack(digits,0,new StringBuilder(),result,map);
        return result;
    }

    public static void backtrack(String digits,int index,StringBuilder path,List<String> result,String[] map){
        if(index==digits.length()){
            result.add(path.toString());
            return;
        }

        char digit=digits.charAt(index);
        String letters=map[digit-'0'];
        for(char c:letters.toCharArray()){
            path.append(c);
            backtrack(digits, index+1, path, result, map);
            path.deleteCharAt(path.length()-1);
        }
    }
    public static void main(String[] args) {
        String digits="23";
        List<String> result=new ArrayList<>();
        result=letterp(digits);
        System.out.println(result);

    }
}

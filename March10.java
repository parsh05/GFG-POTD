package march;
import java.util.HashMap;
class Solution {
  String removeDuplicates(String str) {
      HashMap<Character,Integer> mp = new HashMap<>();
    char ch ='a';
    StringBuilder s = new StringBuilder();
    for(int i=0;i<str.length();i++){
         ch = str.charAt(i);
         if(!mp.containsKey(ch) ){
            mp.put(ch,1);
            s.append(ch);
         }
    }
    return s.toString();
  }
}

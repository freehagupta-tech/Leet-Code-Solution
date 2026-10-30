class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            result = result + sb.reverse().toString();
            if (i < words.length - 1) {
                result = result + " ";
            }
        }
        return result;
        
    }
}
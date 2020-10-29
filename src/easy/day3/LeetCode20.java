package easy.day3;


import java.util.Stack;

public class LeetCode20 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        if (s.length() % 2 != 0) {
            return false;
        }
        for (char car : s.toCharArray()) {
            switch (car) {
                case '(':
                case '[':
                case '{':
                    stack.push(car);
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.empty() || stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.empty() || stack.pop() != '{') return false;
                    break;
            }
        }
        return stack.empty();

    }


//    public static boolean isValid(String s) {
//        if (s.length() % 2 != 0) {
//            return false;
//        }
//        char[] stack = new char[s.length()];
//        char[] chars = s.toCharArray();
//        int index = -1;
//        for (int i = 0; i < s.length(); i++) {
//            if (i == 0) {
//                stack[++index] = chars[i];
//            } else {
//                switch (chars[i]) {
//                    case '(':
//                    case '[':
//                    case '{':
//                        stack[++index] = chars[i];
//                        break;
//                    case ')':
//                        if (index == -1 || stack[index--] != '(') return false;
//                        break;
//                    case ']':
//                        if (index == -1 || stack[index--] != '[') return false;
//                        break;
//                    case '}':
//                        if (index == -1 || stack[index--] != '{') return false;
//                        break;
//                }
//            }
//        }
//        return index == -1;
//    }

//    public static  boolean isValid(String s) {
//        if(s.length()%2!=0){
//            return false;
//        }
//        char[] chars = s.toCharArray();
//        for(int i=0;i<chars.length/2;i++){
//            switch (chars[i]){
//                case '(':
//                    if(chars[chars.length-1-i]!=')') return false;
//                    break;
//                case '{':
//                    if(chars[chars.length-1-i]!='}') return false;
//                    break;
//                case '[':
//                    if(chars[chars.length-1-i]!=']') return false;
//                    break;
//            }
//        }
//        return true;
//    }
}

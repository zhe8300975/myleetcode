package easy.day6;

import java.util.ArrayList;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//push(x) —— 将元素 x 推入栈中。
//pop() —— 删除栈顶的元素。
//top() —— 获取栈顶元素。
//getMin() —— 检索栈中的最小元素
//
public class LeetCode155 {

//    public static class MinStack {
//
//
//        private ArrayList<Integer> list;
//        private ArrayList<Integer> minList;
//
//        /**
//         * initialize your data structure here.
//         */
//        public MinStack() {
//            list = new ArrayList<Integer>();
//            minList = new ArrayList<Integer>();
//        }
//
//        public void push(int x) {
//            list.add(x);
//            addX(x);
//        }
//
//        public void pop() {
//            if (list.size() == 0) {
//                return;
//            }
//            int x = list.remove(list.size() - 1);
//            removeX(x);
//        }
//
//        public int top() {
//            if (list.size() == 0) {
//                return -1;
//            }
//            return list.get(list.size() - 1);
//        }
//
//        public int getMin() {
//            return minList.get(0);
//        }
//
//        private void addX(int x) {
//            for (int i = 0; i < minList.size(); i++) {
//                if (x < minList.get(i)) {
//                    minList.add(i, x);
//                    return;
//                }
//            }
//            minList.add(x);
//        }
//
//        private void removeX(int x) {
//            int index = minList.indexOf(x);
//            minList.remove(index);
//        }
//    }


    public static class MinStack {


        private ArrayList<Integer> list;
        private ArrayList<Integer> minList;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            list = new ArrayList<Integer>();
            minList = new ArrayList<Integer>();
        }

        public void push(int x) {
            int index = minList.size() - 1;
            list.add(x);
            if (index== -1) {
                minList.add(x);
            } else {
                minList.add(x < minList.get(index) ? x : minList.get(index));
            }
        }

        public void pop() {
            if (list.size() == 0) {
                return;
            }
            int index = list.size() - 1;
            list.remove(index);
            minList.remove(index);
        }

        public int top() {
            if (list.size() == 0) {
                return -1;
            }
            return list.get(list.size() - 1);
        }

        public int getMin() {
            if (list.size() == 0) {
                return -1;
            }
            return minList.get(list.size() - 1);
        }


    }

}

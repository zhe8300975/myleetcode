package medium.day21;
//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
public class LeetCode208 {

    public static void main(String[] args) {
        System.out.println("a".substring(1, 1));

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));

    }

    static class Trie {
        Trie[] list = new Trie[26];
        boolean isEnd;

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            int index = word.charAt(0) - 'a';
            if (list[index] == null) {
                list[index] = new Trie();
            }
            Trie trie = list[index];
            String sub = word.substring(1);
            if (sub == null || sub.length() == 0) {
                trie.isEnd = true;
            } else {
                list[index].insert(sub);
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }
            int index = word.charAt(0) - 'a';
            if (list[index] == null) {
                return false;
            } else {
                if (word.length() == 1) {
                    return list[index].isEnd;
                } else {
                    return list[index].search(word.substring(1));
                }
            }
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return false;
            }
            int index = prefix.charAt(0) - 'a';
            if (list[index] == null) {
                return false;
            } else {
                if (prefix.length() == 1) {
                    return true;
                } else {
                    return list[index].startsWith(prefix.substring(1));
                }
            }
        }
    }


}

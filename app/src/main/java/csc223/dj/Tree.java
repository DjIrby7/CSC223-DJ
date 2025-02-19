package csc223.dj;

public interface Tree {
        String levelorder();
        String preorder();
        String inorder();
        String postorder();
        void insert(char item);
        boolean search(char item);
        int size();
        boolean isEmpty();
        int height();
     }

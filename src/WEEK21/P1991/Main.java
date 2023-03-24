package WEEK21.P1991;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Node> tree;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/WEEK21/P1991/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        tree = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            char value = st.nextToken().charAt(0);
            int flag1 = 0;
            int flag2 = 0;
            char lt, rt;

            if((lt = st.nextToken().charAt(0)) != '.'){
                flag1 = 1;
            }
            if((rt = st.nextToken().charAt(0)) != '.'){
                flag2 = 1;
            }

            if(flag1 == 0 && flag2 == 0){
                tree.add(new Node(value, null, null));
            } else if (flag1 == 0 && flag2 == 1) {
                tree.add(new Node(value, null, new Node(rt, null, null)));
            } else if (flag1 == 1 && flag2 == 0) {
                tree.add(new Node(value, new Node(lt, null, null), null));
            } else {
                tree.add(new Node(value, new Node(lt, null, null), new Node(rt, null, null)));
            }
        }

        preOrder(tree);
        System.out.println();
        //inOrder(head);
        System.out.println();
        //postOrder(head);
        System.out.println();
    }

    public static void preOrder(ArrayList tree) {
        Node root = tree.get(0);
    }
}

class Node{
    char value;
    Node left;
    Node right;

    public Node(char value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
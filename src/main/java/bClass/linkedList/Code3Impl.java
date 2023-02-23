package bClass.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code3Impl {
    public static int NODE_MAX = 5000;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static StringTokenizer st;

    static class Node {

        int data;

        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {

        Node head;
        Node tail;
        Node[] nodeArr;

        int nodeCnt;

        public LinkedList() {
            this.head = null;
            this.nodeArr = new Node[NODE_MAX];
            this.nodeCnt = 0;
        }

        Node getNewNode(int data) {
            nodeArr[nodeCnt] = new Node(data);
            return nodeArr[nodeCnt++];
        }

        void insert(int idx, int[] nums) {

        }

    }

    public static void main(String[] args) throws IOException {

        for (int tc = 1; tc <= 10; tc++) {
            LinkedList list = new LinkedList();

            int N = Integer.parseInt(br.readLine());

        }

    }
}

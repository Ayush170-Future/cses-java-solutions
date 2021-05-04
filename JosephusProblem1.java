import java.io.*;
 
import java.lang.StringBuilder; 
 
 
import java.util.*;
 
class Node {
    Node next;
    int data;
    Node(int data) {
    this.data = data;
    }
}
 
class JosephusProblem1{
 
     public static void main(String []args) throws IOException
     {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node curr = new Node(1);
        StringBuilder ans = new StringBuilder();
        Node head = curr;
        for(int i = 2; i <= n; i++) {
            Node temp = new Node(i);
            curr.next = temp;
            curr = temp;
        }
        curr.next = head;
        Node pre = curr;
        curr = head;
        int count = n;
        while(count != 1) {
            pre = curr;
            curr = curr.next;
            ans.append(curr.data);
            ans.append(" ");
            pre.next = curr.next;
            curr = pre.next;
            count--;
        }
        ans.append(curr.data);
        System.out.println(ans.toString());
     }
     
}
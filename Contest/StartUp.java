import java.io.*;
import java.util.PriorityQueue;
import java.util.*;

class Element implements Comparable<Element> {
    public int data;
    public int index;

    public Element(int index, int data) {
        this.index = index;
        this.data = data;
    }

    public int compareTo(Element e) {
        return this.data - e.data;
    }
}

public class Solution {
    static PriorityQueue<Element> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long sum = 0;

        for (int i = 0; i < n - 1; i++) {
            int op = sc.nextInt();
            int follow = sc.nextInt();
            Element e = new Element(i, follow);
            if (op == 1) {
                pq.add(e);
                sum += follow;
            } else {
                while(pq.size() >= follow) {
                    if (!pq.isEmpty()) {
                        Element el = pq.poll();
                        sum -= el.data;
                    }
                }
            }
        }

        int op = sc.nextInt();
        int follow = sc.nextInt();
        if (pq.size() < follow) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            List<Integer> lst = new ArrayList<>();
            while(!pq.isEmpty()) {
                int tmp = pq.poll().index + 1;
                lst.add(tmp);
            }
            Collections.sort(lst);
            for(int i = 0; i < lst.size(); i++) {
                System.out.print(lst.get(i) + " ");
            }
        }
    }
}

package com.laurencewelch;

public class Main {

    /*
    * Given an input array of characters not seperated by anything insert spaces between each character
    * ex input: [e,S,o,b]
    * ex output: [e, ,S, ,o, ,b]
    * Runtime Complexity: O(n)
    */
    static String insertSpace(char[] input){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length; i++){
            sb.append(input[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    /*
    * Given a linked list find the nth node from the end. We assume that the list is at least n long.
    * ex input: [1] -> [3] -> [5] -> [7] -> [6] n = 3
    * ex output: 5
    * Runtime Complexity: O(n)
    */
    public static LinkedListNode getNthFromEnd(){
        LinkedList ll = new LinkedList().insert(1).insert(3).insert(5).insert(7).insert(6);
        return getNthFromEnd(ll.head, 3);
    }

    public static LinkedListNode getNthFromEnd(LinkedListNode head, int N){
        LinkedListNode nth = head;
        LinkedListNode toEnd = head; // this will iterate n away from the nth node

        //speed up the runner node n items;
        for(int i = 0; i < N-1; i++){
            toEnd = toEnd.next;
        }
        while(toEnd.getNext() != null){
            nth = nth.next;
            toEnd = toEnd.next;
        }
        return nth;
    }

    /*
     * Given a string write a compression encoder such that "abbbbb" is transformed to "a5xb"
     * ex input: abbbbbcbbb
     * ex output: a5xbc3xb
     * Runtime Complexity: O(n)
     */
    public static String encode(char[] input){
        StringBuilder sb = new StringBuilder();

        char tmp = input[0];
        int firstOccurance = 0;

        for (int i = 1; i < input.length; i++){
            int difference = i - firstOccurance;
            if (input[i] != tmp && (difference == 1)){
                sb.append(tmp);
                tmp = input[i];
                firstOccurance = i;
                continue;
            }

            if (input[i] == tmp && i == input.length -1){
                sb.append(i-firstOccurance + 1).append("x").append(tmp);
                return sb.toString();
            }
            //check to see if the character is the same as the one prior
            if (input[i] == tmp)
                continue;

            sb.append(i-firstOccurance).append("x").append(tmp);
            tmp = input[i];
            firstOccurance = i;

        }
        sb.append(1).append("x").append(tmp);
        return sb.toString();
    }

    public static void main(String[] args) {
        char[] testArray = { 'd', 'a', 'a','b', 'b', 'b', 'b', 'b', 'c' };

	    System.out.println(getNthFromEnd().item);
        System.out.println(encode(testArray));
    }
}

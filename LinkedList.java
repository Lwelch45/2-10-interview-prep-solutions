package com.laurencewelch;

/**
 * Created by laurencewelch on 2/19/15.
 */
public class LinkedList {
    LinkedListNode head;

    public LinkedList insert(LinkedListNode node){
        if(head == null){
            head = null;
            return this;
        }
        LinkedListNode n = head;
        while(n.next != null){
            n = n.next;
        }
        n.next = node;
        return this;
    }

    public LinkedList insert( Integer node){
        if(head == null){
            head = new LinkedListNode(node);
            return this;
        }
        LinkedListNode n = head;
        while(n.next != null){
            n = n.next;
        }
        n.next = new LinkedListNode(node);
        return this;
    }
}

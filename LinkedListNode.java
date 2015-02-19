package com.laurencewelch;

import javax.sound.sampled.Line;

/**
 * Created by laurencewelch on 2/19/15.
 */
public class LinkedListNode {


    LinkedListNode next; //pointer to next node
    Integer item; //simplifying assumption that linked list stores numbers

    public LinkedListNode(int item){
        this.item = item;
    }

    public LinkedListNode getNext(){
        if(next != null)
            return next;
        return null;
    }
}

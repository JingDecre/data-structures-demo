package com.decre.data.structures.datastructuresdemo.test;

import com.decre.data.structures.datastructuresdemo.service.JosephuLinkedList;

/**
 * @className: JosephuLinkedListDemo
 * @description: TODO 类描述
 * @author: decre
 * @date: 2021/1/12
 **/
public class JosephuLinkedListDemo {

    public static void main(String[] args) {
        JosephuLinkedList linkedList = new JosephuLinkedList();
        linkedList.produceJosephu(7);
        linkedList.showNotes();
        linkedList.countNote(3, 2, 7);
    }
}

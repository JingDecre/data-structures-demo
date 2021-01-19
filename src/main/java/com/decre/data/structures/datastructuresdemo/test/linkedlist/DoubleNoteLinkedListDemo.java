package com.decre.data.structures.datastructuresdemo.test.linkedlist;

import com.decre.data.structures.datastructuresdemo.entity.linkedlist.DoubleNote;
import com.decre.data.structures.datastructuresdemo.service.linkedlist.DoubleNoteLinkedList;

/**
 * @className: HeroNoteLinkedListDemo
 * @description: 英雄单向链表测试类
 * @author: decre
 * @date: 2021/1/5
 **/
public class DoubleNoteLinkedListDemo {

    public static void main(String[] args) {
        DoubleNoteLinkedList heroNoteLinkedList = new DoubleNoteLinkedList();
        DoubleNoteLinkedList heroNoteLinkedList2 = new DoubleNoteLinkedList();
        DoubleNote heroNote1 = new DoubleNote(1, "宋江", "及时雨");
        DoubleNote heroNote2 = new DoubleNote(3, "鲁智深", "花和尚");
        DoubleNote heroNote3 = new DoubleNote(2, "林冲", "豹子头");
        DoubleNote heroNote4 = new DoubleNote(4, "吴用", "智多星");
        DoubleNote heroNote5 = new DoubleNote(5, "阮小七", "活阎罗");
        DoubleNote heroNote3N = new DoubleNote(2, "林冲~", "豹子~~");

        DoubleNote heroNote6 = new DoubleNote(6, "鲁智深~", "花和尚~~");
        DoubleNote heroNote7 = new DoubleNote(7, "林冲~~", "豹子头~~");
        DoubleNote heroNote8 = new DoubleNote(8, "吴用~~", "智多星~~");
        DoubleNote heroNote5N = new DoubleNote(5, "阮小七~~", "活阎罗~~");
        heroNoteLinkedList2.addNote(heroNote5N);
        heroNoteLinkedList2.addNote(heroNote6);
        heroNoteLinkedList2.addNote(heroNote7);
        heroNoteLinkedList2.addNote(heroNote8);

        heroNoteLinkedList.addNote(heroNote1);
        heroNoteLinkedList.addNote(heroNote2);
        heroNoteLinkedList.addNote(heroNote3);
        heroNoteLinkedList.addNote(heroNote5);
        heroNoteLinkedList.addNote(heroNote4);
        heroNoteLinkedList.showList();
        // 更新节点
        heroNoteLinkedList.updateNote(heroNote3N);
        heroNoteLinkedList.showList();
        // 删除节点
        heroNoteLinkedList.delNote(1);
        heroNoteLinkedList.showList();

//        System.out.printf("链表有效数据长度：%d\n", heroNoteLinkedList.getLength());
//        System.out.printf("链表倒数第[%d]个节点数据: [%s]\n", 2, heroNoteLinkedList.findLastIndexNote(2).toString());

        System.out.println("链表反转后输出~~");
        heroNoteLinkedList.reverse();
        heroNoteLinkedList.showList();
        System.out.println("两个链表合并后输出~~");

       /* heroNoteLinkedList.addAll(heroNoteLinkedList2);
        heroNoteLinkedList.showList();*/


    }
}

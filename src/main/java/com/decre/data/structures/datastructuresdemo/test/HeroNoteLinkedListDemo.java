package com.decre.data.structures.datastructuresdemo.test;

import com.decre.data.structures.datastructuresdemo.entity.HeroNote;
import com.decre.data.structures.datastructuresdemo.service.HeroNoteLinkedList;

/**
 * @className: HeroNoteLinkedListDemo
 * @description: 英雄单向链表测试类
 * @author: decre
 * @date: 2021/1/5
 **/
public class HeroNoteLinkedListDemo {

    public static void main(String[] args) {
        HeroNoteLinkedList heroNoteLinkedList = new HeroNoteLinkedList();
        HeroNoteLinkedList heroNoteLinkedList2 = new HeroNoteLinkedList();
        HeroNote heroNote1 = new HeroNote(1, "宋江", "及时雨");
        HeroNote heroNote2 = new HeroNote(3, "鲁智深", "花和尚");
        HeroNote heroNote3 = new HeroNote(2, "林冲", "豹子头");
        HeroNote heroNote4 = new HeroNote(4, "吴用", "智多星");
        HeroNote heroNote5 = new HeroNote(5, "阮小七", "活阎罗");
        HeroNote heroNote3N = new HeroNote(2, "林冲~", "豹子~~");

        HeroNote heroNote6 = new HeroNote(6, "鲁智深~", "花和尚~~");
        HeroNote heroNote7 = new HeroNote(7, "林冲~~", "豹子头~~");
        HeroNote heroNote8 = new HeroNote(8, "吴用~~", "智多星~~");
        HeroNote heroNote5N = new HeroNote(5, "阮小七~~", "活阎罗~~");
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

        System.out.printf("链表有效数据长度：%d\n", heroNoteLinkedList.getLength());
        System.out.printf("链表倒数第[%d]个节点数据: [%s]\n", 2, heroNoteLinkedList.findLastIndexNote(2).toString());

        System.out.println("链表通过stack倒叙输出~~");
        heroNoteLinkedList.reversePrint();
        /*System.out.println("链表反转后输出~~");
        heroNoteLinkedList.reverse();
        heroNoteLinkedList.showList();*/
        System.out.println("两个链表合并后输出~~");

        heroNoteLinkedList.addAll(heroNoteLinkedList2);
        heroNoteLinkedList.showList();


    }
}

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
        HeroNote heroNote1 = new HeroNote(1, "宋江", "及时雨");
        HeroNote heroNote2 = new HeroNote(3, "鲁智深", "花和尚");
        HeroNote heroNote3 = new HeroNote(2, "林冲", "豹子头");
        HeroNote heroNote4 = new HeroNote(4, "吴用", "智多星");
        HeroNote heroNote5 = new HeroNote(5, "阮小七", "活阎罗");
        HeroNote heroNote3N = new HeroNote(2, "林冲~", "豹子~~");
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
    }
}

package com.decre.data.structures.datastructuresdemo.entity;

import lombok.Data;

/**
 * @className: JosephuNote
 * @description: 约瑟夫单向环形链表的节点
 * @author: decre
 * @date: 2021/1/12
 **/
@Data
public class JosephuNote {

    private int no;

    @Override
    public String toString() {
        return "JosephuNote{" +
                "no=" + no +
                '}';
    }

    private JosephuNote next;

    public JosephuNote(int no) {
        this.no = no;
    }
}

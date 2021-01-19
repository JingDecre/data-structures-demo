package com.decre.data.structures.datastructuresdemo.entity.linkedlist;

import lombok.Data;

@Data
public class DoubleNote {

    private String name;

    private String nickName;

    private int no;

    public DoubleNote pre;

    public DoubleNote next;

    public DoubleNote(int no, String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
        this.no = no;
    }

    @Override
    public String toString() {
        return "DoubleNote{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", no=" + no +
                '}';
    }
}

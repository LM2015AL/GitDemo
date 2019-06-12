package com.ludm._7.linkedlist.single_linkedlist;

import org.junit.Test;

public class testSingleLinkedList {

	@Test
	public void testSingleLinkedList(){
	    SingleLinkedList singleList = new SingleLinkedList();
	    singleList.addHead("A");
	    singleList.addHead("B");
	    singleList.addHead("C");
	    singleList.addHead("D");
	    //打印当前链表信息
	    singleList.display();
	    //删除C
	    singleList.delete("C");
	    singleList.display();
	    //查找B
	    System.out.println(singleList.find("B"));
	}
}

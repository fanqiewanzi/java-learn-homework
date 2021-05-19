package Controller;


import chart.LinkedListOne;
import chart.LinkedListOneLoop;
import chart.LinkedListTwo;
import chart.LinkedListTwoLoop;


/**
 * @author BAZINGA
 */
public class ListController {
    public static void main(String[] args) {
        //定义数组
        Integer[] a=new Integer[5];
        for(int i=0;i<5;i++){
            a[i]=i;
        }

        //定义单链表对象
        LinkedListOne linkedListOne =new LinkedListOne();
        System.out.println(linkedListOne.isEmpty());
        linkedListOne.add(2);
        System.out.println(linkedListOne.isEmpty());
        linkedListOne.addList(a);
        //打印这个单链表
        linkedListOne.printList();
        //删除
        linkedListOne.delete(0);
        linkedListOne.printList();
        System.out.println(linkedListOne.getByIndex(2));
        linkedListOne.insert(0,3);
        linkedListOne.printList();
        System.out.println(linkedListOne.getByValue(3));
        LinkedListOne linkedListOne1 =new LinkedListOne();
        System.out.println(linkedListOne1.isEmpty());
        System.out.println(linkedListOne.getSize());
        System.out.println(linkedListOne1.getSize());


        LinkedListTwo linkedListTwo=new LinkedListTwo();
        linkedListTwo.addList(a);
        linkedListTwo.printList();
        linkedListTwo.insert(2,3);
        linkedListTwo.add(56);
        linkedListTwo.add(56);
        linkedListTwo.printList();
        linkedListTwo.delete(0);
        System.out.println(linkedListTwo.getSize());
        System.out.println("遍历linkedListTwo");
        linkedListTwo.printList();
        System.out.println(linkedListTwo.getByIndex(6));
        System.out.println(linkedListTwo.getByValue(56));
        System.out.println(linkedListTwo.getSize());
        linkedListTwo.printList();

        LinkedListOneLoop linkedListOneLoop=new LinkedListOneLoop();
        linkedListOneLoop.add(4);
        linkedListOneLoop.addList(a);
        linkedListOneLoop.printList();
        System.out.println(linkedListOneLoop.getSize());
        System.out.println(linkedListOneLoop.getByIndex(2));
        System.out.println(linkedListOneLoop.getByValue(2));
        linkedListOneLoop.delete(0);
        linkedListOneLoop.printList();
        linkedListOneLoop.insert(2,45);
        linkedListOneLoop.printList();
        System.out.println(linkedListOneLoop.getSize());
        LinkedListTwoLoop linkedListTwoLoop=new LinkedListTwoLoop();
        System.out.println( linkedListTwoLoop.isEmpty());
        linkedListTwoLoop.add(3);
        linkedListTwoLoop.addList(a);
        linkedListTwoLoop.insert(2,34);
        linkedListTwoLoop.printList();
        System.out.println(linkedListTwoLoop.getSize());
        linkedListTwoLoop.delete(2);
        linkedListTwoLoop.printList();
        linkedListTwoLoop.getByIndex(2);
        linkedListTwoLoop.getByValue(3);
        System.out.println(linkedListTwoLoop.getSize());
        linkedListTwoLoop.printList();
        System.out.println(linkedListTwoLoop.getSize());
        System.out.println(linkedListOneLoop.isEmpty());
    }
}

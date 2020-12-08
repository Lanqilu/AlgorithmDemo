package linkedlist;

/**
 * @author lanqilu
 * @version v0.0
 * @package linkedlist
 * @date Created in 2020/07/23  10:08
 * @description 约瑟夫问题，单向环形链表
 **/
public class JosephusProblem {
    public static void main(String[] args) {
        //构建
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        //加入5个节点
        circleSingleLinkedList.addBoy(5);
        //显示
        circleSingleLinkedList.showList();

    }
}

/**
 * 创建环形单向链表
 **/
class CircleSingleLinkedList {
    /**
     * 创建一个first节点
     **/
    private Boy first = new Boy(-1);

    /**
     * 添加Boy节点构建一个环形链表
     **/
    public void addBoy(int nums) {
        //nums进行数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        //辅助变量，帮助构建环形链表
        Boy curBoy = null;
        //使用for循环来创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建节点
            Boy boy = new Boy(i);
            //如果是第一个节点
            if (i == 1) {
                first = boy;
                //构成环
                first.setNext(first);
                //让cur指向第一个节点
                curBoy = first;
            }
            else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历环形链表
     **/
    public void showList() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("环形链表为空");
        }
        //first不能动，使用辅助指针
        Boy cur = first;
        while (true) {
            System.out.printf("编号为 %d \n", cur.getNo());
            //已经遍历完毕
            if (cur.getNext() == first) {
                break;
            }
            //后移
            cur = cur.getNext();
        }
    }

}


/**
 * 节点
 **/
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

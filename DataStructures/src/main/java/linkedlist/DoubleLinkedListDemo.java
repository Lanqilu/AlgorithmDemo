package linkedlist;

/**
 * @author lanqilu
 * @version v1.0
 * @package linkedlist
 * @date Created in 2020/07/22  19:09
 * @description 双向链表
 **/
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleHeroNode hero1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode hero2 = new DoubleHeroNode(2, "卢俊义", "火麒麟");
        DoubleHeroNode hero3 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode hero4 = new DoubleHeroNode(4, "公孙胜", "入云龙");

        //创建一个双向链表对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        //添加
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.showList();
        System.out.println();

        //修改
        DoubleHeroNode newHeroNode = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        System.out.println("修改后显示");
        doubleLinkedList.update(newHeroNode);
        doubleLinkedList.showList();
        System.out.println();

        //删除
        doubleLinkedList.delete(3);
        System.out.println("删除后显示");
        doubleLinkedList.showList();
        System.out.println();

    }
}

/**
 * 管理双向链表类
 **/
class DoubleLinkedList {
    /**
     * 初始化一个头节点，不存放具体的数据
     **/
    private DoubleHeroNode head = new DoubleHeroNode(0, "", "");

    public DoubleHeroNode getHead() {
        return head;
    }

    /**
     * 遍历双向链表
     **/
    public void showList() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //创建辅助变量
        DoubleHeroNode temp = head.next;
        while (true) {
            //判断是否到链表的最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }

    /**
     * 不考虑编号添加节点到双向链表的最后
     **/
    public void add(DoubleHeroNode heroNode) {
        //不考虑编号的顺序时，先找到链表的最后的空节点，再将这个节点的next指向新的节点
        //hea节点不能动故需要一个辅助变量
        DoubleHeroNode temp = head;
        //遍历链表找到最后节点
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到就后移temp
            temp = temp.next;
        }
        //当退出while时temp指向最后的节点
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //TODO:按照编号顺序来添加,按照单链表进行修改


    /**
     * 修改节点的信息,同单向链表基本一样
     **/
    public void update(DoubleHeroNode newHeroNode) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点,根据no编号
        //创建辅助变量
        DoubleHeroNode temp = head.next;
        //flag表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //遍历结束
                break;
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }
        else {
            //没有找到
            System.out.printf("没有找到编号为 %d 的节点,不能修改\n", newHeroNode.no);
        }
    }

    /**
     * 删除节点
     **/
    public void delete(int no) {
        //判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        DoubleHeroNode temp = head.next;
        //标志是否找到待删除节点的前一个节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //链表的最后
                break;
            }
            if (temp.no == no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }

        }
        else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }


}

/**
 * 每一个对象就是一个节点
 **/
class DoubleHeroNode {
    public int no;
    public String name;
    public String nickname;
    /**
     * 指向下一个节点,默认为null
     **/
    public DoubleHeroNode next;
    /**
     * 指向前一个节点,默认为null
     **/
    public DoubleHeroNode pre;

    public DoubleHeroNode(int no, String name, String nickname) {
        //IDEA快捷键Alt+Insert
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "DoubleHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

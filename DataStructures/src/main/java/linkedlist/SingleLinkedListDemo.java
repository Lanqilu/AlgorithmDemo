package linkedlist;


import java.util.Stack;

/**
 * @author lanqilu
 * @version v1.0
 * @package linkedlist
 * @date Created in 2020/07/22  14:09
 * @description 单链表进行增删改
 **/
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "火麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //不考虑编号加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero3);

        //按照编号的顺序加入
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        //修改前显示
        System.out.println("修改前显示");
        singleLinkedList.showList();

        //修改节点
        HeroNode newHeroNode = new HeroNode(2, "卢俊义", "玉麒麟");
        singleLinkedList.update(newHeroNode);


        //显示
        System.out.println("修改后显示");
        singleLinkedList.showList();
        System.out.println();

        //删除节点
        singleLinkedList.delete(1);
        singleLinkedList.delete(3);
        singleLinkedList.delete(4);
        System.out.println("删除后链表情况");
        singleLinkedList.showList();
        System.out.println();
        System.out.println();

        //求单链表中有效节点的个数
        System.out.printf("有效的节点个数为: %d \n", singleLinkedList.getLength(singleLinkedList.getHead()));
        System.out.println();

        //得到倒数第k个节点
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.showList();
        HeroNode res = singleLinkedList.findLastIndexNode(singleLinkedList.getHead(), 2);
        System.out.println("得到倒数第k个节点");
        System.out.println("res = " + res);
        System.out.println();

        //反转
        singleLinkedList.reverseList(singleLinkedList.getHead());
        System.out.println("反转结果");
        singleLinkedList.showList();
        System.out.println();

        //逆序打印
        System.out.println("逆序打印");
        singleLinkedList.reversePrint(singleLinkedList.getHead());
        System.out.println();
    }
}

/**
 * 每一个HeroNode对象就是一个节点
 **/
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    /**
     * 指向下一个节点
     **/
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        //IDEA快捷键Alt+Insert
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

/**
 * 管理英雄
 **/
class SingleLinkedList {
    public HeroNode getHead() {
        return head;
    }

    /**
     * 初始化一个头节点，不存放具体的数据
     **/
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 不考虑编号添加节点到单向链表
     **/
    public void add(HeroNode heroNode) {
        //不考虑编号的顺序时，先找到链表的最后的空节点，再将这个节点的next指向新的节点
        //hea节点不能动故需要一个辅助变量
        HeroNode temp = head;
        //遍历链表找到最后节点
        while (temp.next != null) {
            //如果没有找到就后移temp
            temp = temp.next;
        }
        //当退出while时temp指向最后的节点
        //将最后的这个节点指向新的节点
        temp.next = heroNode;
    }

    /**
     * 考虑编号添加节点到单向链表
     **/
    public void addByOrder(HeroNode heroNode) {
        //hea节点不能动故需要一个辅助变量
        //temp位于添加位置的前一个节点
        HeroNode temp = head;
        //标志添加的编号是否存在，默认时false
        boolean flag = false;
        while (true) {
            //temp已经在链表的最后
            if (temp.next == null) {
                break;
            }
            //找到添加的位置，在temp后插入
            if (temp.next.no > heroNode.no) {
                break;
            }
            //希望添加的heroNode的编号已经存在
            else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {
            //flag==true,编号已经存在不能添加
            System.out.printf("编号 %d 已经存在，不能加入\n", heroNode.no);
        }
        else {
            //插入到链表后
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    /**
     * 显示链表(遍历)
     **/
    public void showList() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //创建辅助变量
        HeroNode temp = head.next;
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
     * 修改节点的信息,根据编号来进行修改，即no不能改
     **/
    public void update(HeroNode newHeroNode) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点,根据no编号
        //创建辅助变量
        HeroNode temp = head.next;
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
        HeroNode temp = head;
        //标志是否找到待删除节点的前一个节点
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if (flag) {
            temp.next = temp.next.next;
        }
        else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    /**
     * <p>获取单链表的有效节点个数</p>
     * <p>如果是带头节点的链表，不统计头节点</p>
     *
     * @param head 链表的头节点
     * @return 有效节点的个数
     **/
    public int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            //遍历
            temp = temp.next;
        }
        return length;
    }

    /**
     * 查找单链表的倒数第k个节点
     *
     * @param head:
     * @param index:
     * @return linkedlist.HeroNode
     **/
    public HeroNode findLastIndexNode(HeroNode head, int index) {
        //如果列表为空，返回null
        if (head.next == null) {
            return null;
        }
        //第一次遍历得到链表的长度
        int size = getLength(head);
        //第二次遍历 size-index 的位置，倒数的第k个节点
        //对index进行校验
        if (index <= 0 || index > size) {
            return null;
        }
        //定义辅助变量
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 将单链表反转
     *
     * @param head
     * @return void
     **/
    public void reverseList(HeroNode head) {
        //如果链表为空，或者只有一个节点无需反转直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义辅助指针
        HeroNode temp = head.next;
        //指向当前节点的下一个节点
        HeroNode next = null;
        HeroNode reversHead = new HeroNode(0, "", "");

        //遍历原来的链表
        //每遍历一个节点,就将其取出,并放在新的链表reversHead的最前端
        while (temp != null) {
            //暂时保存当前节点的下一个节点
            next = temp.next;
            //将temp的下一个节点指向新的链表的最前端
            temp.next = reversHead.next;
            //将temp连接到新的链表上
            reversHead.next = temp;
            temp = next;
        }
        //将head.next指向reversHead.next
        head.next = reversHead.next;

    }

    /**
     * 使用栈进行单链表的逆序打印
     **/
    public void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        //创建一个栈，将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        //将链表的所有节点压入栈中
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        //将栈中的节点进行打印
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}

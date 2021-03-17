package hashtable;

import java.util.Scanner;

/**
 * @Author Halo
 * @Create 2021-03-14 下午 08:16
 * @Description
 */
public class HashtableDemo {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable(7);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("add");
            System.out.println("list");
            System.out.println("exit");
            switch (scanner.next()) {
                case "add":
                    System.out.print("  id:\t");
                    int id = scanner.nextInt();
                    System.out.print("name:\t");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashtable.add(emp);
                    break;
                case "list":
                    hashtable.list();
                    break;
                case "exit":
                    System.out.println("程序退出");
                    scanner.close();
                    flag = false;
                    break;
            }
        }
    }

    static class Hashtable {
        private EmpLinkedList[] empLinkedListArray;
        private int size;

        public Hashtable(int size) {
            this.size = size;
            empLinkedListArray = new EmpLinkedList[size];
            // 初始化每个链表
            for (int i = 0; i < size; i++) {
                empLinkedListArray[i] = new EmpLinkedList();
            }
        }

        // 添加
        public void add(Emp emp) {
            // 根据员工的ID得到该员工应该添加的链表
            int empLinkedListNO = hashFun(emp.id);
            empLinkedListArray[empLinkedListNO].add(emp);
        }

        // 遍历哈希表
        public void list() {
            for (int i = 0; i < size; i++) {
                empLinkedListArray[i].list(i);
            }
        }

        // 散列函数,简单的取模法
        public int hashFun(int id) {
            return id % size;
        }
    }

    static class Emp {
        public int id;
        public String name;
        public Emp next;

        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    static class EmpLinkedList {
        private Emp head;

        public void add(Emp emp) {
            if (head == null) {
                head = emp;
                return;
            }
            Emp curEmp = head;
            while (curEmp.next != null) {
                curEmp = curEmp.next;
            }
            curEmp.next = emp;
        }

        public void list(int no) {
            if (head == null) {
                System.out.println("第" + no + "链表为空");
                return;
            }
            Emp curEmp = head;
            while (true) {
                System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
                if (curEmp.next == null) {
                    break;
                }
                curEmp = curEmp.next;
            }
            System.out.println();
        }

    }


}

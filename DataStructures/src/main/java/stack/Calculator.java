package stack;

/**
 * @Author Halo
 * @Create 2021-03-10 下午 05:08
 * @Description 中缀表达式，使用栈，实现简单计算器 TODO Bug 做混合运算时, 计算乘除后，会从右到左计算加减
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "1-1*3+4";
        // 数栈
        CalculatorStack numberStack = new CalculatorStack(10);
        // 符号栈
        CalculatorStack operatorStack = new CalculatorStack(10);

        // 用于表达式的扫描
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int operator = 0;
        int res = 0;
        // 用于每次扫描的char的保存
        char ch = ' ';
        // 用于拼接多位数
        String keepNum = "";

        // 循环扫描expression
        do {
            // 得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断ch是什么
            if (operatorStack.isOperator(ch)) {
                // 如果是符号
                // 判断当前符号栈是否为空
                if (!operatorStack.isEmpty()) {
                    if (operatorStack.priority(ch) <= operatorStack.priority(operatorStack.check())) {
                        // 如果栈不为空
                        // 且当前操作符的优先级小于或等于栈中的操作符
                        // 1. 从数栈中pop出两个数
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        // 2. 从符号栈中pop出一个符号
                        operator = operatorStack.pop();
                        // 3. 进行计算
                        res = CalculatorStack.cal(num1, num2, operator);
                        // 4. 将结果push到数栈
                        numberStack.push(res);
                    }
                }
                // 如果符号栈为空
                // 如果当前操作符的优先级大于栈中的操作符
                // 5. 最后将当前的操作符push到符号栈
                operatorStack.push(ch);

            }
            else {
                // 如果是数，判断是否是多位数
                keepNum += ch;
                // 如果ch是表达式的最后一位直接入栈
                if (index == expression.length() - 1) {
                    numberStack.push(Integer.parseInt(keepNum));
                }
                else {
                    // 判断下一位数是否是数字，如果是则继续扫描，如果是运算符，则入栈
                    if (operatorStack.isOperator(expression.substring(index + 1, index + 2).charAt(0))) {
                        // 如果是运算符则入栈
                        numberStack.push(Integer.parseInt(keepNum));
                        // 清空keepNum
                        keepNum = "";
                    }
                }
            }
            // 让index+1，并判断是否扫描到expression最后
            index++;
        }
        while (index < expression.length());

        // 表达式扫描完毕,就顺序从数栈和符号栈中pop出相应的数和符号
        while (!operatorStack.isEmpty()) {
            // 1. 从数栈中pop出两个数
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            // 2. 从符号栈中pop出一个符号
            operator = operatorStack.pop();
            // 3. 进行计算
            res = CalculatorStack.cal(num1, num2, operator);
            numberStack.push(res);
        }
        System.out.printf("表达式 %s = %d", expression, numberStack.pop());

    }
}

class CalculatorStack extends ArrayStack {


    /**
     * 构造器
     *
     * @param maxSize 设置栈的大小
     */
    public CalculatorStack(int maxSize) {
        super(maxSize);
    }


    /**
     * 返回运算符的优先级
     *
     * @return 1 表示乘除，0 表示加减，其余为-1
     */
    public int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        }
        else if (operator == '+' || operator == '-') {
            return 0;
        }
        else {
            return -1;
        }
    }

    /**
     * 判断是否是操作符
     *
     * @param val 待判断值
     * @return ture 表示是操作符
     */
    public boolean isOperator(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算方法
     *
     * @param num1     栈中弹出的第一个值
     * @param num2     栈中弹出的第二个值
     * @param operator 符号栈中弹出的符号
     * @return 计算结果
     */
    public static int cal(int num1, int num2, int operator) {
        int res = 0;
        switch (operator) {
            case '+':
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }

}
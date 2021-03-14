package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author Halo
 * @Create 2021-03-10 下午 09:46
 * @Description 逆波兰表达式（后缀表达式）实现简单计算机
 */
class ReversePolishNotationCalculator {
    public static void main(String[] args) {
        // 定义一个逆波兰表达式
        // "(3+4)*5-6" => "3 4 + 5 * 6 - "

//        String suffixExpression = "3 4 + 5 * 6 - ";
//        String expression = "(30+4)*5-6";
        String expression = "1+((2+3)*4)-5";

        // 将中缀表达式转成对应的List
        List<String> infixExpressionStringList = toInfixExpressionList(expression);
        System.out.println("前缀表达式: \t" + infixExpressionStringList);
        // 将中缀表达式的List转成后缀表达式
        List<String> suffixExpressionStringList = parseSuffixExpressionList(infixExpressionStringList);
        System.out.println("后缀表达式: \t" + suffixExpressionStringList);

//        List<String> stringList1 = getStringList(suffixExpression, " ");
        int res = calculate(suffixExpressionStringList);
        System.out.println("计算结果: \t" + res);
    }

    /**
     * 将字符串转换成数组列表
     *
     * @param suffixExpression
     * @return
     */
    public static List<String> getStringList(String suffixExpression, String split) {
        // 将 suffixExpression 分割
        String[] temp = suffixExpression.split(split);
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, temp);
        return list;
    }

    /**
     * 将中缀表达式转成对应的List
     */
    public static List<String> toInfixExpressionList(String s) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        // 多位数拼接
        String str;
        char c;
        do {
            // 如果 c 非数字，加入到list
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add(c + "");
                i++;
            }
            else {
                // 如果是数需要考虑多位数
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                list.add(str);
            }
        }
        while (i < s.length());
        return list;
    }

    /**
     * 将中缀表达式的List转换成后缀表达式的List
     */
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        // 定义符号栈
        Stack<String> operatorStack = new Stack<>();
        // 定义一个List保存结果
        ArrayList<String> resultList = new ArrayList<>();

        // 遍历ls
        for (String item : ls) {
            if (item.matches("\\d+")) {
                // 如果是个数，加入resultList
                resultList.add(item);
            }
            else if (item.equals("(")) {
                // 如果是"("，入栈
                operatorStack.push(item);
            }
            else if (item.equals(")")) {
                // 如果是")",依次弹出operatorStack栈顶的运算符并压到resultList
                // 直到遇到左括号为止,并将这对括号舍去
                while (!operatorStack.peek().equals("(")) {
                    resultList.add(operatorStack.pop());
                }
                // 将"("弹出栈 (消除小括号)
                operatorStack.pop();
            }
            else {
                // 当item的优先级小于或等于 operatorStack 栈顶的运算符的优先级
                // 将operatorStack栈顶的运算符弹出并加入resultList,并重复向下比较
                while (operatorStack.size() != 0 && Operation.getValue(operatorStack.peek()) >= Operation.getValue(item)) {
                    resultList.add(operatorStack.pop());
                }
                operatorStack.push(item);
            }
        }

        // 将operatorStack剩余的值加入到resultList
        while (operatorStack.size() != 0) {
            resultList.add(operatorStack.pop());
        }

        return resultList;
    }


    /**
     * 计算后缀表达式结果
     *
     * @param list
     * @return
     */
    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            // 使用正则表达式取数
            if (s.matches("\\d+")) {
                // 匹配多位数
                stack.push(s);
            }
            else {
                //pop出两个数，并运算
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (s.equals("+")) {
                    res = num2 + num1;
                }
                else if (s.equals("-")) {
                    res = num2 - num1;
                }
                else if (s.equals("*")) {
                    res = num2 * num1;
                }
                else if (s.equals("/")) {
                    res = num2 / num1;
                }
                else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

/**
 * 比较运算优先级
 */
class Operation {
    private final static int ADD = 1;
    private final static int SUB = 1;
    private final static int MUL = 2;
    private final static int DIV = 2;

    // 返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }


}

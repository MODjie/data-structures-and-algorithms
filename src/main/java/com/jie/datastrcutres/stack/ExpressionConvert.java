package com.jie.datastrcutres.stack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * <p>
 * Title: ExpressionConvert
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月21日
 * @since 1.8
 */
public class ExpressionConvert {

    /**
     * 乘法操作符
     */
    private static final String MULTIPLY_OPERATOR = "*";
    /**
     * 除法操作符
     */
    private static final String DIVISION_OPERATOR = "/";
    /**
     * 左括号
     */
    private static final String LEFT_BRACKETS = "(";
    /**
     * 右括号
     */
    private static final String RIGHT_BRACKETS = ")";

    /**
     * <p>
     * Title: 将中缀表达式转换成后缀表达式（逆波兰表达式）
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param middleExpression
     * @return java.util.List<java.lang.String>
     * @author 刘小杰
     * @date 2021年11月21日
     * @since 1.8
     */
    public List<String> convertMiddleToSuffix(List<String> middleExpression){
        if (middleExpression == null || middleExpression.size() == 0){
            throw new RuntimeException("请输入中缀表达式");
        }
        Stack<String> operatorStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        for (String string : middleExpression) {
            //如果是数字，则压入结果栈中
            if (string.matches("\\d")){
                resultStack.push(string);
                continue;
            }
            //如果操作数栈是空的，或者操作数栈顶是左括号，或者当前字符串为左括号，则直接入栈
            if (operatorStack.isEmpty() || operatorStack.peek().equals(LEFT_BRACKETS) || LEFT_BRACKETS.equals(string)){
                operatorStack.push(string);
                continue;
            }
            //如果是右括号，则将操作栈栈顶元素压入数据栈中，直到碰到左括号，并且移除左括号
            if (RIGHT_BRACKETS.equals(string)){
                while (!operatorStack.isEmpty()){
                    String operatorTop = operatorStack.pop();
                    if (operatorTop.equals(LEFT_BRACKETS)){
                        break;
                    }
                    resultStack.push(operatorTop);
                }
                continue;
            }
            //如果是当前操作符的优先级小于等于操作栈栈顶元素的优先级，则需要循环遍历操作栈，将操作栈中的元素压入结果栈中，直到操作栈顶元素的优先级小于当前操作符，或操作栈为空，则将当前操作符压入操作栈
            while (true){
                if (operatorStack.isEmpty()){
                    operatorStack.push(string);
                    break;
                }
                String topValue = operatorStack.peek();
                int operatorTopValuePriority = this.getPriority(topValue);
                int currentStringPriority = this.getPriority(string);
                if (currentStringPriority > operatorTopValuePriority){
                    operatorStack.push(string);
                    break;
                }
                resultStack.push(operatorStack.pop());
            }
        }
        while (!operatorStack.isEmpty()){
            resultStack.push(operatorStack.pop());
        }
        return resultStack.stream().collect(Collectors.toList());
    }

    /**
     * <p>
     * Title: 获取操作符的优先级
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param operator 操作符
     * @return int
     * @author 刘小杰
     * @date 2021年11月21日
     * @since 1.8
     */
    private int getPriority(String operator) {
        if (operator.equals(MULTIPLY_OPERATOR)  || operator.equals(DIVISION_OPERATOR)){
            return 1;
        }
        return 0;
    }
}

package com.jie.datastrcutres.stack;

import java.util.Scanner;

/**
 * <p>
 * Title: 计算器
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月21日
 * @since 1.8
 */
public class Calculator {

    /**
     * 数据栈默认大小
     */
    private static final int DATA_DEFAULT_SIZE = 10;
    /**
     * 操作符栈默认大小
     */
    private static final int OPERATOR_DEFAULT_SIZE = 10;
    /**
     * 加法操作符
     */
    private static final String ADD_OPERATOR = "+";
    /**
     * 减法操作符
     */
    private static final String SUB_OPERATOR = "-";
    /**
     * 乘法操作符
     */
    private static final String MULTIPLY_OPERATOR = "*";
    /**
     * 除法操作符
     */
    private static final String DIVISION_OPERATOR = "/";

    /**
     * 数据栈
     */
    private ArrayStack<Integer> dataStack = new ArrayStack<>(DATA_DEFAULT_SIZE);
    /**
     * 操作符栈
     */
    private ArrayStack<String> operatorStack = new ArrayStack<>(OPERATOR_DEFAULT_SIZE);


    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要计算的数据");
        while(true){
            String input = scanner.next();
            if (input.equals("=")){
                int result = this.startCalculate();
                System.out.println("计算结果为"+result);
                break;
            }else if (input.equals("e")){
                System.out.println("退出计算器");
                break;
            }
            this.push(input);
        }
    }

    /**
     * <p>
     * Title: 入栈
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param input
     * @author 刘小杰
     * @date 2021年11月21日
     * @since 1.8
     */
    private void push(String input){
        //如果是操作符，操作符栈为空或者优先级小于等于栈顶的优先级，则入栈，否则数据栈弹出两个数字，计算后，再将当前操作符入栈
        if (isOperator(input)){
            if (this.operatorStack.isEmpty()){
                this.operatorStack.push(input);
                return;
            }
            String topOperator = this.operatorStack.pop();
            if (this.getPriority(input) >= this.getPriority(topOperator)){
                this.operatorStack.push(topOperator);
                this.operatorStack.push(input);
                return;
            }
            int num1 = this.dataStack.pop();
            int num2 = this.dataStack.pop();
            int result = this.calculate(num1,num2,topOperator);
            this.dataStack.push(result);
            this.operatorStack.push(input);
            return;
        }
        int value = this.getNumberData(input);
        if (value == -1){
            throw new RuntimeException("输入的操作符有误");
        }
        //是数字则直接入数据栈
        this.dataStack.push(value);
    }

    /**
     * <p>
     * Title: 开始计算
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @return int 计算结果
     * @author 刘小杰
     * @date 2021年11月21日
     * @since 1.8
     */
    private int startCalculate(){
        while(true){
            if (this.dataStack.getTop() == 0){
                break;
            }
            int num1 = this.dataStack.pop();
            int num2 = this.dataStack.pop();
            String operator = this.operatorStack.pop();
            int result = this.calculate(num1,num2,operator);
            this.dataStack.push(result);
        }
        return this.dataStack.pop();
    }

    /**
     * <p>
     * Title: 计算
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param num1 数据栈栈顶的元素
     * @param num2 数据栈第二个元素
     * @param topOperator
     * @return int
     * @author 刘小杰
     * @date 2021年11月21日
     * @since 1.8
     */
    private int calculate(int num1, int num2, String topOperator) {
        switch (topOperator){
            case ADD_OPERATOR:
                return num2 + num1;
            case SUB_OPERATOR:
                return num2 - num1;
            case MULTIPLY_OPERATOR:
                return num2 * num1;
            case DIVISION_OPERATOR:
                return num2 / num1;
            default:{
                throw new RuntimeException("当前操作符错误，请输入+，-，*，/");
            }
        }
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

    /**
     * <p>
     * Title: 获取数值
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param input 输入字符
     * @return int 不是数字是返回-1
     * @author 刘小杰
     * @date 2021年11月21日
     * @since 1.8
     */
    private int getNumberData(String input) {
        int value;
        try {
            value = Integer.valueOf(input);
        }catch (Exception e){
            value = -1;
        }
        return value;
    }

    /**
     * <p>
     * Title: 是否操作符
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param input 输入字符串
     * @return boolean
     * @author 刘小杰
     * @date 2021年11月21日
     * @since 1.8
     */
    private boolean isOperator(String input) {
        return input.equals(ADD_OPERATOR)  || input.equals(SUB_OPERATOR)|| input.equals(MULTIPLY_OPERATOR) || input.equals(DIVISION_OPERATOR);
    }

}

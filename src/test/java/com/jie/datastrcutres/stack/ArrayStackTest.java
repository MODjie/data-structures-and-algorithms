package com.jie.datastrcutres.stack;

/**
 * <p>
 * Title: 数组栈测试类
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月21日
 * @since 1.8
 */
public class ArrayStackTest {


    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        System.out.println(stack);
        System.out.println(stack.getTop());
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(50);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }

}

package com.jie.datastrcutres.stack;

import java.util.Arrays;

/**
 * <p>
 * Title: 数组栈
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月21日
 * @since 1.8
 */
public class ArrayStack<T> {

    /**
     * 最大尺寸
     */
    private int maxSize;

    /**
     * 数组
     */
    private Object [] elementArray;

    /**
     * 栈顶的位置
     */
    private int top = -1;


    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.elementArray = new Object[maxSize];
    }

    /**
     * <p>
     * Title: 获取栈顶元素
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @return int
     * @author 刘小杰
     * @date 2021年11月21日
     * @since 1.8
     */
    public T pop(){
        if (isEmpty()){
            throw new RuntimeException("当前栈是空的");
        }
        T element = (T) this.elementArray[top];
        this.elementArray[top] = null;
        top--;
        return element;
    }

    /**
     * <p>
     * Title: 添加数据入栈
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param data 数据元素
     * @author 刘小杰
     * @date 2021年11月21日
     * @since 1.8
     */
    public void push(T data){
        if (data == null){
            throw new RuntimeException("不允许传入空值");
        }
        if (isFull()){
            throw new RuntimeException("当前栈是满的");
        }
        top++;
        this.elementArray[top] = data;
    }

    /**
     * <p>
     * Title: 判断当前栈是否为空
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @return boolean
     * @author 刘小杰
     * @date 2021年11月21日
     * @since 1.8
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * <p>
     * Title: 判断当前栈是否满了
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @return boolean
     * @author 刘小杰
     * @date 2021年11月21日
     * @since 1.8
     */
    public boolean isFull(){
        return top == maxSize -1;
    }

    /**
     * <p>
     * Title: 获取栈顶的位置
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @return int
     * @author 刘小杰
     * @date 2021年11月21日
     * @since 1.8
     */
    public int getTop(){
        return this.top;
    }

    @Override
    public String toString() {
        if (isEmpty()){
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i <= top; i++) {
            Object currentElement = this.elementArray[i];
            stringBuilder.append(currentElement);
            if (i!=top){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}

package com.jie.practice;

/**
 * <p>
 * Title: 8皇后问题（用一维数组求解）
 * </p>
 * <p>
 * Description: 在一个8*8的棋盘中，两个皇后不能同行、同列、同一对角线
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月22日
 * @since 1.8
 */
public class Queen8 {
    private static final int MAX_SIZE = 8;

    private int [] array = new int[MAX_SIZE];

    private int answerNums;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("一共有"+queen8.answerNums+"钟解法");
    }

    /**
     * <p>
     * Title: check
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param currentQueenNum 当前皇后的个数
     * @author 刘小杰
     * @date 2021年11月22日
     * @since 1.8
     */
    private void check(int currentQueenNum){
        if (currentQueenNum == MAX_SIZE){
            answerNums++;
            this.print();
            return;
        }
        //遍历8列，寻找正确的落子点
        for (int i = 0; i < MAX_SIZE; i++) {
            array[currentQueenNum] = i;
            if (!this.judge(currentQueenNum)){
                continue;
            }
            check(currentQueenNum+1);
        }
    }

    /**
     * <p>
     * Title: 打印
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @author 刘小杰
     * @date 2021年11月22日
     * @since 1.8
     */
    private void print() {
        for (int i = 0; i < MAX_SIZE; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    /**
     * <p>
     * Title: 判断是否能落子
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param currentQueenNum
     * @return boolean
     * @author 刘小杰
     * @date 2021年11月22日
     * @since 1.8
     */
    private boolean judge(int currentQueenNum) {
        for (int i = 0; i < currentQueenNum; i++) {
            if (array[currentQueenNum] == array[i] || (currentQueenNum-i) == Math.abs(array[currentQueenNum] - array[i])){
                return false;
            }
        }
        return true;
    }

}

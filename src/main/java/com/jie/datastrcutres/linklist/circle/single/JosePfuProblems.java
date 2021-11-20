package com.jie.datastrcutres.linklist.circle.single;

/**
 * <p>
 * Title: 约瑟夫问题
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月20日
 * @since 1.8
 */
public class JosePfuProblems {

    public static void main(String[] args) {
        CircleSingleLinkList<Integer> children = new CircleSingleLinkList<>();
        for (int i = 1; i < 6; i++) {
            children.add(i);
        }
        System.out.println(children);
        children.update(100,4);
        System.out.println(children);
        children.delete(2);
        System.out.println(children);
        System.out.println(children.get(0));
    }

}

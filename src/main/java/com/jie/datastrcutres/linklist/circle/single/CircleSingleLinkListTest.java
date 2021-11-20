package com.jie.datastrcutres.linklist.circle.single;

import java.util.LinkedList;

/**
 * <p>
 * Title: CircleSingleLinkListTest
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月21日
 * @since 1.8
 */
public class CircleSingleLinkListTest {

    public static void main(String[] args) {
        CircleSingleLinkList<Integer> children = new CircleSingleLinkList<>();
        for (int i = 1; i < 6; i++) {
            children.add(i);
        }
        System.out.println(children);
        children.update(100,4);
        System.out.println(children);
        children.remove(2);
        System.out.println(children);
        System.out.println(children.get(0));

    }
}

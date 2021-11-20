package com.jie.datastrcutres.linklist.circle.single;

import java.util.ArrayList;
import java.util.List;

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
        /*CircleSingleLinkList<Integer> children = new CircleSingleLinkList<>();
        for (int i = 1; i < 11; i++) {
            children.add(i);
        }
        int countNum = 3;
        int currentCount = 1;
        List<Node<Integer>> result = new ArrayList<>();
        Node<Integer> cursorLeft = children.get(children.getSize()-1);
        Node<Integer> cursorRight = children.getFirst();
        while (!children.isEmpty()){
            if (currentCount!=countNum){
                cursorLeft = cursorLeft.getNext();
                cursorRight = cursorRight.getNext();
                currentCount++;
                continue;
            }
            cursorLeft.setNext(cursorRight.getNext());
            children.setSize(children.getSize()-1);
            result.add(cursorRight);
            if (children.getSize() ==0){
                children.clear();
            }
            cursorRight = cursorRight.getNext();
            currentCount = 1;
        }
        System.out.println(result);*/
    }

}

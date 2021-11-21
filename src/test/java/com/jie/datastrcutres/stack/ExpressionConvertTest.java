package com.jie.datastrcutres.stack;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Title: 表达式转换测试类
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author <刘小杰>
 * @date 2021年11月21日
 * @since 1.8
 */
public class ExpressionConvertTest {

    public static void main(String[] args) {
        ExpressionConvert expressionConvert = new ExpressionConvert();
        String middleExpression = "1 + ( ( 2 + 3 ) * 4 ) - 5";
//        String middleExpression = "1 + 2 * 3";
        List<String> source = Arrays.asList(middleExpression.split(" "));
        List<String> result = expressionConvert.convertMiddleToSuffix(source);
        System.out.println(result);
    }

}

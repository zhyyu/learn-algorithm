package com.zhyyu.learn.algorithm.chapter1;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhongyu.yzy
 * @date 2020/12/16
 */
public class DijkstraDoubleStackCalVal_1_3_1 {

    public static void main(String[] args) {
        String expression = "( 2 * ( 2 + 3 ) )";
        String[] symbolArr = expression.split(" ");
        System.out.println(Arrays.asList(symbolArr));

        Stack<String> valStack = new Stack<String>();
        Stack<String> opStack = new Stack<String>();

        for (String symbol : symbolArr) {
            if (symbol.equals("(")) {

            }

            if (symbol.equals("*") || symbol.equals("+")) {
                opStack.push(symbol);
            }

            if (StringUtils.isNumeric(symbol)) {
                valStack.push(symbol);
            }

            if (symbol.equals(")")) {
                String firstValue = valStack.pop();
                String secondValue = valStack.pop();
                String op = opStack.pop();
                if (op.equals("+")) {
                    int result = Integer.parseInt(firstValue) + Integer.parseInt(secondValue);
                    valStack.push(result + "");
                }

                if (op.equals("*")) {
                    int result = Integer.parseInt(firstValue) * Integer.parseInt(secondValue);
                    valStack.push(result + "");
                }
            }
        }

        System.out.println(valStack);
    }

}

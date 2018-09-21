package com.example.achan.calculator;

import android.support.v4.content.res.TypedArrayUtils;
/*
public class Test
{
    private static void push(Integer insert, Integer[] stack)
    {
        for(int i =0; i < stack.length;i++)
        {
            if(stack[i] == null)
            {
                stack[i] = insert;
                return;
            }
        }
    }
    private static Integer stackPop(Integer[] stack)
    {
        if(stack[1] == null)
        {
            Integer temp = stack[0];
            stack[0] = null;
            return temp;
        }
        for(int i = 0; i < stack.length; i ++)
        {
            if(stack[i + 1] == null)
            {
                Integer temp =stack[i];
                stack[i] = null;
                return temp;
            }
        }
        return 1;
    }
    private static Integer eval(Character[] postFix)
    {
        Integer[] stack = new Integer[50];
        Integer num1;
        Integer num2;
        Integer result;
        while(stackPeek(postFix) != null)
        {
            Character current = queuePop(postFix);
            if(Character.isDigit(current))
            {
                push((current - '0'), stack);
            }
            else if(current == '+')
            {
                num1 = stackPop(stack);
                num2 = stackPop(stack);
                result = num1 + num2;
                push(result, stack);
            }
            else if(current == '-')
            {
                num1 = stackPop(stack);
                num2 = stackPop(stack);
                result = num1 - num2;
                push(result, stack);
            }
            else if(current == '/')
            {
                num1 = stackPop(stack);
                num2 = stackPop(stack);
                result = num1 / num2;
                push(result, stack);
            }
            else
            {
                num1 = stackPop(stack);
                num2 = stackPop(stack);
                result = num1 * num2;
                push(result, stack);
            }
        }
        return stackPop(stack);
    }
    private static void printArr(String[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            if(a[i] == null)
                return;
            System.out.println(a[i]);
        }
    }
    private static Character stackPop(Character [] stack)
    {
        if(stack[1] == null)
        {
            Character temp = stack[0];
            stack[0] = null;
            return temp;
        }
        for(int i = 0; i < stack.length; i++)
        {
            if(i == stack.length - 1 || stack[i + 1] == null) {
                Character temp = stack[i];
                stack[i] = null;
                return temp;
            }
        }
        return 'f';
    }
    private static Character queuePop(Character[] queue)
    {
        Character retChar = queue[0];
        int i = 0;
        while(queue[i] != null)
        {
            queue[i] = queue[i + 1];
            if(queue[i + 1] == null)
                return retChar;
            i++;
        }
        return retChar;
    }
    private static void push(Character insert, Character[] a)
    {
        for(int i = 0; i < a.length; i ++)
        {
            if(a[i] == null)
            {
                a[i] = insert;
                return;
            }
        }
    }
    private static Character stackPeek(Character[] stack)
    {
        if(stack[1] == null)
            return stack[0];
        else
        {
            for(int i =0; i < stack.length; i ++)
            {
                if(stack[i + 1] == null)
                {
                    return stack[i];
                }
            }
        }
        return 'f';
    }
    public static void main(String [] args)
    {
        String[] operatorStack = new String[50];
        String[] outputQueue = new String[50];
        String expression = "6 * ( 7 + 3 * 9 )";
        String [] tokenized = expression.split(" ");
        for(int i = 0 ;i < tokenized.length; i++)
        {
            String current = tokenized[i];
            if(current == "(")
            {
                push(current, operatorStack);
            }
            else if(current == ")")
            {
                Character next = stackPop(operatorStack);
                while(next != '(')
                {
                    push(next, outputQueue);
                    next = stackPop(operatorStack);
                }
            }
            else {
                if (current == '*' || current == '/') {
                    push(current, operatorStack);
                } else {
                    while (stackPeek(operatorStack) == '*' || stackPeek(operatorStack) == '/') {
                        push(stackPop(operatorStack), outputQueue);
                    }
                    push(current, operatorStack);
                }
            }
        }
        while(stackPeek(operatorStack) != null)
        {
            push(stackPop(operatorStack),outputQueue);
        }
        System.out.println(eval(outputQueue));
    }
}
*/
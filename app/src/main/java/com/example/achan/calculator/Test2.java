package com.example.achan.calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test2
{
    private static Queue<String> inToPost(String expr)
    {
        String [] tokenized =  expr.split(" ");
        Stack<String> opStack = new Stack();
        Queue<String> outQueue = new LinkedList();
        for(int i = 0 ; i < tokenized.length; i ++)
        {
            String current = tokenized[i];
            if(current.equals("("))
            {
                opStack.push("(");
            }
            else if(current.equals(")"))
            {
                String top = opStack.pop();
                while(top != "(")
                {
                    outQueue.add(top);
                    top = opStack.pop();
                }
            }
            else if(current.equals("+") || current.equals("-"))
            {
                if (opStack.empty() == false)
                {
                    while (opStack.peek().equals("*") || opStack.peek().equals("/"))
                    {
                        outQueue.add(opStack.pop());
                        if(opStack.empty())
                            break;
                    }
                }
                opStack.push(current);
            }
            else if(current.equals("*") || current.equals("/"))
            {
                opStack.push(current);
            }
            else
            {
                outQueue.add(current);
            }
        }
        while(opStack.isEmpty() == false)
        {
            outQueue.add(opStack.pop());
        }
        return outQueue;
    }
    private static Double eval(Queue<String> postFix)
    {
        Stack<Double> finalStack = new Stack();
        while(postFix.peek() !=null)
        {
            String current = postFix.remove();
            Double num1, num2, result;
            if(current.equals("+"))
            {
                num1 = finalStack.pop();
                num2 = finalStack.pop();
                result = num1 + num2;
                finalStack.push(result);
            }
            else if(current.equals("-"))
            {
                num1 = finalStack.pop();
                num2 = finalStack.pop();
                result = num2 - num1;
                finalStack.push(result);
            }
            else if(current.equals("*"))
            {
                num1 = finalStack.pop();
                num2 = finalStack.pop();
                result = num1 * num2;
                finalStack.push(result);
            }
            else if(current.equals("/"))
            {
                num1 = finalStack.pop();
                num2 = finalStack.pop();
                result = num2 / num1;
                finalStack.push(result);
            }
            else
            {
                Double insert = Double.parseDouble(current);
                finalStack.push(insert);
            }
        }
        return finalStack.pop();
    }
    public static void main(String [] args)
    {
        String test = "( 3 + 6 ) * 9";
        Queue<String> tempQueue = inToPost(test);
        Double result = eval(tempQueue);
        System.out.println(tempQueue.toString());
        System.out.println(result);
    }
}

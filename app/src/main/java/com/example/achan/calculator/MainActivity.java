package com.example.achan.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity
{
    private Button zeroBtn;
    private Button oneBtn;
    private Button twoBtn;
    private Button threeBtn;
    private Button fourBtn;
    private Button fiveBtn;
    private Button sixBtn;
    private Button sevenBtn;
    private Button eightBtn;
    private Button nineBtn;
    private Button multBtn;
    private Button divBtn;
    private Button minusBtn;
    private Button plusBtn;
    private Button equalsBtn;
    private Button clearBtn;
    private Button parBtn;
    private boolean leftPar = false;
    private TextView info;
    private TextView result;
    private boolean reset = false;

    private void setUpButtons()
    {
        zeroBtn = findViewById(R.id.zeroBtn);
        oneBtn = findViewById(R.id.oneBtn);
        twoBtn = findViewById(R.id.twoBtn);
        threeBtn = findViewById(R.id.threeBtn);
        fourBtn = findViewById(R.id.fourBtn);
        fiveBtn = findViewById(R.id.fiveBtn);
        sixBtn = findViewById(R.id.sixBtn);
        sevenBtn = findViewById(R.id.sevenBtn);
        eightBtn = findViewById(R.id.eightBtn);
        nineBtn = findViewById(R.id.nineBtn);
        multBtn = findViewById(R.id.multBtn);
        divBtn = findViewById(R.id.divBtn);
        minusBtn = findViewById(R.id.minusBtn);
        plusBtn = findViewById(R.id.plusBtn);
        equalsBtn = findViewById(R.id.equalsBtn);
        clearBtn = findViewById(R.id.clearBtn);
        parBtn = findViewById(R.id.parBtn);
        info = findViewById(R.id.info);
        result = findViewById(R.id.result);

    }
    //Shunting-yard alghorithm
    private static Queue<String> inToPost(String expr)
    {
        //tokenize the string using spaces as delimiters
        String [] tokenized =  expr.split(" ");
        Stack<String> opStack = new Stack<>();
        Queue<String> outQueue = new LinkedList<>();
        for(int i = 0 ; i < tokenized.length; i ++)
        {
            String current = tokenized[i];
            //if token = left par add to operator stack
            if(current.equals("("))
            {
                opStack.push("(");
            }
            //if token = right par pop operators, giving higher precedence to operators between parenthesis
            else if(current.equals(")"))
            {
                String top = opStack.pop();
                while(top != "(")
                {
                    outQueue.add(top);
                    top = opStack.pop();
                }
            }
            //if token = +/- pop operators that have higher precedence to preserve PEMDAS
            else if(current.equals("+") || current.equals("-"))
            {
                if (!opStack.empty())
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
            //if token = * or / just push onto operator stack
            else if(current.equals("*") || current.equals("/"))
            {
                opStack.push(current);
            }
            //token is a number, just add to output queue
            else
            {
                outQueue.add(current);
            }
        }
        //pop remaining operators onto output queue
        while(!opStack.isEmpty())
        {
            outQueue.add(opStack.pop());
        }
        return outQueue;
    }
    //evaluates the postfix expression in the form of a queue and returns result as double
    private static Double eval(Queue<String> postFix)
    {
        Stack<Double> finalStack = new Stack<>();
        while(postFix.peek() !=null)
        {
            String current = postFix.remove();
            Double num1, num2, result;
            //if token is an operator, pop two nums and do corresponding operation on them
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
                result = num2 - num1; //num 2 comes first because order matters in subtraction
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
            //token is not an operator, so convert to double and push onto finalStack
            else
            {
                Double insert = Double.parseDouble(current);
                finalStack.push(insert);
            }
        }
        //last remaining item in the stack is the result
        return finalStack.pop();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpButtons();

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //if an expression has already been evaluated (reset = true) and user enters another number
                //straight after, then reset the info to  represent the start of new expression
                if(reset)
                {
                    info.setText("");
                    reset = false;
                }
                info.setText(info.getText().toString() + "0");
            }
        });
        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(reset)
                {
                    info.setText("");
                    reset = false;
                }
                info.setText(info.getText().toString() + "1");
            }
        });
        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(reset)
                {
                    info.setText("");
                    reset = false;
                }
                info.setText(info.getText().toString() + "2");
            }
        });
        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(reset)
                {
                    info.setText("");
                    reset = false;
                }
                info.setText(info.getText().toString() + "3");
            }
        });
        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(reset)
                {
                    info.setText("");
                    reset = false;
                }
                info.setText(info.getText().toString() + "4");
            }
        });
        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(reset)
                {
                    info.setText("");
                    reset = false;
                }
                info.setText(info.getText().toString() + "5");
            }
        });
        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(reset)
                {
                    info.setText("");
                    reset = false;
                }
                info.setText(info.getText().toString() + "6");
            }
        });
        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(reset)
                {
                    info.setText("");
                    reset = false;
                }
                info.setText(info.getText().toString() + "7");
            }
        });
        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(reset)
                {
                    info.setText("");
                    reset = false;
                }
                info.setText(info.getText().toString() + "8");
            }
        });
        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(reset)
                {
                    info.setText("");
                    reset = false;
                }
                info.setText(info.getText().toString() + "9");
            }
        });
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String current = info.getText().toString();
                if(reset)
                {
                    //if user presses / right after evaluating another expression (reset = true), use the
                    //previous answer
                    String ans = result.getText().toString();
                    info.setText(ans + " / ");
                    reset = false;
                }
                else
                {
                    //if user attempts to presses / while info is empty and reset = false, program won't crash
                    // from current.length() - 1 and nothing happens
                    try
                    {
                        //When operators or parenthesis are pressed they add spaces to the textView string so that
                        //the string can be tokenized using spaces later.
                        if (current.substring(current.length() - 1).equals(" "))
                            info.setText(current + "/ ");
                        else
                            info.setText(current + " / ");
                    }
                    catch(Exception e){}
                }
            }
        });
        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String current = info.getText().toString();
                if(reset)
                {
                    String ans = result.getText().toString();
                    info.setText(ans + " * ");
                    reset = false;
                }
                else
                {
                    try
                    {
                        if (current.substring(current.length() - 1).equals(" "))
                            info.setText(current + "* ");
                        else
                            info.setText(current + " * ");
                    }
                    catch(Exception e){}
                }
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String current = info.getText().toString();
                if(reset)
                {
                    String ans = result.getText().toString();
                    info.setText(ans + " - ");
                    reset = false;
                }
                else
                {
                    try
                    {
                        if (current.substring(current.length() - 1).equals(" "))
                            info.setText(current + "- ");
                        else
                            info.setText(current + " - ");
                    }
                    catch(Exception e){}
                }
            }
        });
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String current = info.getText().toString();
                if(reset)
                {
                    String ans = result.getText().toString();
                    info.setText(ans + " + ");
                    reset = false;
                }
                else
                {
                    try
                    {
                        if (current.substring(current.length() - 1).equals(" "))
                            info.setText(current + "+ ");
                        else
                            info.setText(current + " + ");
                    }
                    catch(Exception e){}
                }
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                info.setText("");
            }
        });
        parBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String current = info.getText().toString();
                //even number of left and right par
                if(leftPar == false)
                {
                    if(reset)
                    {
                        info.setText("");
                        reset = false;
                    }
                    //if string is empty, second condition won't execute/program wont crash
                    if(info.getText().toString().equals ("") || current.substring(current.length()-1).equals(" "))
                        info.setText(current + "( ");
                    else
                        info.setText(current + " ( ");
                    //set leftPar to true so next time they press par, right par will appear
                    leftPar = true;
                }
                //leftPar without a matching rightPar
                else
                {
                    if(current.substring(current.length()-1).equals(" "))
                        info.setText(current + ") ");
                    else
                        info.setText(current + " ) ");
                    leftPar = false;
                }
            }
        });
        equalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


                //if user accidentally presses = multiple times, program wont crash
                try
                {
                    //take textView string, transform to postfix, then evaluate it, then display it
                    String expression = info.getText().toString();
                    Queue<String> temp = inToPost(expression);
                    Double finalResult = eval(temp);
                    result.setText(Double.toString(finalResult));
                    reset = true;
                }
                catch(Exception e){}
            }
        });
    }
}

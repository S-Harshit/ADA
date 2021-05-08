package com.company;

import java.util.*;
class permuation {


    public static long multiplyNumbers(int num)
    {
        if (num >= 1)
            return num * multiplyNumbers(num - 1);
        else
            return 1;
    }
    void method(String arr,int l) {
        char[] ch = new char[arr.length()];
        int j = l-1;
        int k = 0;
        int count =0 ;
        int swapp = 0;
        long times = multiplyNumbers(l);

        for (int i = 0; i < arr.length(); i++) {
            ch[i] = arr.charAt(i);
        }


                for (int i = 0; i < times; i++) {
                    for (char c : ch) {
                        System.out.print(c);
                    }
                    count +=  1;
                    if (j > 0 && swapp != times) {
                        ch = swap(ch, j);
                        swapp++;
                        j--;

                    }
                    else {
                        if(swapp != times) {
                            j=l-1;
                            ch = swap(ch, j);
                            swapp++;
                            j--;
                        }
                       else {
                           ch = swap (ch,j);
                        }

                    }
                    System.out.println();
                   // count = count + 1;
                }


        System.out.println(count);


    }

    char[] swap(char ch[],int length) {
        char a = ch[length];
        char b = ch[length-1];
        ch[length-1] = a;
        ch[length] = b;
        return ch;
    }
}


public class Possiblechars
{
    public static void main(String[] args) {
        String arr = "abcd";
        int l = arr.length();
        permuation obj = new permuation();
        obj.method(arr,l);
    }

}

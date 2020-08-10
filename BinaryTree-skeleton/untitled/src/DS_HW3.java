import java.util.Stack;
import java.util.Scanner;
//import java.lang.Object;

public class DS_HW3 {
    Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = new char[100];
        while (true) {
            String str = sc.nextLine();
            chars = str.toCharArray();
            System.out.println(parentheses(chars));
        }
    }

    public static int parentheses(char[] chrs)
    {
        Stack s = new Stack();
        int position = -1;

        for(int i=0; i<chrs.length; i++)
        {
            char c = chrs[i];

            if(c == '(')
            {
                if(s.empty()) position = i; //position 0일 때
                //code start
                s.push(c);
                //code end
            }
            else
            {
                //code start
                if(s.empty())
                {
                    position = i;
                    return position;
                }
                else
                {
                    s.pop();
                     if(s.empty())  position = -1;
                }
                //code end
            }
        }
        return position;
    }
}


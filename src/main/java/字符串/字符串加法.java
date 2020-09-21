package 字符串;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class 字符串加法 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int jw = 0;
        int flag = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int tmp1 = 0;
            int tmp2 = 0;
            if (i >= 0) {
                // tmp1 = Integer.parseInt(String.valueOf(num1.charAt(flag)));
                //妙啊  用char减去0的char,那么就是数字了
                tmp1 = num1.charAt(i) - '0';
            }
            if (j >= 0) {
                tmp2 = num2.charAt(j) - '0';
            }
            int sum = tmp1 + tmp2 + jw;
            jw = sum / 10;
            result.append(sum % 10);
            flag++;
            i--;
            j--;
        }
        if (jw > 0) {
            result.append(jw);
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        char l = "123".charAt(0);
        int s = Integer.parseInt(String.valueOf(l));
        System.out.println(s);
//
//        String r = new 字符串加法().addStrings("0", "0");
//        System.out.println(r);
    }
}

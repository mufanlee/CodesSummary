import java.util.ArrayList;
import java.util.List;

/**
 * 640. Solve the Equation
 * @author LiPeng
 * @since 2017/7/921:17
 */
public class SolvetheEquation {
    // 转换nx为n
    public String coeff(String x) {
        if (x.length() > 1 && x.charAt(x.length() - 2) >= '0' && x.charAt(x.length() - 2) <= '9') {
            return x.replace("x", "");
        }
        return x.replace("x", "1");
    }
    public String solveEquation(String equation) {
        String []lr = equation.split("=");
        int lhs = 0, rhs = 0;
        for (String x : breakIt(lr[0])) {
            if (x.indexOf("x") >= 0) {
                lhs += Integer.parseInt(coeff(x));
            } else {
                rhs -= Integer.parseInt(x);
            }
        }
        for (String x : breakIt(lr[1])) {
            if (x.indexOf("x") >= 0) {
                lhs -= Integer.parseInt(coeff(x));
            } else {
                rhs += Integer.parseInt(x);
            }
        }
        if (lhs == 0) {
            if (rhs == 0)
                return "Infinite solutions";
            else
                return "No solution";
        }
        return "x=" + rhs / lhs;
    }
    // 将方程式以+/-分成几部分
    public List<String> breakIt(String s) {
        List<String> res = new ArrayList<>();
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (r.length() > 0) {
                    res.add(r);
                }
                r = "" + s.charAt(i);
            } else {
                r += s.charAt(i);
            }
        }
        res.add(r);
        return res;
    }


    public String solveEquation2(String equation) {
        String []lr = equation.split("=");
        int lhs = 0, rhs = 0;
        for (String x : lr[0].split("(?=\\+)|(?=-)")) {
            if (x.indexOf("x") >= 0) {
                lhs += Integer.parseInt(coeff(x));
            } else {
                rhs -= Integer.parseInt(x);
            }
        }
        for (String x : lr[1].split("(?=\\+)|(?=-)")) {
            if (x.indexOf("x") >= 0) {
                lhs -= Integer.parseInt(coeff(x));
            } else {
                rhs += Integer.parseInt(x);
            }
        }
        if (lhs == 0) {
            if (rhs == 0)
                return "Infinite solutions";
            else
                return "No solution";
        }
        return "x=" + rhs / lhs;
    }
}

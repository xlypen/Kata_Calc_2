abstract class Calculate {
    public abstract String sum(StringBuilder a, StringBuilder b) throws NullPointerException;
    public abstract String sub(StringBuilder a, StringBuilder b);
    public abstract String mul(StringBuilder a, int b);
    public abstract String div(StringBuilder a, int b);
}
class Calc extends Calculate {
    StringBuilder result = new StringBuilder("\"");
    public String sum(StringBuilder a, StringBuilder b) throws NullPointerException {
        if (a.indexOf("\"") != -1 && a.indexOf("\"", a.length() - 1) != -1 && b.indexOf("\"") != -1 && b.indexOf("\"", b.length() - 1) != -1) {
            a.deleteCharAt(0).deleteCharAt(a.length() - 1);
            b.deleteCharAt(0).deleteCharAt(b.length() - 1);
            return result.append(a).append(b).append("\"").toString();
        } else {
            throw new NullPointerException("Вы ввели неправильное выражение");
        }
    }

    public String sub(StringBuilder a, StringBuilder b) {
        if (a.indexOf("\"") != -1 && a.indexOf("\"", a.length() - 1) != -1 && b.indexOf("\"") != -1 && b.indexOf("\"", b.length() - 1) != -1) {
            a.deleteCharAt(0).deleteCharAt(a.length() - 1);
            b.deleteCharAt(0).deleteCharAt(b.length() - 1);
            switch (a.indexOf(String.valueOf(b))){
                case 0:
                    a.delete(a.indexOf(b.toString()), a.indexOf(b.toString()) + b.length());
                    return result.append(a).append("\"").toString();
                case -1:
                    return result.append(a).append("\"").toString();}
        } else {
            throw new NullPointerException("Вы ввели неправильное выражение");
        }
        a.delete(a.indexOf(b.toString()), a.indexOf(b.toString()) + b.length());
        return result.append(a).append("\"").toString();
    }

    public String mul(StringBuilder a, int b) {
        if (a.indexOf("\"") != -1 && a.indexOf("\"", a.length() - 1) != -1 && b <= 10) {
            a.deleteCharAt(0).deleteCharAt(a.length() - 1);
            String newString = a.toString();

            a.append(newString.repeat(b - 1));
            return result.append(a).append("\"").toString();
        } else {
            throw new NullPointerException("Вы ввели неправильное выражение");
        }
    }

    public String div(StringBuilder a, int b) {
        int c = (a.length()-1)/b;
        if (a.indexOf("\"") != -1 && a.indexOf("\"", a.length() - 1) != -1 && b <= 10) {
            a.deleteCharAt(0).deleteCharAt(a.length() - 1);
            a.delete(c, a.length());
            return result.append(a).append("\"").toString();
        } else {
            throw new NullPointerException("Вы ввели неправильное выражение");
        }
    }
}

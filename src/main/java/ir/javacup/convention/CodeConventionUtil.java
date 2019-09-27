package ir.javacup.convention;

public class CodeConventionUtil {

    public String getFieldsName(String... params) {
        StringBuilder name = new StringBuilder("");
        for (String string : params) {
            name.append(Character.toUpperCase(string.charAt(0)));
            name.append(string.substring(1).toLowerCase());
        }
        name.setCharAt(0, Character.toLowerCase(name.charAt(0)));
        return name.toString();
    }

    public String getMethodsName(String... params) {
        StringBuilder name = new StringBuilder("");
        for (String string : params) {
            name.append(Character.toUpperCase(string.charAt(0)));
            name.append(string.substring(1).toLowerCase());
        }
        name.setCharAt(0, Character.toLowerCase(name.charAt(0)));
        return name.toString();
    }

    public String getClassName(String... params) {
        StringBuilder name = new StringBuilder("");
        for (String string : params) {
            name.append(Character.toUpperCase(string.charAt(0)));
            name.append(string.substring(1).toLowerCase());
        }
        return name.toString();
    }

    public String getConstantsName(String... params) {
        StringBuilder name = new StringBuilder("");
        for (String string : params) {
            name.append(string.toUpperCase());
            name.append("_");
        }
        name.deleteCharAt(name.length() - 1);
        return name.toString();
    }
}

package ir.javacup.reflection;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Copier {
    private String[] fields;

    public Copier() {
    }

    public Copier(String... fields) {
        this.fields = fields;
    }

    public void copy(Object o1, Object o2) {
        if (fields == null) {
            for (Field f : o1.getClass().getDeclaredFields()) {
                String name = Character.toUpperCase(f.getName().charAt(0)) + f.getName().substring(1);
                System.out.println(name);
                try {
                    Method method = o1.getClass().getMethod("get" + name);
                    o2.getClass().getMethod("set" + name, method.getReturnType()).invoke(o2, method.invoke(o1));
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } else {
            for (String field : fields) {
                for (Field f : o1.getClass().getDeclaredFields()) {
                    if (f.getName().equals(field)) {
                        String name = Character.toUpperCase(f.getName().charAt(0)) + f.getName().substring(1);
                        try {
                            Method method = o1.getClass().getMethod("get" + name);
                            o2.getClass().getMethod("set" + name, method.getReturnType()).invoke(o2, method.invoke(o1));
                        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

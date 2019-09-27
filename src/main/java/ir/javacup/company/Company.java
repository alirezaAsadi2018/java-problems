package ir.javacup.company;

public class Company {
    private static Company instance;
    private final String name;

    private Company() throws Exception {
        if (instance != null)
            throw new Exception();
        name = "JavaCup.co";
    }

    public static Company getInstance() {
        if (instance == null) {
            try {
                instance = new Company();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }


    public String getName() {
        return name;
    }
}
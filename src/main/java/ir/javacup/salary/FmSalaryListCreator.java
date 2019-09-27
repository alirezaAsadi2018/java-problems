package ir.javacup.salary;

public class FmSalaryListCreator extends SalaryListCreator {
    public FmSalaryListCreator(Encoder encoder) {
        super(encoder);
    }

    @Override
    protected String doCreate(Employee[] employees) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            String salary = String.valueOf(employee.getSalary());
            if(salary.length() < 10) {
                string.append(addZeroPrefix(salary, 10));
            }else {
                string.append(salary);
            }
            string.append(getItemSeparator());
            if(employee.getCode().length() < 10) {
                string.append(addZeroPrefix(employee.getCode(), 10));
            }else {
                string.append(employee.getCode());
            }
            if(i != employees.length - 1)
                string.append(getRecordSeparator());
        }
        return string.toString();
    }
}

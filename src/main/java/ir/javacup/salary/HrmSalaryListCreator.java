package ir.javacup.salary;

public class HrmSalaryListCreator extends SalaryListCreator {
    public HrmSalaryListCreator(Encoder encoder) {
        super(encoder);
    }

    @Override
    protected String doCreate(Employee[] employees) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if(employee.getCode().length() < 8) {
                string.append(addZeroPrefix(employee.getCode(), 8));
            }else {
                string.append(employee.getCode());
            }
            string.append(getItemSeparator());
            String salary = String.valueOf(employee.getSalary());
            if(salary.length() < 10) {
                string.append(addZeroPrefix(salary, 10));
            }else {
                string.append(salary);
            }
            if(i != employees.length - 1)
                string.append(getRecordSeparator());
        }
        return string.toString();
    }
}

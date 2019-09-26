class Employee {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    Employee(String fio, String position, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    int getAge() {
        return age;
    }

    void Presentation() {
        System.out.println(fio + ", " + position + ", " + email + ", " + phone + ", " + salary + ", " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employeeAray = new Employee[5];
        employeeAray[0] = new Employee("Serj", "tester", "serj@mailbox.com", "+79251234578", 40000, 27);
        employeeAray[1] = new Employee("Maks", "tester", "maks@mailbox.com", "+79251234579", 40000, 26);
        employeeAray[2] = new Employee("Andrew", "analyst", "andrew@mailbox.com", "+79251234580", 80000, 42);
        employeeAray[3] = new Employee("Antonio", "developer", "antonio@mailbox.com", "+79251234585", 80000, 45);
        employeeAray[4] = new Employee("Paul", "lead tester", "paul@mailbox.com", "+79251234590", 50000, 32);
        for (Employee item : employeeAray) {
            if (item.getAge() > 40) {
                item.Presentation();
            }
        }
    }
}
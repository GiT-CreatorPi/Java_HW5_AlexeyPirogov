//Дисциплина: Java.Уровень 1
//Домашнее задание №: 5 "Введение в ООП"
//Студент: Алексей Пирогов
//Дата: 12.04.2021

//Класс Employer объявляет пользовательский тип данных, описывающий сущность сотрудник в виде набора атрибутов и методов

import java.util.Scanner;

class Employer {
    //пример использования разных модификаторов доступа к полям класса для разных атрибутов соответсвующих сущности сотрудник:
    static private int countEmployer; //Employer.countEmployer = 100;  //будет доступна в main при public
    private int idEmployer;         //Идентификатор пользователя, счётчик для подсчёта объектов класса Employer
    private int statusWork;         //Cтатус: 0 - уволен, 1 - работает, 2 - находится на больничном, 3 - находится в декрете
    private String firstName;       //Имя
    private String lastName;        //Фамилия
    private String middleName;      //Отчёство
    private int age;                //День рождения
    private String otdel;           //Отдел
    private String post;            //Должность
    private String workPhone;       //Номер рабочего телефона
    private String workEmail;       //Электронная почта
    private float pay;              //Оплата
    public static Scanner in = new Scanner(System.in);

    //Модификаторы доступа:
    // public - публичный, общедоступный класс или член класса. Поля и методы, объявленные с модификатором publc,
    // видны другим классам из текущего пакета и из внешних пакетов
    // private - закрытый класс или член класса, противоположность модификатору public. Закрытый класс или член класса доступен
    // только из кода в том же классе
    // protected - такой класс или член класса доступен из любого места в текущем классе или пакете или в производных классах,
    // даже если они находятся в других пакетах
    // default (пусто, по умолчанию) - отсутвие модификатора у поля или метода класса предполагает применение к нему модификатор по умолчанию.
    // Такие поля или методы видны всем классам в текущем пакете

    //Прмер блока инициализаторов:
    static {    // Инициализатор static выполянется до создания самого первого экземпляра класса
        countEmployer = 0;
    }

    {   // Инициализатор выполянется до любого конструктора, можно поместить код общий длях всех конструкторов
        countEmployer++;
    }

    // Формат сигнатуы конструктора: <имя_конструктора_класса> (перечень параметров: <аргумент 1> ... <аргумент N>)
    // Пример переопределения конструктора по умолчанию
    Employer() {
        this.idEmployer = countEmployer;  //Поле ID инкременируется
        this.statusWork = 1; //(int)(Math.random() * 3) ;    //Cтатус: 0 - уволен, 1 - работает, 2 - находится на больничном, 3 - находится в декрете
        this.firstName = "Иван";    //this - ссылка на текущий экземпляр класса. Через это слово можно обращаться к полям, методам объекта и конструкторам
        this.lastName = "Иванов";
        this.middleName = "Иванович";
        this.age = (int)(Math.random() * 40 + 18);
        this.otdel = "Тестирования";
        this.post = "Тестировщик";
        this.workPhone = "+7(999)666-00-00";
        this.workEmail = "example@work.ru";
        this.pay = (int)(Math.random() * 60000 + 10000);;
    }

    // Параметризированный конструктор для создания экземпляра класса Employer
    // Конструктор вызывается при создании нового объекта данного класса. Конструктор выполняет инициацию оъекта
    // Если в классе не определено ни одного конструктора, то для этого конструктора автоматически создаётся конструктор без параметров
    // Сигнатура конструктора:
    Employer(String firstName, String lastName, String middleName, int age, String workPhone, String workEmail, String otdel, String position, float pay) {
        this.idEmployer = countEmployer;  //Поле ID инкременируется
        this.statusWork = 1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        this.otdel = otdel;
        this.post = position;
        this.workPhone = workPhone;
        this.workEmail = workEmail;
        this.pay = pay;
    }

    //Метод экземпляра класса для получения информации о сотруднике
    void getInfo(boolean print) {
        String statusWork = "";
        switch (this.statusWork) {
            case 0: statusWork = "уволен";      //Cтатус: 0 - уволен, 1 - работает, 2 - находится на больничном, 3 - находится в декрете
                break;
            case 1: statusWork = "работает";
                break;
            case 2: statusWork = "болен";
                break;
            case 3: statusWork = "в декрет";
        }
        if(print == true)
        System.out.println("id\t\tСтатус\t\t\tИмя\t\t\tФамилия\t\t\tОтчёство\t\tВозраст\t\tОтдел\t\t\t\tДолжность\t\tТелефон\t\t\t\tE-mail\t\t\t  Зарплата");
        System.out.println(idEmployer + "\t\t" + statusWork + "\t\t" + firstName + "\t\t" + lastName + "\t\t\t" + middleName + "\t\t" + age + "\t\t\t" + otdel + "\t\t" + post + "\t\t" + workPhone + "\t" + workEmail + "\t  " + pay);
    }

    //Метод экземпляра класса для ввода информации о сотруднике
    public void setInfo() {
        System.out.println("Введите информацию о сотруднике с номером " + this.idEmployer + ":");
        System.out.print("Введите имя:");
        this.firstName = in.next();
        System.out.print("Введите фамилию:");
        this.lastName = in.next();
        System.out.print("Введите отчество:");
        this.middleName = in.next();
        System.out.print("Введите возраст:");
        this.age = in.nextInt();
        System.out.print("Наименование отдела:");
        this.otdel = in.next();
        this.workPhone = "+7(999)666-00-00";
        this.workEmail = "example@work.ru";
        System.out.print("Должность:");
        this.post = in.next();
        System.out.print("Оклад:");
        this.pay = in.nextInt();
    }

    //Метод экземпляра класса для вывод данных данных о возрасте сотрудника больше age
    public void showEmpFixAge(int age, boolean print) {
            if(this.age >= age)
                getInfo(print);
    }

    //Метод класса для получения информации о всех созданных объектах класса Employer
    public static void getCountItem() {
        System.out.println("Количество объектов в классе: " + countEmployer);
    }
}
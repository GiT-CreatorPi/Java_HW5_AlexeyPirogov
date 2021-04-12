//Дисциплина: Java.Уровень 1
//Домашнее задание №: 5 "Введение в ООП"
//Студент: Алексей Пирогов
//Дата: 12.04.2021

public class HomeWorkApp_5 {

    public static void main(String[] args) {

        // Создание массива экземпляров класса Employer путём вызова оператора new для динамического выделения памяти
        Employer emp[] = new Employer[5];
        for (int i = 0; i < emp.length - 1 ; i++)    //пример заполения массива Иванами Ивановыми
            emp[i] = new Employer();    //Вызов конструктора по умолчанию для иванов ивановых с разным возрастом
        System.out.print("Создан массив из Иванов Ивановых c размерностью: " + emp.length + ". ");
        Employer.getCountItem();    //вывод информации количестве объектов в классе с использованием метода класса

        System.out.print("\nПример получения информации о сотрудниках c использованием геттера:\n");
        for (int i = 0; i < emp.length - 1; i++)
            if (i == 0) emp[i].getInfo(true);   //вывод информации о первом объекте в качестве образца
            else emp[i].getInfo(false);

        //Ввод информации в массив с использованием параметризированного конструктора
        emp[emp.length - 1] = new Employer("Алексей", "Царь", "Михайлович", 40, "+7(999)666-00-00", "example@work.ru", "Бухгалтерия", "Бухгалтер", 100000);
        System.out.print("\nДобавлен ещё один сотрудник с использованием параметрического конструктора:\n");
        emp[4].getInfo(false);
        Employer.getCountItem();    //вывод информации количестве объектов в классе с использованием метода класса
        System.out.print("\nПример обновления информации о сотрудниках c использованием сеттера:\n");

        //ввод информации о 2-х сотрудниках
        for (int i = 3; i < emp.length; i++) {
            emp[i].setInfo();
            System.out.println();
        }

        System.out.print("Вывод информации о сотрудниках:\n");
        for (int i = 0; i < emp.length; i++)        //вывод информации об экземплярах массива объектов класса Employer
            if(i==0) emp[i].getInfo(true);
            else emp[i].getInfo(false);

        boolean headerPrint = true;
        System.out.print("\nПример вывода информации о сотрудника старше 40 лет:\n");
        for (int i = 0; i < emp.length; i++) {
                emp[i].showEmpFixAge(40, headerPrint);
                headerPrint = false;
        }

        System.out.print("\nПример создания переменной относящейся к классу Employer:\n");
        Employer e = new Employer("Гермион", "Ким", "Захарович", 30, "+7(999)666-00-00", "example@work.ru", "МТО", "Специалист", 70000);;    //пример создания экземпляра класса типа Employer
        e.getInfo(true);           //вызов метода объекта для получения информации об объекте
        Employer.getCountItem();        //количество объектов в классе

        System.out.print("\nПример привоения переменной нового значения, элемента массива " + emp.length + ":\n");
        e = emp[emp.length-1];          //присвоение экземпляру класса значения из массива экземпляров класса
        e.getInfo(true);           //вызов метода получения информации об экземпляре
        Employer.getCountItem();        //количество объектов в классе
    }
}

import less_1.Personee;
import less_2.ArrayListSimpl;
import less_2.LinkedListSimpl;


public class Main {

    public static void main(String[] args) {
// 1
        Personee p = new Personee.Builder().address("St.Lenina 1-1").age(77).country("RUSA").firstName("Ivan").gender("M").lastName("Lavvrov").middleName("Vict").build();
        System.out.println(p);
// 2
//        1. Реализовать основные методы связанного списка.
//        2. Реализовать основные методы ArrayList.

            LinkedListSimpl list = new LinkedListSimpl();

            list = LinkedListSimpl.insert(list, 1);
            list = LinkedListSimpl.insert(list, 1);
            list = LinkedListSimpl.insert(list, 1);
            list = LinkedListSimpl.insert(list, 0);
            list = LinkedListSimpl.insert(list, 0);
            list = LinkedListSimpl.insert(list, 1);
            list = LinkedListSimpl.insert(list, 1);
            list = LinkedListSimpl.insert(list, 0);

            LinkedListSimpl.print(list);

            ArrayListSimpl al  = new ArrayListSimpl();
            al.add("1");
            al.add(9,"10");
            al.add(19,"100");

        }


}
import less_1.Personee;

public class Main {

    public static void main(String[] args) {
        Personee p = new Personee.Builder().address("St.Lenina 1-1").age(77).country("RUSA").firstName("Ivan").gender("M").lastName("Lavvrov").middleName("Vict").build();
        System.out.println(p);
    }

}

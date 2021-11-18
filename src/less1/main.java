package less1;
/* Создать builder для класса Person со следующими полями:
String firstName, String lastName, String middleName, String country, String address, String phone, int age, String gender.
 */

public class main {

    public static void main(String[] args) {

        Personee p = new Personee.Builder().address("St.Lenina 1-1").age(77).country("RUSA").firstName("Ivan").gender("M").lastName("Lavvrov").middleName("Vict").build();
        System.out.println(p);
    }
}

class Personee {
        private String firstName,
                lastName,
                middleName,
                country,
                address,
                phone,
                gender;
        private int age;

        public Personee(Builder bld) {
            if (bld == null)
                throw new IllegalArgumentException("please proide builder!");
            this.firstName = bld.firstName;
            this.lastName = bld.lastName;
            this.middleName = bld.middleName;
            this.country = bld.country;
            this.address = bld.address;
            this.phone = bld.phone;
            this.gender = bld.gender;
            this.age = bld.age;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Personee [firstName=").append(firstName).
                    append(", lastName=").append(lastName).
                    append(", middleName=").append(middleName).
                    append(", country=").append(country).
                    append(", address=").append(address).
                    append(", phone=").append(phone).
                    append(", gender=").append(gender).
                    append(", age=").append(age).
                    append("]");
            return builder.toString();
        }

        public static class Builder {
            private String firstName,
                    lastName,
                    middleName,
                    country,
                    address,
                    phone,
                    gender;
            private int age;

            public Builder() {
                super();
            }

            public Builder firstName(String firstName) {
                this.firstName = firstName;
                return this;
            }

            public Builder lastName(String lastName) {
                this.lastName = lastName;
                return this;
            }

            public Builder middleName(String middleName) {
                this.middleName = middleName;
                return this;
            }

            public Builder country(String country) {
                this.country = country;
                return this;
            }

            public Builder address(String address) {
                this.address = address;
                return this;
            }

            public Builder phone(String phone) {
                this.phone = phone;
                return this;
            }

            public Builder gender(String gender) {
                this.gender = gender;
                return this;
            }

            public Builder age(int age) {
                this.age = age;
                return this;
            }

            public Personee build() {
                return new Personee(this);
            }
        }
    }


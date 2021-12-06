package entity;
import lombok.*;
import javax.persistence.*;
import java.util.List;

/*
Создать базу данных Student с полями id, name, mark.
Создать сущность Student и добавить в нее аннотации. Поле id должно заполняться автоматически.
Создать конфигурационный файл hibernate.cfg.xml, в котором указать свойства для подключения к БД и список классов с аннотациями Entity.
Создать класс со статическим методом, который возвращает объект SessionFactory.

Создать DAO-слой с операциями добавления, удаления, изменения сущности, выборки записи по ID и всех записей.
Добавить 1000 записей в таблицу Student.

Проверить работоспособность приложения, выполнить методы по удалению, изменению, добавлению записей, а также выборки одной и всех записей.
* Не делайте пункты 1-7. Создайте обобщенный Dao класс, позволяющий выполнять CRUD-операции над любой сущностью.
*/


@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
    @SequenceGenerator(name = "sequence-generator",    sequenceName = "user_sequence", initialValue = 100)

    @Getter @Setter private long id;

    @Column(name = "name")
    @Getter @Setter private String name;

    @Getter @Setter private int marka;


    public Student() {
    }

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student {"+"id="+id+", name='"+name+'\''+", mark="+marka+'}';
    }

}

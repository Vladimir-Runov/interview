import entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import org.hibernate.cfg.Configuration;

public class StudentApplication {

    @PersistenceContext
    private EntityManager emgr;

    public static void main(String[] args) {

        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        StudentRepository repo = new StudentRepository(emFactory);
        for (int i = 0; i < 1000; i++ )
            repo.insert(new Student(null, "Student name "+ i));
        repo.findAll().forEach(System.out::println);

/////////
        EntityManager emgr = emFactory.createEntityManager();

        emgr.getTransaction().begin();
            emgr.persist(new Student(null, "student 1"));
        emgr.getTransaction().commit();

        Student st = emgr.find(Student.class, 100L);
        emgr.refresh(st);
        emgr.close();
    }
}
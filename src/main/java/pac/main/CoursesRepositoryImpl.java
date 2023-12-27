package pac.main;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CoursesRepositoryImpl implements Repository<Courses, Integer> {
    SessionFactory sessionFactory;



    CoursesRepositoryImpl (){
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Courses.class)
                .buildSessionFactory();
    };

    public void add(Courses item) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(item);
        System.out.println("Object course save successfully");
        session.getTransaction().commit();
    }

    @Override
    public void update(Courses item) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Courses item) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(item);
        session.getTransaction().commit();
    }

    @Override
    public Courses getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Courses courses = session.get(Courses.class, id);
        session.getTransaction().commit();
        return courses;
    }

    @Override
    public Collection<Courses> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT * FROM Courses", Courses.class).getResultList();
    }
}


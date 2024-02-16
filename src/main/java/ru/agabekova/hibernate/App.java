package ru.agabekova.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.agabekova.hibernate.model.Passport;
import ru.agabekova.hibernate.model.Person;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            //cоздаем человека и паспортные данные:
            Person person = new Person("Artem", 30);
            Passport passport = new Passport(123456);

            person.setPassport(passport);

            session.save(person);

            // читаем паспортные данные из БД
//            Person person = session.get(Person.class, 1);
//            System.out.println(person.getPassport().getPassportNumber());

            // читаем имя человека из БД
//            Passport passport = session.get(Passport.class, 1);
//            System.out.println(passport.getPerson().getName());


            // изменим паспортные данные человека
//            Person person = session.get(Person.class, 1);
//            person.getPassport().setPassportNumber(77777);


            //удалить человека из БД
//            Person person = session.get(Person.class, 1);
//            session.remove(person);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}

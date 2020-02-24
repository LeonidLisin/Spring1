package Lesson3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session;

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Good.class)
                .addAnnotatedClass(Buyer.class)
                .buildSessionFactory();

        // получаем список товаров для заданного покупателя
        session = factory.getCurrentSession();
        session.beginTransaction();
        Buyer buyer = session.get(Buyer.class, 3);
        System.out.println(buyer);
        session.getTransaction().commit();

        // получаем список покупателей для заданного товара
        session = factory.getCurrentSession();
        session.beginTransaction();
        Good good = session.get(Good.class, 2);
        System.out.println(good);
        session.getTransaction().commit();

        session = factory.getCurrentSession();
        session.beginTransaction();
        Good goodToDelete = session.get(Good.class, 1);
        session.delete(goodToDelete);
        session.getTransaction().commit();
    }

}

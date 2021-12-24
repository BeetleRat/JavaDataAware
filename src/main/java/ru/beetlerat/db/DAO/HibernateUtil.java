package ru.beetlerat.db.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.beetlerat.db.model.Graph;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Создать сессию для hibernate.cfg.xml
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Graph.class);
                // Собрать сессию
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение: " + e);
            }
        }
        return sessionFactory;
    }
}

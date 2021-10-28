package peaksoft.util;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    @Bean
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration()
                    .setProperty(Environment.DRIVER, "org.postgresql.Driver")
                    .setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect")
                    .setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres")
                    .setProperty(Environment.USER,"postgres")
                    .setProperty(Environment.PASS, "0304")
                    .setProperty(Environment.HBM2DDL_AUTO, "validate")
                    .setProperty(Environment.SHOW_SQL, "true")
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Car.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

}
package exm.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorSAPDBDatabaseImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Country.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Country> countries = session.createQuery("from Country ")
                            .getResultList();
            int counter = 1;
            for (Country country:countries){
                System.out.println(counter+". "+country.getName()+"\t"+
                        country.getLifeExpectancy());
                counter++;
            }
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}

package com.hibernatedemo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        //Öncelikle factory configure etmemiz gerkiyor
        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(City.class).buildSessionFactory();
        //Unit of Work
        //session'ı başlatıyoruz
        Session session = factory.getCurrentSession();
        int count = 1;

        //try-catch ile Transaction başlatıyoruz
        try {
            session.beginTransaction();
            /**
             * Select * from city--City class ismşne bakarak C harfini büyük yazdık
             * HQL-> Hibernate Query Language
             * ASC-Ascending
             * DESC - Descending
             */
            /**
            Select işlemi
            List<String> countrycodes = session.createQuery("select c.countryCode from City c group by c.countryCode").getResultList();
            for (String countrycode:countrycodes){
                System.out.println(count+"."+countrycode);
                count++;
            }
             */
            /**
            //İnsert işlemi
            City city = new City();
            city.setName("MaxiMorpheus");
            city.setCountryCode("TUR");
            city.setDistrict("Marmara");
            city.setPopulation(200000);
            session.save(city);
             */
            /**
            //Update işlemi
            City city = session.get(City.class,4080);//İstenilen datayı databse den getirir
            System.out.println(city.getName()+"--"+city.getPopulation());
            city.setPopulation(21000000);
            session.save(city);
            System.out.println(city.getName()+"--"+city.getPopulation());
            session.getTransaction().commit();
            */
            /**
            //Delete işlemi
            City city = session.get(City.class,4077);
            session.delete(city);
            session.getTransaction().commit();
            System.out.println("Deleted city name: "+city.getName());
             */

        }catch (Exception e){
            System.out.println(e.getMessage());

        }finally {
            factory.close();
        }
    }
}

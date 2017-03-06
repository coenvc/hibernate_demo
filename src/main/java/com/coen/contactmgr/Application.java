package com.coen.contactmgr;
import com.coen.contactmgr.model.*;
import com.coen.contactmgr.model.Contact;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


public class Application {

    public static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory(){
        //Create standard service registry
        final ServiceRegistry registry = new StandardServiceRegistryBuilder()
                //Hierin kan een afwijkende lokatie aangegeven worden voor de Hibernate config file
                .configure()
                .build();
        //Laad hibernate configuratie bestand

        return new MetadataSources(registry).buildMetadata().buildSessionFactory();

    }

    public static void main(String[] args) {
        Contact contact = new Contact.ContactBuilder("Coen","van Campenhout")
                .email("coenvc@gmail.com")
                .phone(06893992086)

    }
}

package utils;

import com.google.inject.internal.cglib.core.$ReflectUtils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FactoryUtil {
    public static SessionFactory buildFactory() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                    configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable e) {
            System.err.println("fail" + e);
            throw new ExceptionInInitializerError(e);
        }
    }
}

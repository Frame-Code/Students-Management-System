package com.mycompany.gestion_alumnos.PERSISTENCIA;

import io.github.cdimascio.dotenv.Dotenv;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class JPAUtil {
    private final EntityManagerFactory emf;
    private final Dotenv dotenv;
    private final Map<String, String> properties;

    public JPAUtil() {
        this.dotenv = Dotenv.configure().load();
        this.properties = new HashMap<>();
        rellenarPropiedades();
        this.emf = Persistence.createEntityManagerFactory("administradorPU", properties);
    }

    private void rellenarPropiedades() {
        this.properties.put("javax.persistence.jdbc.url", "jdbc:mysql://" + dotenv.get("DB_HOST") + ":" + dotenv.get("DB_PORT") + "/" + dotenv.get("DB_NAME") + "?serverTimezone=UTC");
        this.properties.put("javax.persistence.jdbc.user", dotenv.get("DB_USER"));
        this.properties.put("javax.persistence.jdbc.password", dotenv.get("DB_PASSWORD"));
        this.properties.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        this.properties.put("javax.persistence.schema-generation.database.action", "create");
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

}

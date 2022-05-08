package ru.ryazanova.itbookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import ru.ryazanova.itbookstore.entity.Product;
import ru.ryazanova.itbookstore.entity.ProductCategory;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedActions = {HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.POST};

        //disable HttpMethods for Product.class - delete, put, post
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedActions)));

        //disable HttpMethods for ProductCategory.class - delete, put, post
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedActions)));

        //call internal helper method
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        //get a list of all entity classes from entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        //create array of entity types
        List<Class> entityClasses = new ArrayList<>();

        //- get the entity types for entities
        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        // - expose the entity ids for the array of entity / domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }

}

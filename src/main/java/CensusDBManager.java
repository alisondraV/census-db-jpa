import entity.GeographicareaEntity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class CensusDBManager {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CensusDBManager");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // Task 2
        System.out.println("********************************************************************************************************************************************************************************************");
        System.out.println("TASK 2: Geographic Area with ID = 10:");
        GeographicareaEntity geoEntityID10 = entityManager.find(GeographicareaEntity.class, 10);
        System.out.println(geoEntityID10.toString());
        System.out.println();

        // Task 3
        System.out.println("********************************************************************************************************************************************************************************************");
        System.out.println("TASK 3: Geographic Areas information with the Level 2");
        Query geoLevel2Query = entityManager.createQuery("select ga from GeographicareaEntity ga where ga.level = 2");
        List geoLevel2List = geoLevel2Query.getResultList();
        for (Object area : geoLevel2List) {
            System.out.println("Geographic Area with Level 2: " + area.toString());
        }
        System.out.println();

        // For task 6
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<GeographicareaEntity> geoQuery = criteriaBuilder.createQuery(GeographicareaEntity.class);
//        Root<GeographicareaEntity> geoArea = geoQuery.from(GeographicareaEntity.class);
//        Predicate predicate = criteriaBuilder.equal(geoArea.get(""))
//        TypedQuery<GeographicareaEntity> query = entityManager.createQuery();

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}

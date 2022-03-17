import entity.AgeEntity;
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

        // Task 4
        System.out.println("********************************************************************************************************************************************************************************************");
        System.out.println("TASK 4: Named query to retrieve information about Total Income");
        Query totalIncomeQuery = entityManager.createNamedQuery("findallIncome");
        totalIncomeQuery.setMaxResults(10);
        List totalIncomeList = totalIncomeQuery.getResultList();
        for (Object totalIncome : totalIncomeList) {
            System.out.println("Total Income: " + totalIncome.toString());
        }
        System.out.println();

        // For task 6
        System.out.println("********************************************************************************************************************************************************************************************");
        System.out.println("TASK 6: Criteria Query");
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // Question a.
        System.out.println("a. Geographic Areas:");
        CriteriaQuery<GeographicareaEntity> geoAreasCriteriaQuery = criteriaBuilder.createQuery(GeographicareaEntity.class);
        Root<GeographicareaEntity> geoAreaEntityRoot = geoAreasCriteriaQuery.from(GeographicareaEntity.class);

        geoAreasCriteriaQuery.multiselect(geoAreaEntityRoot.get("code"), geoAreaEntityRoot.get("level"), geoAreaEntityRoot.get("name"));
        CriteriaQuery<GeographicareaEntity> multiSelect = geoAreasCriteriaQuery.select(geoAreaEntityRoot);
        TypedQuery<GeographicareaEntity> geoQuery = entityManager.createQuery(multiSelect).setMaxResults(10);
        geoQuery.getResultList().forEach(ga -> System.out.println("Code: " + ga.getCode() + " Level: "+
                        ga.getLevel() + " Name: " + ga.getName()));
        System.out.println();

        // Question b.
        System.out.println("b. Top 20 combined Age information");
        CriteriaQuery<AgeEntity> ageCriteriaQuery = criteriaBuilder.createQuery(AgeEntity.class);
        Root<AgeEntity> ageEntityRoot = ageCriteriaQuery.from(AgeEntity.class);

        ageCriteriaQuery.orderBy(criteriaBuilder.desc(ageEntityRoot.get("combined")));
        CriteriaQuery<AgeEntity> orderBy = ageCriteriaQuery.select(ageEntityRoot);
        TypedQuery<AgeEntity> ageQuery = entityManager.createQuery(orderBy).setMaxResults(20);
        ageQuery.getResultList().forEach(age -> System.out.println(age.getCombined()));
        System.out.println();

        // Question c.
        System.out.println("c. Geographic Area named 'Peterborough'");
        Predicate geoAreaPredicate = criteriaBuilder.equal(geoAreaEntityRoot.get("name"),"Peterborough");
        geoAreasCriteriaQuery.where(geoAreaPredicate);
        CriteriaQuery<GeographicareaEntity> whereClause = geoAreasCriteriaQuery.select(geoAreaEntityRoot);
        TypedQuery<GeographicareaEntity> peterboroughQuery = entityManager.createQuery(whereClause);
        System.out.println(peterboroughQuery.getSingleResult().toString());
        System.out.println();

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}

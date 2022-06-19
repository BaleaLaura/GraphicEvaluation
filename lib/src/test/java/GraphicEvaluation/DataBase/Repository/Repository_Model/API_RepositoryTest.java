package GraphicEvaluation.DataBase.Repository.Repository_Model;
import static org.mockito.Mockito.*;
import GraphicEvaluation.DataBase.Model.APIs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class API_RepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    API_Repository api_repository;


    @Test
    public void saveApi() {


        LocalDate date = LocalDate.now();
        APIs apIs = new APIs();
        apIs.setDateAPI(date);
        apIs.setNameApi("Google");

        entityManager.persist(apIs);
        Assertions.assertEquals("Google", apIs.getNameApi());
        Assertions.assertEquals(date, apIs.getDateAPI());

    }

    @Test
    void getAllAPIs() {
        LocalDate date = LocalDate.now();
        APIs apIs = new APIs();
        apIs.setDateAPI(date);
        apIs.setNameApi("Google");
        entityManager.persist(apIs);

        APIs apIs2 = new APIs();
        apIs2.setDateAPI(date);
        apIs2.setNameApi("Test");
        entityManager.persist(apIs2);

        APIs apIs3 = new APIs();
        apIs3.setDateAPI(date);
        apIs3.setNameApi("Test2");
        entityManager.persist(apIs3);

        Iterable<APIs> apis = api_repository.findAll();
        assertThat(apis).contains(apIs, apIs2, apIs3);

    }

    @Test
    void updateAPI() {
        LocalDate date = LocalDate.now();

        APIs apIs = new APIs();
        apIs.setDateAPI(date);
        apIs.setNameApi("Google");
        entityManager.persist(apIs);
        APIs apIs2 = new APIs();
        apIs2.setDateAPI(date);
        apIs2.setNameApi("Google");
        entityManager.persist(apIs2);

        APIs apIsUpdate = new APIs();
        apIsUpdate.setDateAPI(date);
        apIsUpdate.setNameApi("Test");

        APIs apis = api_repository.findById(apIs2.getIdAPI()).get();

        apis.setNameApi(apIsUpdate.getNameApi());
        apis.setDateAPI(apIsUpdate.getDateAPI());
        api_repository.save(apis);

        APIs checkApi = api_repository.findById(apIs2.getIdAPI()).get();

        assertThat(checkApi.getIdAPI()).isEqualTo(apIs2.getIdAPI());
        assertThat(checkApi.getNameApi()).isEqualTo(apIsUpdate.getNameApi());
        assertThat(checkApi.getDateAPI()).isEqualTo(apIsUpdate.getDateAPI());

    }

    @Test
    void deleteAPIs() {
        LocalDate date = LocalDate.now();
        APIs apIs = new APIs();
        apIs.setDateAPI(date);
        apIs.setNameApi("Google");
        entityManager.persist(apIs);

        APIs apIs2 = new APIs();
        apIs2.setDateAPI(date);
        apIs2.setNameApi("Test");
        entityManager.persist(apIs2);

        APIs apIs3 = new APIs();
        apIs3.setDateAPI(date);
        apIs3.setNameApi("Test2");
        entityManager.persist(apIs3);

        api_repository.deleteById(apIs2.getIdAPI());
        Iterable<APIs> apis = api_repository.findAll();
        assertThat(apis).contains(apIs, apIs3);

    }


}
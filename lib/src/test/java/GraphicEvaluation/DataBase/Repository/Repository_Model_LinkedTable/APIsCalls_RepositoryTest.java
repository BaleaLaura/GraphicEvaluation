package GraphicEvaluation.DataBase.Repository.Repository_Model_LinkedTable;

import GraphicEvaluation.DataBase.Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class APIsCalls_RepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    APIsCalls_Repository apIsCalls_repository;

    LocalDate date = LocalDate.now();
    JsonGoogle jsonGoogle=new JsonGoogle();
    Images images=new Images();
    Images images2=new Images();
    Images images3=new Images();
    APIs apis=new APIs();
    APIs apis2=new APIs();
    APIs apis3=new APIs();


    @Test
    public void saveApis_Calls() {
        APIsCallsId apIsCallsId=new APIsCallsId();
        apIsCallsId.setIdAPI(images.getIdImg());
        apIsCallsId.setIdImg(apis.getIdAPI());

        APIsCalls apIsCalls=new APIsCalls();
        apIsCalls.setDateAPI(date);
        apIsCalls.setResponseAPI(jsonGoogle);
        apIsCalls.setIdImg(images);
        apIsCalls.setApiId(apis);
        apIsCalls.setId(apIsCallsId);

        entityManager.persist(apIsCalls);
        Assertions.assertEquals(date, apIsCalls.getDateAPI());

    }

    @Test
    void getAllApis_Calls() {
        APIsCallsId apIsCallsId=new APIsCallsId();
        apIsCallsId.setIdAPI(images.getIdImg());
        apIsCallsId.setIdImg(apis.getIdAPI());

        APIsCallsId apIsCallsId1=new APIsCallsId();
        apIsCallsId1.setIdAPI(images2.getIdImg());
        apIsCallsId1.setIdImg(apis2.getIdAPI());

        APIsCallsId apIsCallsId2=new APIsCallsId();
        apIsCallsId2.setIdAPI(images3.getIdImg());
        apIsCallsId2.setIdImg(apis3.getIdAPI());

        APIsCalls apIsCalls=new APIsCalls();
        apIsCalls.setDateAPI(date);
        apIsCalls.setResponseAPI(jsonGoogle);
        apIsCalls.setIdImg(images);
        apIsCalls.setApiId(apis);
        apIsCalls.setId(apIsCallsId);
        entityManager.persist(apIsCalls);

        APIsCalls apIsCalls1=new APIsCalls();
        apIsCalls1.setDateAPI(date);
        apIsCalls1.setResponseAPI(jsonGoogle);
        apIsCalls1.setIdImg(images2);
        apIsCalls1.setApiId(apis2);
        apIsCalls1.setId(apIsCallsId1);
        entityManager.persist(apIsCalls1);

        APIsCalls apIsCalls2=new APIsCalls();
        apIsCalls2.setDateAPI(date);
        apIsCalls2.setResponseAPI(jsonGoogle);
        apIsCalls2.setIdImg(images3);
        apIsCalls2.setApiId(apis3);
        apIsCalls2.setId(apIsCallsId2);
        entityManager.persist(apIsCalls2);

        List<APIsCalls> apIsCalls3= apIsCalls_repository.findAll();
        assertThat(apIsCalls3).contains(apIsCalls, apIsCalls1, apIsCalls2);

    }

    @Test
    void updateApis_Calls() {

        APIsCallsId apIsCallsId=new APIsCallsId();
        apIsCallsId.setIdAPI(images.getIdImg());
        apIsCallsId.setIdImg(apis.getIdAPI());

        APIsCallsId apIsCallsId1=new APIsCallsId();
        apIsCallsId1.setIdAPI(images2.getIdImg());
        apIsCallsId1.setIdImg(apis2.getIdAPI());

        APIsCallsId apIsCallsId2=new APIsCallsId();
        apIsCallsId2.setIdAPI(images3.getIdImg());
        apIsCallsId2.setIdImg(apis3.getIdAPI());

        APIsCalls apIsCalls=new APIsCalls();
        apIsCalls.setDateAPI(date);
        apIsCalls.setResponseAPI(jsonGoogle);
        apIsCalls.setIdImg(images);
        apIsCalls.setApiId(apis);
        apIsCalls.setId(apIsCallsId);
        entityManager.persist(apIsCalls);

        APIsCalls apIsCalls1=new APIsCalls();
        apIsCalls1.setDateAPI(date);
        apIsCalls1.setResponseAPI(jsonGoogle);
        apIsCalls1.setIdImg(images2);
        apIsCalls1.setApiId(apis2);
        apIsCalls1.setId(apIsCallsId1);
        entityManager.persist(apIsCalls1);

        APIsCalls apIsCallsUpdate=new APIsCalls();
        apIsCallsUpdate.setDateAPI(date);
        apIsCallsUpdate.setResponseAPI(jsonGoogle);
        apIsCallsUpdate.setIdImg(images3);
        apIsCallsUpdate.setApiId(apis3);
        apIsCallsUpdate.setId(apIsCallsId2);

        APIsCalls apIsCalls2 = apIsCalls_repository.findById(apIsCalls1.getId()).get();

        apIsCalls2.setResponseAPI(apIsCallsUpdate.getResponseAPI());
        apIsCalls2.setDateAPI(apIsCallsUpdate.getDateAPI());
        apIsCalls_repository.save(apIsCalls2);

        APIsCalls checkApiCalls = apIsCalls_repository.findById(apIsCalls1.getId()).get();

        assertThat(checkApiCalls.getId()).isEqualTo(apIsCalls1.getId());
        assertThat(checkApiCalls.getResponseAPI()).isEqualTo(apIsCallsUpdate.getResponseAPI());
        assertThat(checkApiCalls.getDateAPI()).isEqualTo(apIsCallsUpdate.getDateAPI());

    }

    @Test
    void deleteApis_Calls() {
        APIsCallsId apIsCallsId=new APIsCallsId();
        apIsCallsId.setIdAPI(images.getIdImg());
        apIsCallsId.setIdImg(apis.getIdAPI());

        APIsCallsId apIsCallsId1=new APIsCallsId();
        apIsCallsId1.setIdAPI(images2.getIdImg());
        apIsCallsId1.setIdImg(apis2.getIdAPI());

        APIsCallsId apIsCallsId2=new APIsCallsId();
        apIsCallsId2.setIdAPI(images3.getIdImg());
        apIsCallsId2.setIdImg(apis3.getIdAPI());

        APIsCalls apIsCalls=new APIsCalls();
        apIsCalls.setDateAPI(date);
        apIsCalls.setResponseAPI(jsonGoogle);
        apIsCalls.setIdImg(images);
        apIsCalls.setApiId(apis);
        apIsCalls.setId(apIsCallsId);
        entityManager.persist(apIsCalls);

        APIsCalls apIsCalls1=new APIsCalls();
        apIsCalls1.setDateAPI(date);
        apIsCalls1.setResponseAPI(jsonGoogle);
        apIsCalls1.setIdImg(images2);
        apIsCalls1.setApiId(apis2);
        apIsCalls1.setId(apIsCallsId1);
        entityManager.persist(apIsCalls1);

        APIsCalls apIsCalls2=new APIsCalls();
        apIsCalls2.setDateAPI(date);
        apIsCalls2.setResponseAPI(jsonGoogle);
        apIsCalls2.setIdImg(images3);
        apIsCalls2.setApiId(apis3);
        apIsCalls2.setId(apIsCallsId2);
        entityManager.persist(apIsCalls2);

        apIsCalls_repository.deleteById(apIsCalls1.getId());
        List<APIsCalls> apIsCalls3 = apIsCalls_repository.findAll();
        assertThat(apIsCalls3).contains(apIsCalls, apIsCalls2);

    }
}
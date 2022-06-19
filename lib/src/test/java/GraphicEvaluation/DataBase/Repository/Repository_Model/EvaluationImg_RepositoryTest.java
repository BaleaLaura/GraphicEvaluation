package GraphicEvaluation.DataBase.Repository.Repository_Model;

import GraphicEvaluation.DataBase.Model.EvaluationImg;
import GraphicEvaluation.DataBase.Model.Value;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EvaluationImg_RepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    EvaluationImg_Repository evaluationImg_repository;
    
    Value value1 = Value.TEXT;

    @Test
    public void saveEvaluationImg() {


        EvaluationImg evaluationImg = new EvaluationImg();
        evaluationImg.setCharacteristics("Caracteristics");
        evaluationImg.setTypeCharacteristics(value1);

        entityManager.persist(evaluationImg);
        Assertions.assertEquals("Caracteristics", evaluationImg.getCharacteristics());
    }

    @Test
    void getAllEvaluationImg() {

        EvaluationImg evaluationImg = new EvaluationImg();
        evaluationImg.setCharacteristics("Caracteristics");
        evaluationImg.setTypeCharacteristics(value1);
        entityManager.persist(evaluationImg);

        EvaluationImg evaluationImg2 = new EvaluationImg();
        evaluationImg2.setCharacteristics("Caracteristics2");
        evaluationImg2.setTypeCharacteristics(value1);
        entityManager.persist(evaluationImg2);

        EvaluationImg evaluationImg3 = new EvaluationImg();
        evaluationImg3.setCharacteristics("Caracteristics3");
        evaluationImg3.setTypeCharacteristics(value1);
        entityManager.persist(evaluationImg3);

        Iterable<EvaluationImg> evaluationImgs = evaluationImg_repository.findAll();
        assertThat(evaluationImgs).contains(evaluationImg, evaluationImg2, evaluationImg3);
    }

    @Test
    void updateEvaluationImg() {
        EvaluationImg evaluationImg = new EvaluationImg();
        evaluationImg.setCharacteristics("Caracteristics");
        evaluationImg.setTypeCharacteristics(value1);
        entityManager.persist(evaluationImg);

        EvaluationImg evaluationImg2 = new EvaluationImg();
        evaluationImg2.setCharacteristics("Caracteristics2");
        evaluationImg2.setTypeCharacteristics(value1);

        entityManager.persist(evaluationImg2);

        EvaluationImg evaluationUpdate = new EvaluationImg();
        evaluationUpdate.setCharacteristics("Caracteristics3");
        evaluationUpdate.setTypeCharacteristics(value1);
        EvaluationImg apis = evaluationImg_repository.findById(evaluationImg2.getIdEv()).get();

        apis.setCharacteristics(evaluationUpdate.getCharacteristics());
        apis.setTypeCharacteristics(evaluationUpdate.getTypeCharacteristics());
        evaluationImg_repository.save(apis);

        EvaluationImg checkEvaluation = evaluationImg_repository.findById(evaluationImg2.getIdEv()).get();

        assertThat(checkEvaluation.getIdEv()).isEqualTo(evaluationImg2.getIdEv());
        assertThat(checkEvaluation.getCharacteristics()).isEqualTo(evaluationUpdate.getCharacteristics());
        assertThat(checkEvaluation.getTypeCharacteristics()).isEqualTo(evaluationUpdate.getTypeCharacteristics());

    }

    @Test
    void deleteEvaluationImg() {

        EvaluationImg evaluationImg = new EvaluationImg();
        evaluationImg.setCharacteristics("Caracteristics");
        evaluationImg.setTypeCharacteristics(value1);
        entityManager.persist(evaluationImg);

        EvaluationImg evaluationImg2 = new EvaluationImg();
        evaluationImg2.setCharacteristics("Caracteristics2");
        evaluationImg2.setTypeCharacteristics(value1);
        entityManager.persist(evaluationImg2);

        EvaluationImg evaluationImg3 = new EvaluationImg();
        evaluationImg3.setCharacteristics("Caracteristics3");
        evaluationImg3.setTypeCharacteristics(value1);
        entityManager.persist(evaluationImg3);

        evaluationImg_repository.deleteById(evaluationImg2.getIdEv());
        Iterable<EvaluationImg> evaluationImgs = evaluationImg_repository.findAll();
        assertThat(evaluationImgs).contains(evaluationImg, evaluationImg3);

    }


}
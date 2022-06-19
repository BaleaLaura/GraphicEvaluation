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
public class RulesHasImages_RepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    RulesHasImages_Repository rulesHasImages_repository;

    LocalDate date = LocalDate.now();
    Images images=new Images();
    Images images2=new Images();
    Images images3=new Images();
    Rules rules=new Rules();
    Rules rules2=new Rules();
    Rules rules3=new Rules();

    @Test
    public void saveApis_Calls() {
        RulesHasImagesId rulesHasImagesId=new RulesHasImagesId();
        rulesHasImagesId.setIdRule(rules.getIdRule());
        rulesHasImagesId.setIdImg(images.getIdImg());

        RulesHasImages rulesHasImages=new RulesHasImages();
        rulesHasImages.setId(rulesHasImagesId);
        rulesHasImages.setWhy("reason");
        rulesHasImages.setIdRule(rules);
        rulesHasImages.setIdImg(images);
        rulesHasImages.setState(true);
        rulesHasImages.setDateEvaluation(date);
        entityManager.persist(rulesHasImages);
        Assertions.assertEquals("reason", rulesHasImages.getWhy());
        Assertions.assertTrue(rulesHasImages.isState());


    }

    @Test
    void getAllApis_Calls() {
        RulesHasImagesId rulesHasImagesId=new RulesHasImagesId();
        rulesHasImagesId.setIdRule(rules.getIdRule());
        rulesHasImagesId.setIdImg(images.getIdImg());

        RulesHasImagesId rulesHasImagesId1=new RulesHasImagesId();
        rulesHasImagesId1.setIdRule(rules.getIdRule());
        rulesHasImagesId1.setIdImg(images.getIdImg());

        RulesHasImagesId rulesHasImagesId2 = new RulesHasImagesId();
        rulesHasImagesId2.setIdRule(rules.getIdRule());
        rulesHasImagesId2.setIdImg(images.getIdImg());

        RulesHasImages rulesHasImages1=new RulesHasImages();
        rulesHasImages1.setId(rulesHasImagesId);
        rulesHasImages1.setWhy("reason");
        rulesHasImages1.setIdRule(rules);
        rulesHasImages1.setIdImg(images);
        rulesHasImages1.setState(true);
        rulesHasImages1.setDateEvaluation(date);
        entityManager.persist(rulesHasImages1);

        RulesHasImages rulesHasImages2=new RulesHasImages();
        rulesHasImages2.setId(rulesHasImagesId1);
        rulesHasImages2.setWhy("reason");
        rulesHasImages2.setIdRule(rules2);
        rulesHasImages2.setIdImg(images2);
        rulesHasImages2.setState(true);
        rulesHasImages2.setDateEvaluation(date);
        entityManager.persist(rulesHasImages2);

        RulesHasImages rulesHasImages3=new RulesHasImages();
        rulesHasImages3.setId(rulesHasImagesId2);
        rulesHasImages3.setWhy("reason");
        rulesHasImages3.setIdRule(rules3);
        rulesHasImages3.setIdImg(images3);
        rulesHasImages3.setState(true);
        rulesHasImages1.setDateEvaluation(date);
        entityManager.persist(rulesHasImages3);

        List<RulesHasImages> rulesHasImages = rulesHasImages_repository.findAll();
        assertThat(rulesHasImages).contains(rulesHasImages1, rulesHasImages2, rulesHasImages3);

    }

    @Test
    void updateApis_Calls() {

        RulesHasImagesId rulesHasImagesId=new RulesHasImagesId();
        rulesHasImagesId.setIdRule(rules.getIdRule());
        rulesHasImagesId.setIdImg(images.getIdImg());

        RulesHasImagesId rulesHasImagesId1=new RulesHasImagesId();
        rulesHasImagesId1.setIdRule(rules.getIdRule());
        rulesHasImagesId1.setIdImg(images.getIdImg());

        RulesHasImagesId rulesHasImagesId2 = new RulesHasImagesId();
        rulesHasImagesId2.setIdRule(rules.getIdRule());
        rulesHasImagesId2.setIdImg(images.getIdImg());

        RulesHasImages rulesHasImages1=new RulesHasImages();
        rulesHasImages1.setId(rulesHasImagesId);
        rulesHasImages1.setWhy("reason");
        rulesHasImages1.setIdRule(rules);
        rulesHasImages1.setIdImg(images);
        rulesHasImages1.setState(true);
        rulesHasImages1.setDateEvaluation(date);
        entityManager.persist(rulesHasImages1);

        RulesHasImages rulesHasImages2=new RulesHasImages();
        rulesHasImages2.setId(rulesHasImagesId1);
        rulesHasImages2.setWhy("reason");
        rulesHasImages2.setIdRule(rules2);
        rulesHasImages2.setIdImg(images2);
        rulesHasImages2.setState(true);
        rulesHasImages2.setDateEvaluation(date);
        entityManager.persist(rulesHasImages2);

        RulesHasImages rulesHasImages3=new RulesHasImages();
        rulesHasImages3.setId(rulesHasImagesId2);
        rulesHasImages3.setWhy("reason");
        rulesHasImages3.setIdRule(rules3);
        rulesHasImages3.setIdImg(images3);
        rulesHasImages3.setState(true);
        rulesHasImages1.setDateEvaluation(date);

        RulesHasImages rulesHasImages = rulesHasImages_repository.findById(rulesHasImages2.getId()).get();

        rulesHasImages.setState(rulesHasImages3.isState());
        rulesHasImages.setDateEvaluation(rulesHasImages3.getDateEvaluation());
        rulesHasImages_repository.save(rulesHasImages);

        RulesHasImages checkRulesHasImage = rulesHasImages_repository.findById(rulesHasImages2.getId()).get();

        assertThat(checkRulesHasImage.getId()).isEqualTo(rulesHasImages2.getId());
        assertThat(checkRulesHasImage.isState()).isEqualTo(rulesHasImages3.isState());
        assertThat(checkRulesHasImage.getDateEvaluation()).isEqualTo(rulesHasImages3.getDateEvaluation());

    }

    @Test
    void deleteApis_Calls() {
        RulesHasImagesId rulesHasImagesId=new RulesHasImagesId();
        rulesHasImagesId.setIdRule(rules.getIdRule());
        rulesHasImagesId.setIdImg(images.getIdImg());

        RulesHasImagesId rulesHasImagesId1=new RulesHasImagesId();
        rulesHasImagesId1.setIdRule(rules.getIdRule());
        rulesHasImagesId1.setIdImg(images.getIdImg());

        RulesHasImagesId rulesHasImagesId2 = new RulesHasImagesId();
        rulesHasImagesId2.setIdRule(rules.getIdRule());
        rulesHasImagesId2.setIdImg(images.getIdImg());

        RulesHasImages rulesHasImages=new RulesHasImages();
        rulesHasImages.setId(rulesHasImagesId);
        rulesHasImages.setWhy("reason");
        rulesHasImages.setIdRule(rules);
        rulesHasImages.setIdImg(images);
        rulesHasImages.setState(true);
        rulesHasImages.setDateEvaluation(date);
        entityManager.persist(rulesHasImages);

        RulesHasImages rulesHasImages1=new RulesHasImages();
        rulesHasImages1.setId(rulesHasImagesId1);
        rulesHasImages1.setWhy("reason");
        rulesHasImages1.setIdRule(rules2);
        rulesHasImages1.setIdImg(images2);
        rulesHasImages1.setState(true);
        rulesHasImages1.setDateEvaluation(date);
        entityManager.persist(rulesHasImages1);

        RulesHasImages rulesHasImages2=new RulesHasImages();
        rulesHasImages2.setId(rulesHasImagesId2);
        rulesHasImages2.setWhy("reason");
        rulesHasImages2.setIdRule(rules3);
        rulesHasImages2.setIdImg(images3);
        rulesHasImages2.setState(true);
        rulesHasImages.setDateEvaluation(date);
        entityManager.persist(rulesHasImages2);


        rulesHasImages_repository.deleteById(rulesHasImages1.getId());
        List<RulesHasImages> rules_has_images1 = rulesHasImages_repository.findAll();
        assertThat(rules_has_images1).contains(rulesHasImages, rulesHasImages2);

    }

}
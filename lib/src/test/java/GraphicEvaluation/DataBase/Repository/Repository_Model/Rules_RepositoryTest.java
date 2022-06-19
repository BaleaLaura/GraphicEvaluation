package GraphicEvaluation.DataBase.Repository.Repository_Model;

import GraphicEvaluation.DataBase.Model.Rules;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Rules_RepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    Rules_Repository rules_repository;

    @Test
    public void saveRules() {

        Rules rules = new Rules();
        rules.setNameRule("Symmetry Rule");
        rules.setDescription("description");
        entityManager.persist(rules);
        Assertions.assertEquals("Symmetry Rule", rules.getNameRule());

    }

    @Test
    void getAllRules() {
        Rules rules = new Rules();
        rules.setNameRule("Symmetry Rule");
        rules.setDescription("description");
        entityManager.persist(rules);

        Rules rules2 = new Rules();
        rules2.setNameRule("Rule of Thirds");
        rules2.setDescription("description");
        entityManager.persist(rules2);

        Rules rules3 = new Rules();
        rules3.setNameRule("Symmetry Rule");
        rules3.setDescription("description");
        rules_repository.save(rules3);

        Iterable<Rules> rul = rules_repository.findAll();
        assertThat(rul).contains(rules, rules2, rules3);

    }

    @Test
    void updateRules() {

        Rules rules = new Rules();
        rules.setNameRule("Symmetry Rule");
        rules.setDescription("description");
        entityManager.persist(rules);

        Rules rules2 = new Rules();
        rules2.setNameRule("Rule of Thirds");
        rules2.setDescription("description");
        entityManager.persist(rules2);

        Rules rulUpdate = new Rules();
        rulUpdate.setNameRule("Symmetry Rule");
        rulUpdate.setDescription("description");
        Rules rul = rules_repository.findById(rules2.getIdRule()).get();

        rul.setNameRule(rulUpdate.getNameRule());
        rul.setDescription(rulUpdate.getDescription());
        rules_repository.save(rul);

        Rules checkRules = rules_repository.findById(rules2.getIdRule()).get();

        assertThat(checkRules.getIdRule()).isEqualTo(rules2.getIdRule());
        assertThat(checkRules.getNameRule()).isEqualTo(rulUpdate.getNameRule());
        assertThat(checkRules.getDescription()).isEqualTo(rulUpdate.getDescription());

    }

    @Test
    void deleteRules() {
        Rules rules = new Rules();
        rules.setNameRule("Symmetry Rule");
        rules.setDescription("description");
        entityManager.persist(rules);

        Rules rules2 = new Rules();
        rules2.setNameRule("Rule of Thirds");
        rules2.setDescription("description");
        entityManager.persist(rules2);

        Rules rules3 = new Rules();
        rules3.setNameRule("Symmetry Rule");
        rules3.setDescription("description");
        entityManager.persist(rules3);


        rules_repository.deleteById(rules2.getIdRule());
        Iterable<Rules> rul = rules_repository.findAll();
        assertThat(rul).contains(rules, rules3);

    }

}
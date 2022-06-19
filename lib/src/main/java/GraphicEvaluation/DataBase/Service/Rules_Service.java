package GraphicEvaluation.DataBase.Service;

import GraphicEvaluation.Exceptions.ResourceNotFoundException;
import GraphicEvaluation.DataBase.Model.Rules;
import GraphicEvaluation.DataBase.Repository.Repository_Model.Rules_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Rules_Service {

    /**
     * is injected the Rules_Repository object
     */
    @Autowired
    private final Rules_Repository rules_repository;

    /**
     * @param rules_repository represents the repository it will manage
     */
    public Rules_Service(Rules_Repository rules_repository) {
        this.rules_repository = rules_repository;
    }

    /**
     * this method save the record
     *
     * @param rules the record that will be saved
     */
    public void saveRules(Rules rules) {
        rules_repository.save(rules);
    }

    /**
     * @return will return all records
     */
    public List<Rules> getAllRules() {
        return rules_repository.findAll();
    }

    /**
     * @param rules the record that will be updated
     * @param id record id that will be updated
     * @throws ResourceNotFoundException if the record is not found
     */
    public void updateRules(Rules rules, int id) throws ResourceNotFoundException {

        Rules existingRules = rules_repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Rules not found"));
        existingRules.setIdRule(rules.getIdRule());
        existingRules.setNameRule(rules.getNameRule());
        existingRules.setDescription(rules.getDescription());
        existingRules.setRulesHasImages(rules.getRulesHasImages());


        rules_repository.save(existingRules);
    }

    /**
     * @param id the record that will be deleted
     * @throws ResourceNotFoundException if the record is not found
     */
    public void deleteRules(int id) throws ResourceNotFoundException {
        rules_repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rules not found"));
        rules_repository.deleteById(id);
    }

}

package GraphicEvaluation.DataBase.Service;

import GraphicEvaluation.Exceptions.ResourceNotFoundException;
import GraphicEvaluation.DataBase.Model.RulesHasImages;
import GraphicEvaluation.DataBase.Model.RulesHasImagesId;
import GraphicEvaluation.DataBase.Repository.Repository_Model_LinkedTable.RulesHasImages_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RulesHasImages_Service {
    /**
     * is injected the RulesHasImages_Repository object
     */
    @Autowired
    private final RulesHasImages_Repository rules_has_images_repository;

    /**
     * @param rules_has_images_repository represents the repository it will manage
     */
    public RulesHasImages_Service(RulesHasImages_Repository rules_has_images_repository) {
        this.rules_has_images_repository = rules_has_images_repository;
    }

    /**
     * this method save the record
     *
     * @param rules_has_images the record that will be saved
     */
    public void saveRulesImage(RulesHasImages rules_has_images) {
        rules_has_images_repository.save(rules_has_images);
    }

    /**
     * @return will return all records
     */
    public List<RulesHasImages> getAllRulesImages() {
        return rules_has_images_repository.findAll();
    }

    /**
     * @param rules_has_images the record that will be updated
     * @param rules_has_images_id record id that will be updated
     * @throws ResourceNotFoundException if the record is not found
     */
    public void updateRulesImages(RulesHasImages rules_has_images, RulesHasImagesId rules_has_images_id) throws ResourceNotFoundException {

        RulesHasImages existingRules_Images = rules_has_images_repository.findById(rules_has_images_id).orElseThrow(()
                -> new ResourceNotFoundException("Api not found"));
        existingRules_Images.setId(rules_has_images.getId());
        existingRules_Images.setIdImg(rules_has_images.getIdImg());
        existingRules_Images.setIdRule(rules_has_images.getIdRule());
        existingRules_Images.setState(rules_has_images.isState());
        existingRules_Images.setWhy(rules_has_images.getWhy());
        existingRules_Images.setDateEvaluation(rules_has_images.getDateEvaluation());

        rules_has_images_repository.save(existingRules_Images);

    }

    /**
     * @param rules_has_images_id the record that will be deleted
     * @throws ResourceNotFoundException if the record is not found
     */
    public void deleteAPIs(RulesHasImagesId rules_has_images_id) throws ResourceNotFoundException {
        rules_has_images_repository.findById(rules_has_images_id).orElseThrow(() -> new ResourceNotFoundException("Api not found"));
        rules_has_images_repository.deleteById(rules_has_images_id);
    }

}

package GraphicEvaluation.DataBase.Service;

import GraphicEvaluation.Exceptions.ResourceNotFoundException;
import GraphicEvaluation.DataBase.Model.EvaluationImg;
import GraphicEvaluation.DataBase.Repository.Repository_Model.EvaluationImg_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationImg_Service {

    /**
     * is injected the EvaluationImg_Repository object
     */
    @Autowired
    private final EvaluationImg_Repository evaluationImg_repository;

    /**
     * @param evaluationImg_repository represents the repository it will manage
     */
    public EvaluationImg_Service(EvaluationImg_Repository evaluationImg_repository) {
        this.evaluationImg_repository = evaluationImg_repository;
    }

    /**
     * this method save the record
     *
     * @param evaluationImg the record that will be saved
     */
    public void saveEvaluationImg(EvaluationImg evaluationImg) {
        evaluationImg_repository.save(evaluationImg);
    }

    /**
     * @return will return all records
     */
    public List<EvaluationImg> getAllEvaluationImg() {
        return evaluationImg_repository.findAll();
    }

    /**
     * @param evaluationImg the record that will be updated
     * @param id record id that will be updated
     * @throws ResourceNotFoundException if the record is not found
     */
    public void updateAPI(EvaluationImg evaluationImg, int id) throws ResourceNotFoundException {

        EvaluationImg existingEvaluation = evaluationImg_repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Evaluation not found"));
        existingEvaluation.setIdEv(evaluationImg.getIdEv());
        existingEvaluation.setCharacteristics(evaluationImg.getCharacteristics());
        existingEvaluation.setImages(evaluationImg.getImages());
        existingEvaluation.setTypeCharacteristics(evaluationImg.getTypeCharacteristics());

        evaluationImg_repository.save(existingEvaluation);
    }

    /**
     * @param id the record that will be deleted
     * @throws ResourceNotFoundException if the record is not found
     */
    public void deleteAPIs(int id) throws ResourceNotFoundException {
        evaluationImg_repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Evaluation not found"));
        evaluationImg_repository.deleteById(id);
    }
}

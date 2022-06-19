package GraphicEvaluation.DataBase.Service;

import GraphicEvaluation.Exceptions.ResourceNotFoundException;
import GraphicEvaluation.DataBase.Model.APIsCalls;
import GraphicEvaluation.DataBase.Model.APIsCallsId;

import GraphicEvaluation.DataBase.Repository.Repository_Model_LinkedTable.APIsCalls_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class APICalls_Service {

    /**
     * is injected the APIsCalls_Repository object
     */
    @Autowired
    private APIsCalls_Repository apIs_calls_repository;

    /**
     * @param apIs_calls_repository represents the repository it will manage
     */
    public APICalls_Service(APIsCalls_Repository apIs_calls_repository) {
        this.apIs_calls_repository = apIs_calls_repository;
    }

    /**
     * this method save the record
     *
     * @param api_calls the record that will be saved
     */
    public void saveApi_calls(APIsCalls api_calls) {
        apIs_calls_repository.save(api_calls);
    }

    /**
     * @return will return all records
     */
    public List<APIsCalls> getAllApi_calls() {
        return apIs_calls_repository.findAll();
    }

    /**
     * @param apIs_calls the record that will be updated
     * @param apIs_calls_id record id that will be updated
     * @throws ResourceNotFoundException if the record is not found
     */
    public void updateApi_calls(APIsCalls apIs_calls, APIsCallsId apIs_calls_id) throws ResourceNotFoundException {

        APIsCalls existingAPI_Calls = apIs_calls_repository.findById(apIs_calls_id).orElseThrow(()
                -> new ResourceNotFoundException("Calls not found"));
        existingAPI_Calls.setDateAPI(apIs_calls.getDateAPI());
        existingAPI_Calls.setResponseAPI(apIs_calls.getResponseAPI());
        existingAPI_Calls.setId(apIs_calls.getId());
        existingAPI_Calls.setApiId(apIs_calls.getApiId());

        apIs_calls_repository.save(existingAPI_Calls);
    }

    /**
     * @param apIs_calls_id the record that will be deleted
     * @throws ResourceNotFoundException if the record is not found
     */
    public void deleteApi_calls(APIsCallsId apIs_calls_id) throws ResourceNotFoundException {
        apIs_calls_repository.findById(apIs_calls_id).orElseThrow(() -> new ResourceNotFoundException("Image not found"));
        apIs_calls_repository.deleteById(apIs_calls_id);
    }


}

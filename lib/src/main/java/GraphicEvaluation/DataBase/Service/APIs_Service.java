package GraphicEvaluation.DataBase.Service;


import GraphicEvaluation.Exceptions.ResourceNotFoundException;
import GraphicEvaluation.DataBase.Model.APIs;
import GraphicEvaluation.DataBase.Repository.Repository_Model.API_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class APIs_Service {

    /**
     * is injected the API_Repository object
     */
    @Autowired
    private final API_Repository api_repository;

    /**
     * @param api_repository represents the repository it will manage
     */
    public APIs_Service(API_Repository api_repository) {
        this.api_repository = api_repository;
    }

    /**
     * this method save the record
     *
     * @param apIs the record that will be saved
     */
    public void saveAPi(APIs apIs) {
        api_repository.save(apIs);
    }

    /**
     * @return will return all records
     */
    public List<APIs> getAllAPIs() {
        return api_repository.findAll();
    }

    /**
     * @param apIs the record that will be updated
     * @param id the record id that will be updated
     * @throws ResourceNotFoundException if the record is not found
     */
    public void updateAPI(APIs apIs, int id) throws ResourceNotFoundException {

        APIs existingApis = api_repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Api not found"));
        existingApis.setNameApi(apIs.getNameApi());
        existingApis.setDateAPI(apIs.getDateAPI());
        existingApis.setIdAPI(apIs.getIdAPI());

        api_repository.save(existingApis);
    }

    /**
     * @param id the record id that will be deleted
     * @throws ResourceNotFoundException if the record is not found
     */
    public void deleteAPIs(int id) throws ResourceNotFoundException {
        api_repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Api not found"));
        api_repository.deleteById(id);
    }

}

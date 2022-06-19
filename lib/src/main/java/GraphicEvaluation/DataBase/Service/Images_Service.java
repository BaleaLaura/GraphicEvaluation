package GraphicEvaluation.DataBase.Service;

import GraphicEvaluation.Exceptions.ResourceNotFoundException;
import GraphicEvaluation.DataBase.Model.Images;
import GraphicEvaluation.DataBase.Repository.Repository_Model.Images_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class Images_Service {

    /**
     * is injected the Images_Repository object
     */
    @Autowired
    private final Images_Repository images_repository;

    /**
     * @param images_repository represents the repository it will manage
     */
    public Images_Service(Images_Repository images_repository) {
        this.images_repository = images_repository;
    }


    /**
     * this method save the record
     *
     * @param images the record that will be saved
     */
    public void saveImage(Images images) throws SQLException {
        images_repository.save(images);
    }

    /**
     * @return will return all records
     */
    public List<Images> getAllImage() {
        return images_repository.findAll();
    }

    /**
     * @param images the record that will be updated
     * @param id record id that will be updated
     * @throws ResourceNotFoundException if the record is not found
     */
    public void updateImage(Images images, int id) throws ResourceNotFoundException {


        Images existingImage = images_repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Image not found"));
        existingImage.setDateImg(images.getDateImg());
        existingImage.setIdImg(images.getIdImg());
        existingImage.setNameImg(images.getNameImg());
        existingImage.setApIsCalls(images.getApIsCalls());

        images_repository.save(existingImage);
    }

    /**
     * @param id the record that will be deleted
     * @throws ResourceNotFoundException if the record is not found
     */
    public void deleteImages(int id) throws ResourceNotFoundException {
        images_repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Image not found"));
        images_repository.deleteById(id);
    }

}
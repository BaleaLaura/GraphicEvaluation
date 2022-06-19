package GraphicEvaluation.DataBase.Repository.Repository_Model_LinkedTable;

import GraphicEvaluation.DataBase.Model.RulesHasImages;
import GraphicEvaluation.DataBase.Model.RulesHasImagesId;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * we create the interface for repository that will extend the JpaRepository interface
 * This interface offers a default implementation for the basic CRUD operations.
 * As parameter will receive an RulesHasImages object and an RulesHasImagesId object as id
 */
public interface RulesHasImages_Repository extends JpaRepository<RulesHasImages, RulesHasImagesId> {
}

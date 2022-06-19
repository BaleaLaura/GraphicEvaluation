package GraphicEvaluation.DataBase.Repository.Repository_Model_LinkedTable;

import GraphicEvaluation.DataBase.Model.APIsCalls;
import GraphicEvaluation.DataBase.Model.APIsCallsId;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * we create the interface for repository that will extend the JpaRepository interface,
 * This interface offers a default implementation for the basic CRUD operations.
 * As parameter will receive an APIsCalls object and an APIsCallsId object as id
 */
public interface APIsCalls_Repository extends JpaRepository<APIsCalls, APIsCallsId> {
}

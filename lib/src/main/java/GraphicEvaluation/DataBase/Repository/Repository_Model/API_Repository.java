package GraphicEvaluation.DataBase.Repository.Repository_Model;

import GraphicEvaluation.DataBase.Model.APIs;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * we create the interface for repository that will extend the JpaRepository interface,
 * This interface offers a default implementation for the basic CRUD operations.
 * As parameter will receive an API object and an integer id
 */
public interface API_Repository extends JpaRepository<APIs, Integer> {
}

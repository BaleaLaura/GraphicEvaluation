package GraphicEvaluation.DataBase.Model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * In this class this composite primary key is mapped. To be added to the database, must be serialized
 */
@Data
@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RulesHasImagesId implements Serializable {

    private static final long serialVersionUID = -7697394756645391606L;

    @Column(name = "idRule")
    private Integer idRule;

    @Column(name = "idImg")
    private Integer idImg;

}

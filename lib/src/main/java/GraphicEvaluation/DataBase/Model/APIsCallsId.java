package GraphicEvaluation.DataBase.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * In this class the composite primary key is mapped. To be added to the database, must be serialized
 */
@Data
@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class APIsCallsId implements Serializable {

    private static final long serialVersionUID = -196111874242024929L;

    @Column(name = "idAPI")
    private Integer idAPI;

    @Column(name = "idImg")
    private Integer idImg;

}

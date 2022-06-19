package GraphicEvaluation.DataBase.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
/**
 * Represents the table for Evaluation informations
 */

@Entity
@Table(name = "EvaluationImg")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEv;

    @Column(name = "Characteristics")
    private String characteristics;


    @Column(name = "TypeCharacteristics")
    private Enum typeCharacteristics;

    //is created the relationship many-to-one with the Images
    @ManyToOne
    @JoinColumn(name = "idImg")
    private Images images;

}

package GraphicEvaluation.DataBase.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
/**
 * Represents the table for images informations
 */
@Entity
@Table(name = "Images")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idImg;

    @Column(name = "NameImg")
    private String nameImg;

    @Column(name = "DateImg")
    private LocalDate dateImg;

    //are created the relationships many-to-one with the apisCalls, evaluation and rulesHasImages
    @OneToMany
    @JoinColumn(name = "idImg")
    Set<APIsCalls> apIsCalls = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "idImg")
    Set<EvaluationImg> evaluationImgs = new HashSet<>();

    @OneToMany()
    @JoinColumn(name = "idImg")
    Set<RulesHasImages> rulesHasImages = new HashSet<>();

}

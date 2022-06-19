package GraphicEvaluation.DataBase.Model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/**
 * Represents the table for rules informations
 */
@Data
@Entity
@Table(name = "Rules")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRule;

    @Column(name = "NameRule")
    private String nameRule;

    @Column(name = "Description")
    private String description;

    //is created the relationship many-to-one with the Images
    @OneToMany()
    @JoinColumn(name = "idRule")
    Set<RulesHasImages> rulesHasImages = new HashSet<>();

}

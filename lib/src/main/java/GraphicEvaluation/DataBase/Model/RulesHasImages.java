package GraphicEvaluation.DataBase.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
/**
 * Represents the link table between rules and Images.
 */
@Entity
@Table(name = "RullesHasImages")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RulesHasImages {

    @EmbeddedId
    private RulesHasImagesId id;

    //create the relationship many-to-one with the rules.
    @ManyToOne
    @MapsId("idRule")
    @JoinColumn(name = "idRule")
    private Rules idRule;

    //is created the relationship many-to-one with the Images
    @ManyToOne
    @MapsId("idImg")
    @JoinColumn(name = "idImg")
    private Images idImg;

    @Column(name = "State")
    private boolean state;

    @Column(name = "Why")
    private String why;

    @Column(name = "Date")
    private LocalDate DateEvaluation;


}

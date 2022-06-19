package GraphicEvaluation.DataBase.Model;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represents the link table between APIs and Images.
 */
@Data
@Entity
@Table(name = "APIsCalls")
//mentions that it is used a json data
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class APIsCalls implements Serializable {


    @EmbeddedId
    private APIsCallsId id;

    //is created the relationship many-to-one with the APIs table
    @ManyToOne
    @MapsId("idAPI")
    @JoinColumn(name = "idAPI")
    private APIs apiId;

    //is created the relationship many-to-one with the Images table
    @ManyToOne
    @MapsId("idImg")
    @JoinColumn(name = "idImg")
    private Images idImg;

    @Column(name = "DateAPI")
    private LocalDate dateAPI;

    @Type(type = "json")
    @Column(name = "ResponseAPI", columnDefinition = "json")
    private JsonGoogle responseAPI;

}

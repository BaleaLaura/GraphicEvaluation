package GraphicEvaluation.DataBase.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents the table for API informations
 */
@Data
@Entity
@Table(name = "APIs")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class APIs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAPI;

    @Column(name = "NameAPI")
    private String nameApi;

    @Column(name = "DateAPI")
    private LocalDate dateAPI;

    //is created the relationship one-to-many with the apiCalls table
    @OneToMany
    @JoinColumn(name="idAPI")
    Set<APIsCalls> apIsCalls = new HashSet<>();

}

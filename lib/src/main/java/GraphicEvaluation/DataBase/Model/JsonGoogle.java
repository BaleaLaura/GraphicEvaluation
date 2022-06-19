package GraphicEvaluation.DataBase.Model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * here is created the json file that I store in the database. To do this it must be serialized
 */
@Data
public class JsonGoogle implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> elem;

    public List<String> getElem() {
        return elem;
    }

    public void setElem(List<String> elem) {
        this.elem = elem;
    }
}

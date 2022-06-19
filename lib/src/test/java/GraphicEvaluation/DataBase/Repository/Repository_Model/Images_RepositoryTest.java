package GraphicEvaluation.DataBase.Repository.Repository_Model;

import GraphicEvaluation.DataBase.Model.Images;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Images_RepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    Images_Repository images_repository;

    LocalDate date = LocalDate.now();


    @Test
    public void saveImage() {

        Images images = new Images();
        images.setNameImg("unu.png");
        images.setDateImg(date);

        entityManager.persist(images);
        Assertions.assertEquals("unu.png", images.getNameImg());

    }

    @Test
    void getAllImage() {

        Images images = new Images();
        images.setNameImg("foto.png");
        images.setDateImg(date);
        entityManager.persist(images);

        Images images2 = new Images();
        images2.setNameImg("test.png");
        images2.setDateImg(date);
        entityManager.persist(images2);

        Images images3 = new Images();
        images3.setNameImg("test2.png");
        images3.setDateImg(date);
        entityManager.persist(images3);

        Iterable<Images> imag = images_repository.findAll();
        assertThat(imag).contains(images, images2, images3);

    }

    @Test
    void updateImage() {

        Images images = new Images();
        images.setNameImg("foto.png");
        images.setDateImg(date);
        entityManager.persist(images);

        Images images2 = new Images();
        images2.setNameImg("foto2.png");
        images2.setDateImg(date);
        entityManager.persist(images2);

        Images imagUpdate = new Images();
        imagUpdate.setNameImg("test.png");
        imagUpdate.setDateImg(date);

        Images img = images_repository.findById(images2.getIdImg()).get();

        img.setNameImg(imagUpdate.getNameImg());
        img.setDateImg(imagUpdate.getDateImg());
        images_repository.save(img);

        Images checkImage = images_repository.findById(images2.getIdImg()).get();

        assertThat(checkImage.getIdImg()).isEqualTo(images2.getIdImg());
        assertThat(checkImage.getNameImg()).isEqualTo(imagUpdate.getNameImg());
        assertThat(checkImage.getDateImg()).isEqualTo(imagUpdate.getDateImg());

    }

    @Test
    void deleteImage() {
        Images images = new Images();
        images.setNameImg("foto.png");
        images.setDateImg(date);
        entityManager.persist(images);

        Images images2 = new Images();
        images2.setNameImg("test.png");
        images2.setDateImg(date);
        entityManager.persist(images2);

        Images images3 = new Images();
        images3.setNameImg("test2.png");
        images3.setDateImg(date);
        entityManager.persist(images3);


        images_repository.deleteById(images2.getIdImg());
        Iterable<Images> img = images_repository.findAll();
        assertThat(img).contains(images, images3);

    }
}
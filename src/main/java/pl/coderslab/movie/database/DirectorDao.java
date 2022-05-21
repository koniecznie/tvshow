package pl.coderslab.movie.database;

import org.springframework.stereotype.Repository;
import pl.coderslab.movie.entity.Director;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DirectorDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void save(Director director) {
        entityManager.persist(director);
    }

    public Director find(long idDirector) {
        return entityManager.find(Director.class, idDirector);
    }

    public void update(Director director) {
        entityManager.merge(director);
    }

    public void delete(Director director) {
        entityManager.remove(entityManager.contains(director) ?
                director : entityManager.merge(director));
    }


    public List<Director> getList() {
        return entityManager
                .createQuery("select a from Director a")
                .getResultList();

    }
}

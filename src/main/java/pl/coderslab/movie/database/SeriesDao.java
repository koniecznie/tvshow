package pl.coderslab.movie.database;

import org.springframework.stereotype.Repository;
import pl.coderslab.movie.entity.Series;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SeriesDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveSeries(Series series){
        entityManager.persist(series);
    }

    public Series find(long idSeries){
        return entityManager.find(Series.class,idSeries);

    }

    public void update(Series series){
        entityManager.merge(series);
    }
    public void delete(Series series){
        entityManager.remove(entityManager.contains(series) ?
                series : entityManager.merge(series));
    }

    public List<Series> getList(){
        return entityManager
                .createQuery("select s from Series s")
                .getResultList();
    }
}

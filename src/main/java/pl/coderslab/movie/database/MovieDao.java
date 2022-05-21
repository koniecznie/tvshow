package pl.coderslab.movie.database;

import org.springframework.stereotype.Repository;
import pl.coderslab.movie.entity.Director;
import pl.coderslab.movie.entity.Movie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MovieDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveMovie(Movie movie) {
        entityManager.persist(movie);
    }

    public Movie find(long idMovie) {
        return entityManager.find(Movie.class, idMovie);
    }

    public void update(Movie movie) {
        entityManager.merge(movie);
    }

    public void delete(Movie movie) {
        entityManager.remove(entityManager.contains(movie) ?
                movie : entityManager.merge(movie));
    }


    public List<Movie> getList() {
        return entityManager
                .createQuery("select m from Movie m")
                .getResultList();

    }

}
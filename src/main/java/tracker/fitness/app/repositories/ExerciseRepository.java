package tracker.fitness.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tracker.fitness.app.entities.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
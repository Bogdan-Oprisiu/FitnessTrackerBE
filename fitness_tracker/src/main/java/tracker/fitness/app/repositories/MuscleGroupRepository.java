package tracker.fitness.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tracker.fitness.app.entities.ExerciseType;
import tracker.fitness.app.entities.Exercise;
import tracker.fitness.app.entities.MuscleGroup;
import tracker.fitness.app.entities.Equipment;
import tracker.fitness.app.entities.Workout;

@Repository
public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {
}
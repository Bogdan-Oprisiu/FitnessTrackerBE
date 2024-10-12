package tracker.fitness.app.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tracker.fitness.app.entities.Exercise;
import tracker.fitness.app.repositories.ExerciseRepository;
import java.util.List;
import java.util.Optional;
@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }
    public Optional<Exercise> getExerciseById(Long id) {
        return exerciseRepository.findById(id);
    }
    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }
    public Optional<Exercise> updateExercise(Long id, Exercise exerciseDetails) {
        return exerciseRepository.findById(id).map(exercise -> {
            exercise.setName(exerciseDetails.getName());
            exercise.setDescription(exerciseDetails.getDescription());
            exercise.setDuration(exerciseDetails.getDuration());
            exercise.setIntensityLevel(exerciseDetails.getIntensityLevel());
            return exerciseRepository.save(exercise);
        });
    }
    public boolean deleteExercise(Long id) {
        if (exerciseRepository.existsById(id)) {
            exerciseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
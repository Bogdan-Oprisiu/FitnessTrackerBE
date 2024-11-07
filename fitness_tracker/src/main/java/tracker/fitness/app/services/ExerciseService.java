package tracker.fitness.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tracker.fitness.app.entities.Exercise;
import tracker.fitness.app.entities.ExerciseType;
import tracker.fitness.app.entities.MuscleGroup;
import tracker.fitness.app.entities.Equipment;
import tracker.fitness.app.repositories.ExerciseRepository;
import tracker.fitness.app.repositories.ExerciseTypeRepository;
import tracker.fitness.app.repositories.MuscleGroupRepository;
import tracker.fitness.app.repositories.EquipmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private ExerciseTypeRepository exerciseTypeRepository;

    @Autowired
    private MuscleGroupRepository muscleGroupRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

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
            exercise.setMuscleGroup(exerciseDetails.getMuscleGroup());
            exercise.setEquipment(exerciseDetails.getEquipment());
            exercise.setExerciseType(exerciseDetails.getExerciseType());
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

    public List<Exercise> getExercisesByMuscleGroup(Long muscleGroupId) {
        Optional<MuscleGroup> muscleGroup = muscleGroupRepository.findById(muscleGroupId);
        return muscleGroup.map(exerciseRepository::findByMuscleGroup).orElse(null);
    }

    public List<Exercise> getExercisesByEquipment(Long equipmentId) {
        Optional<Equipment> equipment = equipmentRepository.findById(equipmentId);
        return equipment.map(exerciseRepository::findByEquipment).orElse(null);
    }

    public List<Exercise> getExercisesByType(Long exerciseTypeId) {
        Optional<ExerciseType> exerciseType = exerciseTypeRepository.findById(exerciseTypeId);
        return exerciseType.map(exerciseRepository::findByExerciseType).orElse(null);
    }
}
package com.train8.train8mvp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.train8.train8mvp.Model.TrainingCenter;

@Repository
public interface TrainingCenterRepository extends MongoRepository<TrainingCenter, String> {
	// method to find a training center by center code
	TrainingCenter findByCenterCode(String centerCode);
}

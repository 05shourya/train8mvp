package com.train8.train8mvp.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.train8.train8mvp.Model.TrainingCenter;
import com.train8.train8mvp.Repository.TrainingCenterRepository;

@Service
public class TrainingCenterService {

	@Autowired
	private TrainingCenterRepository trainingCenterRepository;

	// Create a new training center
	public ResponseEntity<Object> createTrainingCenter(TrainingCenter trainingCenter) {
		try {
			trainingCenterRepository.save(trainingCenter);
			return ResponseEntity.ok(trainingCenter);
		} catch (DataIntegrityViolationException e) {

			// return error to handle duplicate field
			return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message",
					"Training center with code " + trainingCenter.getCenterCode() + " is already present"));
		}

	}

	// Get all training centers
	public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
		return ResponseEntity.ok(trainingCenterRepository.findAll());
	}

	// Get a training center by center code
	public ResponseEntity<Object> getTrainingCenterByCenterCode(String centerCode) {
		TrainingCenter trainingCenter = trainingCenterRepository.findByCenterCode(centerCode);

		// return error if training center is not found
		if (trainingCenter == null) {
			Map<String, String> response = new HashMap<>();
			response.put("message", "Training center not found for code: " + centerCode);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		return ResponseEntity.ok(trainingCenter);
	}
}

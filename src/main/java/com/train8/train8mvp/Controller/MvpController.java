package com.train8.train8mvp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.train8.train8mvp.Model.TrainingCenter;
import com.train8.train8mvp.Service.TrainingCenterService;

import jakarta.validation.Valid;

@RestController
public class MvpController {

	@Autowired
	private TrainingCenterService trainingCenterService;

	// Create a new training center
	@PostMapping("/training-centers")
	public ResponseEntity<Object> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
		return trainingCenterService.createTrainingCenter(trainingCenter);
	}

	// Get all training centers
	@GetMapping("/training-centers")
	public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
		return trainingCenterService.getAllTrainingCenters();
	}

	// Get a training center by center code
	@GetMapping("/training-centers/{centerCode}")
	public ResponseEntity<Object> getTrainingCenterByCenterCode(@PathVariable String centerCode) {
		return trainingCenterService.getTrainingCenterByCenterCode(centerCode);
	}
}

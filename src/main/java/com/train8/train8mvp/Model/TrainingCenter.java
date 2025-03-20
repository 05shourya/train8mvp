package com.train8.train8mvp.Model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.annotation.ReadOnlyProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "training_centers")
public class TrainingCenter {

	@MongoId
	private String id;

	@Size(max = 40, message = "Center name must be less than 40 characters")
	private String centerName;

	@Size(min = 12, max = 12, message = "Center code must be exactly 12 characters")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Center code must be alphanumeric")
	@Indexed(unique = true)
	private String centerCode;

	private Address address;

	private int studentCapacity;

	private List<String> coursesOffered;

	@CreatedDate
	@ReadOnlyProperty
	private LocalDateTime createdOn;

	@Email(message = "Please provide a valid email address")
	private String contactEmail;

	@Pattern(regexp = "^\\+?[1-9][0-9]{7,14}$", message = "Please provide a valid phone number")
	private String contactPhone;

	// Constructor without id and createdOn since they will be auto-generated
	public TrainingCenter(String centerName, String centerCode, Address address,
			int studentCapacity, List<String> coursesOffered,
			String contactEmail, String contactPhone) {
		this.centerName = centerName;
		this.centerCode = centerCode;
		this.address = address;
		this.studentCapacity = studentCapacity;
		this.coursesOffered = coursesOffered;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
	}
}
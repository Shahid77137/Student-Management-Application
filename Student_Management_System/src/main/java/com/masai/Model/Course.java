package com.masai.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "name cannot be empty")
    @NotBlank(message = "name cannot be blank")
	private String image;
	@NotNull(message = "name cannot be null")
	@NotEmpty(message = "name cannot be empty")
	@NotBlank(message = "name cannot be blank")
	private String courseType; 
	@NotNull(message = "description cannot be null")
	@NotEmpty(message = "description cannot be empty")
	@NotBlank(message = "description cannot be blank")
	private String description;
	@NotNull(message = "fee cannot be null")
//	@NotEmpty(message = "fee cannot be empty")
//	@NotBlank(message = "fee cannot be blank")
	@Positive(message = "Price should be in positive")
	@DecimalMin(value = "0.1", inclusive = false, message = "fee cannot be 0")
	private double fee;
	@NotNull(message = "fee cannot be null")
	@NotEmpty(message = "fee cannot be empty")
	@NotBlank(message = "fee cannot be blank")
	private String duration;
	@NotNull(message = "fee cannot be null")
//	@NotEmpty(message = "fee cannot be empty")
//	@NotBlank(message = "fee cannot be blank")
	@Enumerated(EnumType.STRING)
	private CourseStatusEnum courseStatus; //Enum
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
	private List<Batch> batches;
	
	@ManyToMany(cascade = CascadeType.ALL , mappedBy = "courses")
	private List<Student> students = new ArrayList<>();
	
	
	
}

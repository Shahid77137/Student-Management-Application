package com.masai.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
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
public class Teacher {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;
    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "name cannot be empty")
    @NotBlank(message = "name cannot be blank")
	private String name;
    @NotNull(message = "age cannot be null")
//	@NotEmpty(message = "age cannot be empty")
//	@NotBlank(message = "age cannot be blank")
    @Min(value = 18, message = "Age should be 18 or greater")
    private int age;
    @NotNull(message = "gender cannot be null")
//	@NotEmpty(message = "gender cannot be empty")
//	@NotBlank(message = "gender cannot be blank")
    @Enumerated(EnumType.STRING)
    private TeacherGenderTypeEnum gender; //Enum
    @NotNull(message = "phone cannot be null")
//	@NotEmpty(message = "phone cannot be empty")
//	@NotBlank(message = "phone cannot be blank")
    @Digits(integer = 10, fraction = 0, message = "Phone number should have exactly 10 digits")
    @Column(unique = true)
	private int phone;
    @NotNull(message = "email cannot be null")
    @NotEmpty(message = "email cannot be empty")
    @NotBlank(message = "email cannot be blank")
    @Column(unique = true)
    @Email(message = "Invalid email format")
	private String email;
    @NotNull(message = "subject cannot be null")
//    @NotEmpty(message = "subject cannot be empty")
//    @NotBlank(message = "subject cannot be blank")
    @Enumerated(EnumType.STRING)
	private SubjectTypeEnum subject; //Enum
    @NotNull(message = "salary cannot be null")
//    @NotEmpty(message = "salary cannot be empty")
//    @NotBlank(message = "salary cannot be blank")
    @Positive(message = "salary should be in positive")
	@DecimalMin(value = "0.1", inclusive = false, message = "salary cannot be 0")
	private int salary;
    @NotNull(message = "address cannot be null")
	@NotEmpty(message = "address cannot be empty")
	@NotBlank(message = "address cannot be blank")
    private String address;
    @NotNull(message = "pin cannot be null")
//	@NotEmpty(message = "pin cannot be empty")
//	@NotBlank(message = "pin cannot be blank")
    @Digits(integer = 6, fraction = 0, message = "Pin should have exactly 6 digits")
    private int pin;
	
    @ManyToMany(cascade = CascadeType.ALL , mappedBy = "teachers")
	private List<Student> students = new ArrayList<>();
    
    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Teacher_Batch", joinColumns = @JoinColumn(name ="teacherId"),inverseJoinColumns = @JoinColumn(name ="batchid"))
    private List<Batch> batches = new ArrayList<>();
	
}

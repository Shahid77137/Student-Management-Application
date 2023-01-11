package com.masai.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
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
    private GenderTypeEnum gender; //Enum
    @NotNull(message = "email cannot be null")
	@NotEmpty(message = "email cannot be empty")
	@NotBlank(message = "email cannot be blank")
    @Column(unique = true)
    @Email(message = "Invalid email format")
	private String email;
    @NotNull(message = "email cannot be null")
	@NotEmpty(message = "email cannot be empty")
	@NotBlank(message = "email cannot be blank")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%!]).{8,}$",
    message = "Password must have at least 8 characters, one uppercase letter, one lowercase letter, one number, and one special character")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;
    @NotNull(message = "email cannot be null")
	@NotEmpty(message = "email cannot be empty")
	@NotBlank(message = "email cannot be blank")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%!]).{8,}$",
    message = "Password must have at least 8 characters, one uppercase letter, one lowercase letter, one number, and one special character")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String confirm_password;
    @NotNull(message = "phone cannot be null")
//	@NotEmpty(message = "phone cannot be empty")
//	@NotBlank(message = "phone cannot be blank")
    @Digits(integer = 10, fraction = 0, message = "Phone number should have exactly 10 digits")
    @Column(unique = true)
	private long phone;
    @NotNull(message = "address cannot be null")
	@NotEmpty(message = "address cannot be empty")
	@NotBlank(message = "address cannot be blank")
    private String address;
    @NotNull(message = "pin cannot be null")
//	@NotEmpty(message = "pin cannot be empty")
//	@NotBlank(message = "pin cannot be blank")
    @Digits(integer = 6, fraction = 0, message = "Pin should have exactly 6 digits")
    private int pin;

    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Course", joinColumns = @JoinColumn(name ="studentId"),inverseJoinColumns = @JoinColumn(name ="courseId"))
    private List<Course> courses = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batchid")
    private Batch batch;
    
    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Teacher", joinColumns = @JoinColumn(name ="studentId"),inverseJoinColumns = @JoinColumn(name ="teacherId"))
    private List<Teacher> teachers = new ArrayList<>();
    
}



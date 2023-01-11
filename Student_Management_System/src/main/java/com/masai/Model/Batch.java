package com.masai.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.context.properties.bind.DefaultValue;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Batch {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int batchid;
//   @NotNull(message = "name cannot be null")
//   @NotEmpty(message = "name cannot be empty")
//   @NotBlank(message = "name cannot be blank")
   @Enumerated(EnumType.STRING)
   private BatchNameEnum batchname;
//   @NotNull(message = "numberofstudents cannot be null")
//   @NotEmpty(message = "numberofstudents cannot be empty")
//   @NotBlank(message = "numberofstudents cannot be blank")
//   @DefaultValue(value = 0)
   @Positive(message = "number of students should be in positive")
   private int numberofstudents;
   @NotNull(message = "startingDate cannot be null")
   @NotEmpty(message = "startingDate cannot be empty")
   @NotBlank(message = "startingDate cannot be blank")
   @JsonFormat(pattern = "dd-MM-yyyy")
   private LocalDate startingDate;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "courseId")
   private Course course;
   
   @OneToMany(cascade = CascadeType.ALL , mappedBy = "batch")
   private List<Student> students = new ArrayList<>();
   
   @ManyToMany(cascade = CascadeType.ALL , mappedBy = "batches")
   private List<Teacher> teachers = new ArrayList<>();
   
}

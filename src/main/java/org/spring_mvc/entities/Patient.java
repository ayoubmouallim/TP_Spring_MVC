package org.spring_mvc.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor  @AllArgsConstructor @ToString
public class Patient {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
	@NonNull
	@Size(min = 3, max = 15)
    private String name;
	@DecimalMin("3")
    private int score;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateNaissance;
    private boolean malade;
    
    
	
	
}

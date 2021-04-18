package org.spring_mvc.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data @NoArgsConstructor  @AllArgsConstructor @ToString
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
	
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	private String roles = "";

	
	private boolean active;
	
	public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
	

}

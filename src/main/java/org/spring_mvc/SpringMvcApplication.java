package org.spring_mvc;

import java.util.Date;

import org.spring_mvc.dao.PatientRepository;
import org.spring_mvc.dao.UserRepository;
import org.spring_mvc.entities.Patient;
import org.spring_mvc.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication

public class SpringMvcApplication implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;
	
	private UserRepository userRepository ;
	
	private PasswordEncoder passwordEncoder;
	
	public SpringMvcApplication(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		patientRepository.save(new Patient(null,"ayoub",30,new Date(),false));
		patientRepository.save(new Patient(null,"amine",50,new Date(),false));
		patientRepository.save(new Patient(null,"yassine",9,new Date(),true));
		patientRepository.save(new Patient(null,"Mohammed",33,new Date(),true));
		patientRepository.save(new Patient(null,"karim",91,new Date(),false));
		*/
		userRepository.deleteAll();
		
		userRepository.save(new User(null,"admin",passwordEncoder.encode("1234"),"ADMIN,USER",true));
		userRepository.save(new User(null,"user1",passwordEncoder.encode("1234"),"USER",true));
		userRepository.save(new User(null,"user2",passwordEncoder.encode("1234"),"USER",true));
		
		/*
		patientRepository.findAll().forEach(patient->{
			System.out.println(patient);
		});*/
		
	}

}

package org.spring_mvc.web;


import javax.validation.Valid;

import org.spring_mvc.dao.PatientRepository;
import org.spring_mvc.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class PatientContoller {
	
	@Autowired 
	private PatientRepository patientrepository;
	
@GetMapping(path="/index")
	public String index() {
		return "index";
		}

@GetMapping(path="/patients")
public String list(Model model,@RequestParam(name="page",defaultValue="0")int page,
		@RequestParam(name="size",defaultValue="5")int size,@RequestParam(name="keyword",defaultValue="")String mc) {
	Page<Patient> pagePatients = patientrepository.findByNameContains(mc,PageRequest.of(page, size));
	model.addAttribute("patients",pagePatients.getContent());
	
	model.addAttribute("pages",new int [pagePatients.getTotalPages()]);
	model.addAttribute("currentPage", page);
	model.addAttribute("keyword", mc);
	model.addAttribute("size", size);
	return "patients";
	}

@GetMapping(path="/deletePatient")
public String delete(Long id,String keyword,int page,int size) {
	
	patientrepository.deleteById(id);
	
	return "redirect:/patients?page="+page+"&size="+size+"&keyword="+keyword;
	} 

@GetMapping(path="/deletePatient2")
public String delete2(Long id,String keyword,int page,int size,Model model) {
	
	patientrepository.deleteById(id);
	
	return list(model,page,size,keyword);
	}

@GetMapping(path="/formPatient")
public String formPatient(Model model)
{
     model.addAttribute("patient", new Patient());
	
	return "formPatient";
}

@PostMapping("/savePatient")
public String savePatient(@Valid Patient patient,BindingResult bindingResult )
{
	if(bindingResult.hasErrors()) return "formPatient";
	
	patientrepository.save(patient);
	
	return "formPatient";
}
@GetMapping(path="/editPatient")
public String editPatient(Model model,Long id)
{
	 Patient p = patientrepository.findById(id).get();
     model.addAttribute("patient", p);
	
	return "editPatient";
}
	
@PostMapping("/updatePatient")
public String updatePatient(Model model,@Valid Patient patient,BindingResult bindingResult 
		,RedirectAttributes redirectAttributes)
{
	if(bindingResult.hasErrors()) return "editPatient";
	
	
	patientrepository.save(patient);
	//model.addAttribute("success", "patient modifier avec succées");
	redirectAttributes.addFlashAttribute("success", "patient modifier avec succées!");
	return "redirect:/patients";
}



}

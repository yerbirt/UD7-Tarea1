package eus.birt.dam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.University;
import eus.birt.dam.repository.UniversityRepository;

@RestController
@RequestMapping ("api/universities")
public class UniversityController {
	
	@Autowired
	UniversityRepository universityrepository;
	
	@GetMapping({"/", ""})
	public List <University> index() {
		return universityrepository.findAll();
	}
	
	@GetMapping("/")
	public University show(@PathVariable("id") Long id) {
		return universityrepository.findById(id).orElse(null);	
	}
	
	@PostMapping("/")
	@ResponseStatus (HttpStatus.CREATED)
	public University create(@RequestBody University university) {
		return universityrepository.save(university);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public University update(@RequestBody University university, @PathVariable("id") Long id) {
		University tempUniversity = universityrepository.findById(id).orElse(null);
		
		tempUniversity.setName(university.getName());
		tempUniversity.setCity(university.getCity());
		tempUniversity.setAddressLine1(university.getAddressLine1());
		tempUniversity.setAddressLine2(university.getAddressLine2());
		tempUniversity.setZipCode(university.getZipCode());
		//Al ser id diferente el método save hace en realidad un update
		return universityrepository.save(tempUniversity);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		universityrepository.deleteById(id);
	}
}

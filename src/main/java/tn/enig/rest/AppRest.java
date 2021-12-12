package tn.enig.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enig.dao.IEtudiantDao;
import tn.enig.model.Etudiant;

@RestController
@CrossOrigin("*")
public class AppRest {
	
	@Autowired
	IEtudiantDao dao;
	
	public void setDao(IEtudiantDao dao) {
		this.dao=dao;
	}
	
	@GetMapping("/etudiants")
	public List<Etudiant> get1(){
		return dao.findAll();
	}
	
	@PostMapping("/addEtudiant")
	public void add(@RequestBody Etudiant et) {
		dao.save(et);
	}
	
	@DeleteMapping("/deleteEtudiant/{id}")
	public void del (@PathVariable("id") int id) {
		dao.deleteById(id);
	}

}

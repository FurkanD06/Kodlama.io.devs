package kodlama.io.Kodlama.io.Devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService languageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService languageService) {
		
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/getbyid")
	public ProgrammingLanguage getById(int id) {
		return languageService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(ProgrammingLanguage programmingLanguage) throws Exception{
		 languageService.add(programmingLanguage);
	}
	
	@PostMapping("/delete")
	public void delete(ProgrammingLanguage programmingLanguage) {
		languageService.delete(programmingLanguage);
	}
	
	@PostMapping("/update")
	public void update(ProgrammingLanguage programmingLanguage) throws Exception{
		languageService.update(programmingLanguage);
	}
	
	
}

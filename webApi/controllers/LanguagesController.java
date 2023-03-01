package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.entities.concrete.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;

	}

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")

	public void create(@RequestBody Language language) {
		languageService.create(language);
	}

	@GetMapping("/listall")
	public List<Language> listall() {
		return languageService.listall();
	}

	@GetMapping("/getById/{id}")
	public Language getLanguageWithId(int id) {
		return languageService.getLanguageById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(int id) {
		languageService.delete(id);
	}

	@PutMapping("/update")
	public String update(int index, Language newLanguage) {
		languageService.update(index, newLanguage);
		return "Değiştirildi";
	}
}

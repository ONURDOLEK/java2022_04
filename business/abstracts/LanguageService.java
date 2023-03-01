package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concrete.Language;

public interface LanguageService {
	
	void create(Language language);

	void delete(int id);

	void update(int index, Language newLanguage);

	List<Language> listall();

	Language getLanguageById(int id);
	
	void languageEmpty(Language language);
	
    void languageRepeat(Language language);
}

package kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concrete.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> languages;

	public InMemoryLanguageRepository() {

		languages = new ArrayList<Language>();
		languages.add(new Language(0, "Java"));
		languages.add(new Language(1, "C#"));
		languages.add(new Language(2, "Python"));

	}

	@Override
	public void create(Language language) {
		languages.add(language);
	}

	@Override
	public void delete(int id) {
		languages.remove(id);
	}

	@Override
	public void update(int index, Language newLanguage) {
		
		//oldLanguage.setName(newLanguage.getName());
		//oldLanguage.setId(newLanguage.getId());
		
		
		
//		oldLanguage.setName(newLanguage.getName());
//		oldLanguage.setId(newLanguage.getId());
		
		if (newLanguage.getId()>languages.size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else {
		languages.set(index, newLanguage);
		}


	}

	@Override
	public List<Language> listall() {

		return languages;
	}

	@Override
	public Language getLanguageById(int id) {

		return languages.get(id);
	}

}

package kodlama.io.devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concrete.Language;

public interface LanguageRepository {

	void create(Language language);

	void delete(int id);

	void update(int index, Language newLanguage);

	List<Language> listall();

	Language getLanguageById(int id);

}

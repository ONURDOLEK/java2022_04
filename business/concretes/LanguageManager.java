package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concrete.Language;
@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public void create(Language language) {
		languageEmpty(language);
		languageRepeat(language);
		languageRepository.create(language);

	}

	@Override
	public void delete(int id) {
		languageRepository.delete(id);

	}

	@Override
	public void update(int index, Language newLanguage) {
		languageEmpty(newLanguage);
		languageRepository.update(index, newLanguage);
	}

	@Override
	public List<Language> listall() {
		return languageRepository.listall();
	}

	@Override
	public Language getLanguageById(int id) {
		return languageRepository.getLanguageById(id);
	}

	@Override
	public void languageEmpty(Language language) {
		if (language.getName().trim().isEmpty()) {
			try {
				throw new Exception("Dil ismi boş olamaz");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public void languageRepeat(Language language) {
		List<Language> languages = languageRepository.listall();
		for (Language lan : languages) {
			if (lan.getName().equalsIgnoreCase(language.getName())) {
				try {
					throw new Exception("Dil ismi tekrar edemez");
				} catch (Exception e) {
					throw new RuntimeException(e);
				}

			}
		}
	}
}

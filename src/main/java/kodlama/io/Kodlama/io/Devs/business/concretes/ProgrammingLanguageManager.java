package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	ProgrammingLanguageRepository languageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		// TODO Auto-generated method stub
		return languageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		// TODO Auto-generated method stub
		return languageRepository.getById(id);
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		for (ProgrammingLanguage pl : languageRepository.getAll()) {
			if (pl.getName().equals(programmingLanguage.getName())) {
				throw new Exception("Aynı isimden programlama dili eklenemez");
			}

		}

		if (programmingLanguage.getName() == null || programmingLanguage.getName().isEmpty()) {
			throw new Exception("Programlama dili ismi boş olamaz.");
		}
		languageRepository.add(programmingLanguage);

	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) {
		languageRepository.delete(programmingLanguage);

	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		for (ProgrammingLanguage pl : languageRepository.getAll()) {
			if (pl.getName().equals(programmingLanguage.getName())) {
				throw new Exception("Aynı isimden programlama dili eklenemez");
			}
		}

		if (programmingLanguage.getName() == null || programmingLanguage.getName().isEmpty()) {
			throw new Exception("Programlama dili ismi boş olamaz.");
		}
		languageRepository.update(programmingLanguage);

	}

}

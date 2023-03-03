package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguage implements ProgrammingLanguageRepository{
	
	List<ProgrammingLanguage> languages;
	
	
	public InMemoryProgrammingLanguage() {
		languages = new ArrayList<ProgrammingLanguage>();
		languages.add(new ProgrammingLanguage(1, "C#"));
		languages.add(new ProgrammingLanguage(2, "Java"));
		languages.add(new ProgrammingLanguage(3, "Python"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return languages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return languages.get(id);
		
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		languages.add(programmingLanguage);
		
	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) {
		 ProgrammingLanguage languageToDelete = null;
		    for (ProgrammingLanguage language : languages) {
		        if (language.getId() == programmingLanguage.getId()) {
		            languageToDelete = language;
		            break;
		        }
		    }
		    if (languageToDelete != null) {
		        languages.remove(languageToDelete);
		    }
		
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		ProgrammingLanguage existingLanguage  = languages.get(programmingLanguage.getId());
		existingLanguage.setName(programmingLanguage.getName());
	}

}

package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository languageRepository;
	private TechnologyRepository technologyRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository languageRepository,
			TechnologyRepository technologyRepository) {
		this.languageRepository = languageRepository;
		this.technologyRepository = technologyRepository;
	}

	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = languageRepository.findAll();
		List<GetAllProgrammingLanguageResponse> languageReponse = new ArrayList<GetAllProgrammingLanguageResponse>();

		Map<Integer, String> technologies;

		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			technologies = new HashMap<>();
			GetAllProgrammingLanguageResponse responseItem = new GetAllProgrammingLanguageResponse();
			responseItem.setId(programmingLanguage.getId());
			responseItem.setName(programmingLanguage.getName());

			for (Technology technology : technologyRepository.findAll()) {
				if (technology.getProgrammingLanguage() == programmingLanguage) {
					technologies.put(technology.getId(), technology.getName());
				}
			}

			responseItem.setTechnologies(technologies);
			languageReponse.add(responseItem);
		}

		return languageReponse;
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {
		return null;
		
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		List<ProgrammingLanguage> languages = languageRepository.findAll();

		boolean willBeAdded = !(createProgrammingLanguageRequest.getName().isEmpty());
		for (ProgrammingLanguage programmingLanguage : languages) {
			if (createProgrammingLanguageRequest.getClass().equals(programmingLanguage.getName())) {
				willBeAdded = false;
				break;
			}
		}

		if (willBeAdded) {
			ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
			programmingLanguage.setName(createProgrammingLanguageRequest.getName());
			languageRepository.save(programmingLanguage);
		}

	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		languageRepository.deleteById(deleteProgrammingLanguageRequest.getId());

	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
		List<ProgrammingLanguage> languages = languageRepository.findAll();

		boolean willBeAdded = !(updateProgrammingLanguageRequest.getName().isEmpty());
		for (ProgrammingLanguage programmingLanguage : languages) {
			if (updateProgrammingLanguageRequest.getClass().equals(programmingLanguage.getName())) {
				willBeAdded = false;
				break;
			}
		}

		if (willBeAdded) {
			ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
			programmingLanguage.setId(updateProgrammingLanguageRequest.getId());
			programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
			languageRepository.save(programmingLanguage);
		}

	}

}

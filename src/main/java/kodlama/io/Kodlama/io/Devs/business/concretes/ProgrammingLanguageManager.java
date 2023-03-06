package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
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
	public List<GetAllProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = languageRepository.findAll();
	 	List<GetAllProgrammingLanguageResponse> getAllProgrammingLanguageRequests = new ArrayList<GetAllProgrammingLanguageResponse>();
	 	for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
	 		GetAllProgrammingLanguageResponse responseItem = new GetAllProgrammingLanguageResponse();
	 		responseItem.setId(programmingLanguage.getId());
	 		responseItem.setName(programmingLanguage.getName());
	 		getAllProgrammingLanguageRequests.add(responseItem);
		}
	 	return getAllProgrammingLanguageRequests;
	 	
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {
		// TODO Auto-generated method stub
		return languageRepository.getById(id);
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		for (ProgrammingLanguage pl : languageRepository.findAll()) {
			if (pl.getName().equals(createProgrammingLanguageRequest.getName())) {
				throw new Exception("Aynı isimden programlama dili eklenemez");
			}

		}

		if (createProgrammingLanguageRequest.getName() == null || createProgrammingLanguageRequest.getName().isEmpty()) {
			throw new Exception("Programlama dili ismi boş olamaz.");
		}
		languageRepository.save(createProgrammingLanguageRequest);

	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		languageRepository.delete(deleteProgrammingLanguageRequest);

	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		for (ProgrammingLanguage pl : languageRepository.findAll()) {
			if (pl.getName().equals(updateProgrammingLanguageRequest.getName())) {
				throw new Exception("Aynı isimden programlama dili eklenemez");
			}
		}

		if (updateProgrammingLanguageRequest.getName() == null || updateProgrammingLanguageRequest.getName().isEmpty()) {
			throw new Exception("Programlama dili ismi boş olamaz.");
		}
		languageRepository.save(updateProgrammingLanguageRequest);

	}

}

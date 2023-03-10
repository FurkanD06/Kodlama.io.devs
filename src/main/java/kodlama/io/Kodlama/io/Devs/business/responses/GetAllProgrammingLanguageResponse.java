package kodlama.io.Kodlama.io.Devs.business.responses;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingLanguageResponse {
	private int id;
	private String name;
	private Map<Integer, String> technologies;
	
}

package design.structural.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria {

	public List<Person> meetCriteria(List<Person> persons) {
		
		List<Person> result = new ArrayList<Person>();
		
		for(Person person : persons) {
			
			if("Female".equals(person.getGender())) {
				
				result.add(person);
			}
		}
		return result;
	}
}

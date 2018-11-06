package design.structural.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaMale implements Criteria {

	public List<Person> meetCriteria(List<Person> persons) {
		
		List<Person> result = new ArrayList<Person>();
		
		for(Person person : persons) {
			
			if("Male".equals(person.getGender())) {
				
				result.add(person);
			}
		}
		return result;
	}
}

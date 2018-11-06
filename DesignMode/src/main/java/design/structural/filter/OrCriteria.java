package design.structural.filter;

import java.util.List;

public class OrCriteria implements Criteria {
	
	Criteria criteria;
	Criteria otherCriteria;

	public OrCriteria(Criteria criteria, Criteria otherCriteria) {
		super();
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	public List<Person> meetCriteria(List<Person> persons) {
		
		List<Person> result = criteria.meetCriteria(persons);
		List<Person> otherResult = otherCriteria.meetCriteria(persons);
		for (Person person : otherResult) {
			
			if(!result.contains(person)) {
				
				result.add(person);
			}
		}
		return result;
	}
}

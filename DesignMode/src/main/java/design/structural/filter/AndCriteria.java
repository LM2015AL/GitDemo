package design.structural.filter;

import java.util.List;

public class AndCriteria implements Criteria {
	
	Criteria criteria;
	Criteria otherCriteria;

	public AndCriteria(Criteria criteria, Criteria otherCriteria) {
		super();
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	public List<Person> meetCriteria(List<Person> persons) {
		
		List<Person> result = criteria.meetCriteria(persons);
		return otherCriteria.meetCriteria(result);
	}
}

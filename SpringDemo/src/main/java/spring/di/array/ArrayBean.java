package spring.di.array;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ArrayBean {

	private List list;
	private Set set;
	private Map map;
	private Properties properties;
	public void setList(List list) {
		this.list = list;
	}
	public void setSet(Set set) {
		this.set = set;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public List getList() {
		System.out.println("List = " + list );
		return list;
	}
	public Set getSet() {
		System.out.println("set = " + set );
		return set;
	}
	public Map getMap() {
		System.out.println("map = " + map );
		return map;
	}
	public Properties getProperties() {
		System.out.println("properties = " + properties );
		return properties;
	}
}

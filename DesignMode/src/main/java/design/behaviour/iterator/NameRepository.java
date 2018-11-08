package design.behaviour.iterator;

public class NameRepository implements Container {

	private String[] names = {"1", "2", "3", "4", "5"};
	
	public Iterator getIterator() {
		return new NameIterator();
	}
	
	private class NameIterator implements Iterator {

		private int index;
		public boolean hasNext() {
			if(this.index < names.length) {
				return true;
			}
			return false;
		}

		public Object next() {
			if(hasNext()) {
				return names[index++];
			}
			return null;
		}
	}
}

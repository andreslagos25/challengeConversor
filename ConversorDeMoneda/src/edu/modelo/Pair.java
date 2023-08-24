package edu.modelo;



class Pair <K, V>{
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		this.setKey(key);
		this.setValue(value);
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null || getClass() != obj.getClass())
			return false;
		Pair<?, ?> pair = (Pair<?, ?>) obj;
			return key.equals(pair.key) && value.equals(pair.value);
	}
	
	@Override
	public int hashCode() {
		return key.hashCode() ^ value.hashCode();
	}
}

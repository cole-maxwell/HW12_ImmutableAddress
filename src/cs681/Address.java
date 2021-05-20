package cs681;

public final class Address {

	private final String street, city, state;
	private final int zipcode;

	public Address(String street, String city, String state, int zipcode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public String getStreet() {	return street; }
	public String getCity() { return city; }
	public String getState() { return state; }
	public int getZipcode() { return zipcode; }

	public Address change(String street, String city, String state, int zipcode){
		return new Address(street, city, state, zipcode); }

	@Override
	public boolean equals(Object o) {
	
		if (o == this) { return true; }
		if (!(o instanceof Address)) { return false; }

		Address address = (Address) o;
		
		return	street == address.street &&
				city == address.city &&
				state == address.state &&
				Integer.compare(zipcode, address.zipcode) == 0;
	}
	@Override
	public String toString() {
		return String.format(street + ", " + city + ", "
								+ state + " " + zipcode);
	}
	
}

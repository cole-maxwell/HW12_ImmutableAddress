package cs681;

public class RunnableCustomer extends Customer implements Runnable {
	
	public RunnableCustomer(Address address) {
		super(address);
	}
	
	public void run() {
		getAddress().change(this.getAddress().getStreet(),
							this.getAddress().getCity(),
							this.getAddress().getState(),
							this.getAddress().getZipcode());
		setAddress(this.getAddress());
	}

	public static void main(String[] args) {

		RunnableCustomer cust1 = new RunnableCustomer(
			new Address ("Brookline", "Needham", "Massachusetts", 24156));
		RunnableCustomer cust2 = new RunnableCustomer(
			new Address ("Chauncy", "Cambridge", "Massachusetts", 26254));
		RunnableCustomer cust3 = new RunnableCustomer(
			new Address ("Commonwealth", "Allston", "Massachusetts", 19651));
		
		Thread t1 = new Thread(cust1);
		Thread t2 = new Thread(cust2);
		Thread t3 = new Thread(cust3);
		
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(cust1.getAddress() + "\n"
						+ cust2.getAddress() + "\n"
						+ cust3.getAddress() );
        
	}

}

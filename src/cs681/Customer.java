package cs681;
import java.util.concurrent.locks.*;

public class Customer {

	private static ReentrantLock lock = new ReentrantLock();

	private Address address;

	public Customer(Address addr) {
		address = addr;
	}
	public void setAddress(Address addr) {
		System.out.println("Setting lock in Customer.setAddress()...");
		lock.lock();
		try {
			address = addr; 
		} finally {
			System.out.println("Releasing lock in Customer.setAddress()...");
			lock.unlock();
		}
	}
	public Address getAddress() {
		System.out.println("Setting lock in Customer.getAddress()...");
		lock.lock();
		try {
			return address;
		} finally {
			System.out.println("Releasing lock in Customer.getAddress()...");
			lock.unlock();
		}
	}
}

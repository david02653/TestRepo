package ntou.cs.java.mask;

/**
 * JavaBean for Pharmacy data.
 *
 * @see ntou.cs.java.mask.MaskJsonHandler
 * @see ntou.cs.java.mask.MaskJsonHandlerTest
 *
 * @author me
 * @version 1.0.1
 */
public class Pharmacy {
	/**
	 * id - pharmacy id <br>
	 * name - pharmacy name <br>
	 * address - pharmacy address <br>
	 * phone - pharmacy phone number <br>
	 * numberOfAdultMasks - number of adult masks <br>
	 * numberOfChildrenMasks - number of adult masks <br>
	 * updatedTime - last updated time
	 */
	private String id;
	private String name;
	private String address;
	private String phone;
	private int numberOfAdultMasks;
	private int numberOfChildrenMasks;
	private String updatedTime;

	/**
	 * get pharmacy id
	 * @return pharmacy id
	 */
	public String getId() {
		return id;
	}

	/**
	 * set pharmacy id
	 * @param id pharmacy id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * get pharmacy name
	 * @return pharmacy name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set pharmacy name
	 * @param name pharamcy name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get pharmacy address
	 * @return pharmacy address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * set pharmacy address
	 * @param address pharmacy address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * get pharmacy phone number
	 * @return pharmacy phone number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * set pharmacy phone number
	 * @param phone pharmacy phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * get number of adult masks
	 * @return number of adult masks
	 */
	public int getNumberOfAdultMasks() {
		return numberOfAdultMasks;
	}

	/**
	 * set number of adult masks
	 * @param numberOfAdultMasks number of adult masks
	 */
	public void setNumberOfAdultMasks(int numberOfAdultMasks) {
		this.numberOfAdultMasks = numberOfAdultMasks;
	}

	/**
	 * get number of children masks
	 * @return number of children masks
	 */
	public int getNumberOfChildrenMasks() {
		return numberOfChildrenMasks;
	}

	/**
	 * set number of children masks
	 * @param numberOfChildrenMasks number of children masks
	 */
	public void setNumberOfChildrenMasks(int numberOfChildrenMasks) {
		this.numberOfChildrenMasks = numberOfChildrenMasks;
	}

	/**
	 * get last updated time
	 * @return last updated time
	 */
	public String getUpdatedTime() {
		return updatedTime;
	}

	/**
	 * set last updated time
	 * @param updatedTime last updated time
	 */
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	/**
	 * Override toString method from Object
	 * @return string of Pharmacy
	 */
	@Override
	public String toString() {
		return "Pharmacy:\nid=" + id + ""
				+ "\nname=" + name + "\naddress=" + address + "\nphone=" + phone
				+ "\nnumberOfAdultMasks=" + numberOfAdultMasks + "\nnumberOfChildrenMasks=" + numberOfChildrenMasks
				+ "\nupdatedTime=" + updatedTime;
	}

}

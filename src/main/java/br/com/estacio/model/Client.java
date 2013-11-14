package br.com.estacio.model;

/**
 * 
 * @author Efraim Gentil
 * @email efraim.gentil@gmail.com
 * @date Nov 6, 2013
 */
public class Client implements Cloneable{
	
	private Long id;
	
	private String name;
	
	private String phone;
	
	private String cellPhone;
	
	public Client() {	}
	
	public Client(Long id) {
		this.id = id;
	}
	
	public Client(String name, String phone, String cellPhone) {
		super();
		this.name = name;
		this.phone = phone;
		this.cellPhone = cellPhone;
	}
	
	@Override
	public Client clone() {
		try{
			return (Client) super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	public boolean isValid(){
		boolean valid = true;
		valid &= name != null && !name.trim().isEmpty();
		valid &= phone != null && !phone.trim().isEmpty() && phone.length() >= 8; 	
		return valid;
	}

}

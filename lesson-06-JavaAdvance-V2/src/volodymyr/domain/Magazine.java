package volodymyr.domain;

public class Magazine {

	private Integer id;
	private String magazineName;
	private Double magazinePrice;
	private Integer quantity;
	
	public Magazine(Integer id, String magazineName, Double magazinePrice, Integer quantity) {
		super();
		this.id = id;
		this.magazineName = magazineName;
		this.magazinePrice = magazinePrice;
		this.quantity = quantity;
	}

	public Magazine(String magazineName, Double magazinePrice, Integer quantity) {
		super();
		this.magazineName = magazineName;
		this.magazinePrice = magazinePrice;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMagazineName() {
		return magazineName;
	}

	public void setMagazineName(String magazineName) {
		this.magazineName = magazineName;
	}

	public Double getMagazinePrice() {
		return magazinePrice;
	}

	public void setMagazinePrice(Double magazinePrice) {
		this.magazinePrice = magazinePrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((magazineName == null) ? 0 : magazineName.hashCode());
		result = prime * result + ((magazinePrice == null) ? 0 : magazinePrice.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		Magazine other = (Magazine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (magazineName == null) {
			if (other.magazineName != null)
				return false;
		} else if (!magazineName.equals(other.magazineName))
			return false;
		if (magazinePrice == null) {
			if (other.magazinePrice != null)
				return false;
		} else if (!magazinePrice.equals(other.magazinePrice))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Magazine [id=" + id + ", magazineName=" + magazineName + ", magazinePrice=" + magazinePrice
				+ ", quantity=" + quantity + "]";
	}
	
}

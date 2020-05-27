package volodymyr.domain;

import java.util.Date;

public class Bucket {

	private Integer id;
	private Integer userId;
	private Integer magazineId;
	private Date date;
	
	public Bucket(Integer id, Integer userId, Integer magazineId, Date date) {
		this.id = id;
		this.userId = userId;
		this.magazineId = magazineId;
		this.date = date;
	}

	public Bucket(Integer userId, Integer magazineId, Date date) {
		super();
		this.userId = userId;
		this.magazineId = magazineId;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMagazineId() {
		return magazineId;
	}

	public void setMagazineId(Integer magazineId) {
		this.magazineId = magazineId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((magazineId == null) ? 0 : magazineId.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Bucket other = (Bucket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (magazineId == null) {
			if (other.magazineId != null)
				return false;
		} else if (!magazineId.equals(other.magazineId))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", userId=" + userId + ", magazineId=" + magazineId + ", date=" + date
				+ "]";
	}
	
}

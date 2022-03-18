package model.umpramuitos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "requests")
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private Date dateRequest;
	
	@OneToMany(mappedBy = "request")
	private List<ItemRequest> itensRequests;
	
	public Request() {
		this(new Date());
	}
	
	public Request(Date date) {
		this.dateRequest = date;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getDateRequest() {
		return dateRequest;
	}
	
	public void setDateRequest(Date date) {
		this.dateRequest = date;
	}

	public List<ItemRequest> getItensRequests() {
		return itensRequests;
	}

	public void setItensRequests(List<ItemRequest> itensRequests) {
		this.itensRequests = itensRequests;
	}
	
	

}

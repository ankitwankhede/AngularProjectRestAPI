package com.example.demo.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackid;

	@Column(name = "feedback_desc", length = 50)
	private String feedback_desc;

//	@ManyToOne
//	@JoinColumn(name = "userid")
//	private User user;

	// old serviceprovider connected
//	@ManyToOne
//	@JoinColumn(name = "service_providerid")
//	private ServiceProvider servicepro;

	@ManyToOne
	@JoinColumn(name = "orderid")
	private Order order;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Feedback(int feedbackid, String feedback_desc, User user, Order order) {
//		super();
//		this.feedbackid = feedbackid;
//		this.feedback_desc = feedback_desc;
//		this.user = user;
//		this.order = order;
//	}

	
//	public Feedback(String feedback_desc, User user, ServiceProvider servicepro) {
//		super();
//		this.feedback_desc = feedback_desc;
//		this.user = user;
//		this.servicepro = servicepro;
//	}

	public int getFeedbackid() {
		return feedbackid;
	}

	public Feedback(int feedbackid, String feedback_desc, Order order) {
	super();
	this.feedbackid = feedbackid;
	this.feedback_desc = feedback_desc;
	this.order = order;
}

	public String getFeedback_desc() {
		return feedback_desc;
	}

//	public User getUser() {
//		return user;
//	}

//	public ServiceProvider getServicepro() {
//		return servicepro;
//	}

	public void setFeedbackid(int feedbackid) {
		this.feedbackid = feedbackid;
	}

	public void setFeedback_desc(String feedback_desc) {
		this.feedback_desc = feedback_desc;
	}

//	public void setUser(User user) {
//		this.user = user;
//	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

//	public void setServicepro(ServiceProvider servicepro) {
//		this.servicepro = servicepro;
//	}

}

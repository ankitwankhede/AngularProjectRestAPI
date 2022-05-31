package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	public final static String getBookedService = "select o from Order o inner join o.user u where u.userid=?1";

	public final static String getOldOrder = "select o from Order o inner join o.user u where u.userid=?1 and o.order_date <curdate()";

	public final static String paymentUpdate = "update Order o set o.isPaid=true where o.orderid=?1";

	@Query(getBookedService)
	List<Order> findBookedOrderById(int id);

	@Query(getOldOrder)
	List<Order> getServedOrder(int id);

	@Modifying
	@Query(paymentUpdate)
	int changePayment(int id);

	// paras
	@Query("select o from Order o where o.order_date between ?1 and ?2")
	List<Order> findOrdersByDate(Date beginDate, Date endDate);

	//
	// priti
	public final static String viewbookedorders = "select o from Order o inner join o.servicepro s where s.serviceproviderid=?1 and o.order_date >= curdate()";

	@Query(viewbookedorders)
	List<Order> viewBookedServiceById(int id);

	public final static String viewhistory = "select o from Order o inner join o.servicepro s where s.serviceproviderid=?1 and o.order_date < curdate()";

	@Query(viewhistory)
	List<Order> viewHistoryById(int id);

}

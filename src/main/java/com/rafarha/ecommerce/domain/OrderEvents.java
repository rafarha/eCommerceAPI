package com.rafarha.ecommerce.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OrderEvents {

    private LocalDateTime dhEvent;

    private String eventDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_order_events", allocationSize = 1)
    private Integer id;

    @OneToOne
    private Order order;

    public LocalDateTime getDhEvent() {
	return dhEvent;
    }

    public String getEventDescription() {
	return eventDescription;
    }

    public Integer getId() {
	return id;
    }

    public Order getOrder() {
	return order;
    }

    public void setDhEvent(final LocalDateTime pDhEvent) {
	dhEvent = pDhEvent;
    }

    public void setEventDescription(final String pEventDescription) {
	eventDescription = pEventDescription;
    }

    public void setId(final Integer pId) {
	id = pId;
    }

    public void setOrder(final Order pOrder) {
	order = pOrder;
    }
}

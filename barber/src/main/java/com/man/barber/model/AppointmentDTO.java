package com.man.barber.model;

import java.util.Date;
import java.util.List;

import com.man.barber.entity.MsBarberShop;

public class AppointmentDTO {
	private Long id;
	private Date timeSelected;
	private Date dateSelected;
	private String status;
	private List<MsBarberShop> barbershopList;
	private Long customerId;
	private Long hairdresserSelectedId;
	
	public AppointmentDTO() {
	}
}

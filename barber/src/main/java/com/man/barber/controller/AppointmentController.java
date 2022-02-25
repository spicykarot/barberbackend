package com.man.barber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.man.barber.model.AppointmentModel;
import com.man.barber.model.BarberShopModel;
import com.man.barber.service.AppointmentService;
import com.man.barber.service.BarberShopService;

@RestController
@RequestMapping("/apiAppointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService ;
	
//	@RequestMapping(value = "/getAllBarberShop", method = RequestMethod.GET)
//	public @ResponseBody Page<BarberShopModel> getAllBarberShoptFilterWithPagingAndSearching(
//			@RequestParam(value = "name", required=false) String name,
//			@RequestParam(value = "address", required=false) String address, 
//            @RequestParam(defaultValue = "0") Integer pageNo,
//            @RequestParam(defaultValue = "10") Integer pageSize) {
//		return barberShopService.getAllBarberShopModelFilterWithPaggingAndSearching(name, address, pageNo, pageSize);
//	}
	
	@PostMapping("/addAppointment")
	public Boolean addAppointment(@RequestBody(required = true) AppointmentModel appointmentModel) {
		return appointmentService.addAppointment(appointmentModel);
	}
	
	@RequestMapping(value = "/updateAppointment", method = RequestMethod.PUT)
    public Boolean updateAppointment(@RequestBody(required = true) AppointmentModel barberShopModel) {
        return appointmentService.updateAppointment(barberShopModel);
    }

}

package com.man.barber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.man.barber.entity.MsBarberShop;
import com.man.barber.entity.MsUser;
import com.man.barber.entity.TrAppointment;
import com.man.barber.model.AppointmentModel;
import com.man.barber.model.UserModel;
import com.man.barber.repository.AppointmentRepository;
import com.man.barber.repository.BarberShopRepository;
import com.man.barber.repository.UserRepository;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private BarberShopRepository barberShopRepository;
	@Autowired
	private UserRepository userRepository;
	
	public List<TrAppointment> findUserAll() {
        return appointmentRepository.findAll();
    }

    public TrAppointment findUserById(long id) {
        return appointmentRepository.findById(id).get();
    }
    
//    public AppointmentModel findAppointmentmodelAllWithPaging() {
//		MsUser userTb = userRepository.getById(id);
//
//		UserModel userModel = new UserModel();
//		userModel.setId(userTb.getId());
//		userModel.setTitle(userTb.getTitle());
//		userModel.setFirstName(userTb.getFirstName());
//		userModel.setLastName(userTb.getLastName());
//		userModel.setEmail(userTb.getEmail());
//		userModel.setPassword(userTb.getPassword());
//		userModel.setTel(userTb.getTel());
//		userModel.setAddress(userTb.getAddress());
//		userModel.setUser_type(userTb.getUser_type());
//
//		return userModel;
//	}
    
    public Boolean addAppointment(AppointmentModel appointmentModel) {
		TrAppointment appointmentTb = new TrAppointment();
		Boolean result = false;
		try {
			MsBarberShop barberTb = barberShopRepository.getById(appointmentModel.getBarbershopId());
			MsUser customer = userRepository.getById(appointmentModel.getCustomerId());
			MsUser hairdresserSelected = userRepository.getById(appointmentModel.getHairdresserSelectedId());

			appointmentTb.setTimeSelected(appointmentModel.getTimeSelected());
			appointmentTb.setDateSelected(appointmentModel.getDateSelected());
			appointmentTb.setStatus(appointmentModel.getStatus());
			appointmentTb.setBarbershopId(barberTb);
			appointmentTb.setCustomerId(customer);
			appointmentTb.setHairdresserSelectedId(hairdresserSelected);

			appointmentTb = appointmentRepository.save(appointmentTb);

			if (appointmentTb != null) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Boolean updateAppointment(AppointmentModel appointmentModel) {
		Boolean result = false;
		try {
			TrAppointment appointmentTb = appointmentRepository.getById(appointmentModel.getId());
			if (appointmentTb != null) {
				if (!ObjectUtils.isEmpty(appointmentModel.getTimeSelected())) {
					appointmentTb.setTimeSelected(appointmentModel.getTimeSelected());
				}
				if (!ObjectUtils.isEmpty(appointmentModel.getDateSelected())) {
					appointmentTb.setDateSelected(appointmentModel.getDateSelected());
				}
				if (!ObjectUtils.isEmpty(appointmentModel.getStatus())) {
					appointmentTb.setStatus(appointmentModel.getStatus());
				}
				if (!ObjectUtils.isEmpty(appointmentModel.getBarbershopId())) {
					MsBarberShop barbershop = barberShopRepository.getById(appointmentModel.getBarbershopId());
					appointmentTb.setBarbershopId(barbershop);
				}
				if (!ObjectUtils.isEmpty(appointmentModel.getCustomerId())) {
					MsUser customer = userRepository.getById(appointmentModel.getCustomerId());
					appointmentTb.setCustomerId(customer);
				}
				if (!ObjectUtils.isEmpty(appointmentModel.getHairdresserSelectedId())) {
					MsUser hairdresser = userRepository.getById(appointmentModel.getHairdresserSelectedId());
					appointmentTb.setHairdresserSelectedId(hairdresser);
				}
				appointmentTb = appointmentRepository.save(appointmentTb);
				if (appointmentTb != null) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

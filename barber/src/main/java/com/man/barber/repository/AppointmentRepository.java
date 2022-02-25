package com.man.barber.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.man.barber.entity.MsBarberShop;
import com.man.barber.entity.MsUser;
import com.man.barber.entity.TrAppointment;
import com.man.barber.model.BarberShopModel;

public interface AppointmentRepository extends JpaRepository<TrAppointment,Long>{
	
	public List<TrAppointment> findAll();

	@Query("select a "
			+ "from TrAppointment a "
			+ "ORDER BY a.dateSelected DESC, a.timeSelected DESC, a.id ASC")
	Page<TrAppointment> findAllPaging(Pageable pageable);
}

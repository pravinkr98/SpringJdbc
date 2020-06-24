package com.ps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.bo.PersonDetailsBO;
import com.ps.dao.RailwayTicketReservationDAO;
import com.ps.dto.PersonDetailsDTO;

@Service("railwayService")
public class RailwayTicketMgmtServiceImpl implements RailwayTicketMgmtService {

	@Autowired
	private RailwayTicketReservationDAO dao;
	
	@Override
	public String groupReservationOfTicket(List<PersonDetailsDTO> listDTO) {
		List<PersonDetailsBO> listBO=new ArrayList();
		int result[]=null;
		//Keep dto object data to bo object
		listDTO.forEach(dto->{
			PersonDetailsBO bo=new PersonDetailsBO();
			BeanUtils.copyProperties(dto, bo);
			listBO.add(bo);
		});
		//use dao
		result=dao.groupReservationBatch(listBO);
		return result!=null?"Group Reservation succeded":"Group Reservation failed";
	}

}

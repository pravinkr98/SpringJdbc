package com.ps.service;

import java.util.List;

import com.ps.dto.PersonDetailsDTO;

public interface RailwayTicketMgmtService {

	public String groupReservationOfTicket(List<PersonDetailsDTO> listDTO);
}

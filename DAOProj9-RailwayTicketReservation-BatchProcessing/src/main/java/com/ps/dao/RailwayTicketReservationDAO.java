package com.ps.dao;

import java.util.List;

import com.ps.bo.PersonDetailsBO;

public interface RailwayTicketReservationDAO {

	public int[] groupReservationBatch(List<PersonDetailsBO> listBO);
}

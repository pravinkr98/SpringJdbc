package com.ps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.ps.bo.BankAccountBO;


@Repository("bankDAO")
public class BankAccountDAOImpl implements BankAccountDAO {
	private static final String GET_ACCOUNT_DETAILS_BY_ACNO="SELECT ACNO,HOLDERNAME,BALANCE FROM BANKACCOUNT WHERE ACNO=?";
	private static final String GET_ACCOUNT_DETAILS_BY_BALANCE_RANGE="SELECT ACNO,HOLDERNAME,BALANCE FROM BANKACCOUNT WHERE BALANCE>=? AND BALANCE<=?";
	private static final String UPDATE_BALANCE_BY_GIVEN_AMOUNT="UPDATE BANKACCOUNT SET BALANCE=BALANCE+ :amt WHERE BALANCE BETWEEN :start AND :end";
	private BankAccountSelector1 selector1;
	private BankAccountSelector2 selector2;
	private BankAccountUpdater1 updater1;
	
	@Autowired
	public BankAccountDAOImpl(DataSource ds) {
		System.out.println("BankAccountDAOImpl:: 1-param constructor");
		selector1=new BankAccountSelector1(ds,GET_ACCOUNT_DETAILS_BY_ACNO);
		selector2=new BankAccountSelector2(ds,GET_ACCOUNT_DETAILS_BY_BALANCE_RANGE);
		updater1=new BankAccountUpdater1(ds,UPDATE_BALANCE_BY_GIVEN_AMOUNT);
	}

	//--------------------------------------------method 1----------------------------------------------------
	@Override
	public BankAccountBO findAccountDetailsByAcno(long acno) {
		System.out.println("BankAccountDAOImpl.findAccountDetailsByAcno(-)");
		return selector1.findObject(acno);
	}
	
	//-----------------------------------------------method 2-------------------------------------------------	
	@Override
	public List<BankAccountBO> findAccountDetailByBalanceRange(double range1, double range2) {
		System.out.println("BankAccountDAOImpl.findAccountDetailByBalanceRange(-,-)");
		return selector2.execute(range1,range2);
	}
	
	//----------------------------------------------method 3--------------------------------------------------
	@Override
	public int updateBalanceByBalanceRange(double range1, double range2, double amount) {
		int count=0;
		Map<String,Object> paramMap=null;
		paramMap=new HashMap();
		paramMap.put("amt", amount);
		paramMap.put("start", range1);
		paramMap.put("end", range2);
		count=updater1.updateByNamedParam(paramMap);
		return count;
	}
	
	//============================inner class 1==================================
	
	private static class BankAccountSelector1 extends MappingSqlQuery<BankAccountBO>{
		
		public BankAccountSelector1(DataSource ds,String query) {
			super(ds,query);
			System.out.println("BankAccountDAOImpl.BankAccountSelector1:: 2-param constructor");
			super.declareParameter(new SqlParameter(Types.LONGNVARCHAR));
			super.compile();
		}
		
		@Override
		public BankAccountBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("BankAccountDAOImpl.BankAccountSelector1.mapRow(-,-)");
			BankAccountBO bo=null;
			bo=new BankAccountBO();
			bo.setAcno(rs.getLong(1));
			bo.setHolderName(rs.getString(2));
			bo.setBalance(rs.getDouble(3));			
			return bo;
		}		
	}//inner class

	//============================inner class 2===================================
	
	private static class BankAccountSelector2 extends MappingSqlQuery<BankAccountBO>{

		public BankAccountSelector2(DataSource ds, String query) {
			super(ds,query);
			System.out.println("BankAccountDAOImpl.BankAccountSelector2:: 2-param constructor");
			super.declareParameter(new SqlParameter(Types.DOUBLE));
			super.declareParameter(new SqlParameter(Types.DOUBLE));
			super.compile();
		}

		@Override
		public BankAccountBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BankAccountBO bo=null;
			bo=new BankAccountBO();
			bo.setAcno(rs.getLong(1));
			bo.setHolderName(rs.getString(2));
			bo.setBalance(rs.getDouble(3));			
			return bo;
		}		
	}//inner class

	//=============================inner class 3====================================
	
	private static class BankAccountUpdater1 extends SqlUpdate{

		public BankAccountUpdater1(DataSource ds, String query) {
			super(ds,query);
			System.out.println("BankAccountDAOImpl.BankAccountUpdater1:: 2-param constructor");
			super.declareParameter(new SqlParameter(Types.DOUBLE));
			super.declareParameter(new SqlParameter(Types.DOUBLE));
			super.declareParameter(new SqlParameter(Types.DOUBLE));
			super.compile();
		}
		
	}//inner class
	

}//class

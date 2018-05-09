package com.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jdbc.JdbcUtils;
import org.apache.log4j.Logger;  

public class ProductDao implements ProductService{
	public static Logger logger = Logger.getLogger(ProductDao.class);   
	private JdbcUtils jdbcUtils;
	
	public ProductDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	
	@Override
	public boolean addProduct(List<Object> params) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			jdbcUtils.getConnection();
			String sql = "insert into product(proid,proname,proprice,proaddress,proimage) values(?,?,?,?,?)";
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
			// 关闭数据库连接
			jdbcUtils.releaseConn();
			
		}
		return flag;
	}

	@Override
	public List<Map<String, Object>> listProduct(String proname, int start, int end) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		List<Object> params  = new ArrayList<Object>();
		try {
			jdbcUtils.getConnection();	
			String sql = "select * from product where 1=1 and proname like ? limit ? ,?";
			if(proname.equals("")){
				sql = "select * from product limit ? ,?";
				params.add(start);
				params.add(end);
				
			}else{				
				params.add("%"+proname+"%");
				params.add(start);
				params.add(end);
			}	
			 
			list = jdbcUtils.findMoreResult(sql, params);
			logger.debug(sql);  
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			
			
			jdbcUtils.releaseConn();
			
		}
		return list;
	}

	@Override
	public int getItemCount(String proname) {
		// TODO Auto-generated method stub
		int count = 0;
		Map<String, Object> map = null;
		List<Object> params = null;	
		try {
			jdbcUtils.getConnection();	
			String sql = "select count(*) totalCount from product where 1=1 and proname like ?";
			if(proname.equals("")){
				sql = "select count(*) totalCount from product";
				
			}else{
				params = new ArrayList<Object>();
				params.add("%"+proname+"%");
			}
			map = jdbcUtils.findSimpleResult(sql, params);
			count = Integer.parseInt(map.get("totalCount").toString());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			// 关闭数据库连接
			jdbcUtils.releaseConn();
		}
		return count;
	}

	@Override
	public boolean delProduct(String[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> viewProduct(String proid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = null;
		try {
			jdbcUtils.getConnection();
			List<Object> params = new ArrayList<Object>();
			params.add(proid);
			String sql = "select * from product where proid = ?";
			map = jdbcUtils.findSimpleResult(sql, params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			// 关闭数据库连接
			jdbcUtils.releaseConn();
		}
		return map;
	}

}

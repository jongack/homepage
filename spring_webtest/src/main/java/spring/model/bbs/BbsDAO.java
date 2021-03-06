package spring.model.bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.db.webtest.DBClose;
import spring.db.webtest.DBOpen;

@Repository
public class BbsDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	
	
	public boolean checkRefnum(int bbsno) {
		boolean flag =false;
		int cnt = mybatis.selectOne("bbs.checkRefnum", bbsno);
		if(cnt>0) {
			flag = true;
		}
		return flag;
	}
	public boolean replyCreate(BbsDTO dto) {
		boolean flag = false;
		
		int cnt = mybatis.insert("bbs.replyCreate", dto);
		if(cnt>0) {
			flag = true;
		}
		
		return flag;
	}
	
	
	public void upAnsnum(Map map){
		mybatis.update("bbs.upAnsnum", map);
		
		
	}
	public BbsDTO replyRead(int bbsno) {
		BbsDTO dto = mybatis.selectOne("bbs.replyRead", bbsno);
		
		
		
		return dto;
	}
	
	
	public boolean create(BbsDTO dto) {
		boolean flag =false;
				
		int cnt=	mybatis.insert("bbs.create", dto);
		if(cnt>0) {
			flag = true;
		}
		return flag;
	}

	public int total(Map map) {
		int total= mybatis.selectOne("bbs.total", map);
		
		return total;
	}
	
	public List<BbsDTO> list(Map map) {
		
		List<BbsDTO> list = mybatis.selectList("bbs.list", map);

		return list;
	}

	public BbsDTO read(int bbsno) {
		BbsDTO dto = mybatis.selectOne("bbs.read", bbsno);

		return dto;
	}

	public void upViewcnt(int bbsno) {
		mybatis.update("bbs.upViewcnt", bbsno);

	}

	public boolean update(BbsDTO dto) {
		boolean flag = false;
		
		int cnt = mybatis.update("bbs.update", dto);
		if(cnt>0) {
			flag = true;
		}
		return flag;
	}

	public boolean passCheck(Map map) {
		boolean flag = false;
		
		int cnt = mybatis.selectOne("bbs.passwdCheck",map);
		if(cnt>0) {
			flag = true;
		}

		return flag;
	}

	public boolean delete(int bbsno) {
		boolean flag = false;
		
		int cnt = mybatis.delete("bbs.delete", bbsno);
		if(cnt>0) {
			flag = true;
		}
		return flag;
	}
}

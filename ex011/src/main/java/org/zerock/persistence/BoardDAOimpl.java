package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;


@Repository
public class BoardDAOimpl implements BoardDAO {

	@Autowired
	private SqlSession session;
	
	private static String namespace = "org.zerock.mapper.BoardMapper";
	
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace+".create",vo);

	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		
		
		
		return session.selectOne(namespace+".countPaging",cri);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		
		return session.selectOne(namespace+".read",bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace+".update", vo);

	}

	@Override
	public void delete(int bno) throws Exception {
		session.delete(namespace+".delete",bno);

	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		
		if(page <= 0){
			page = 1;
		}
		
		page = (page -1)*10+1;
		int limit = page+9;
		HashMap<String, Integer> map = new HashMap<>();
		map.put("page", page);
		map.put("limit", limit);
		
		return session.selectList(namespace+".listPage",map);
		
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		
		return session.selectList(namespace+".listCriteria", cri);
		
	}
	
	
	
}

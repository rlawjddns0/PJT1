package com.xy.service;

import java.util.List;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy.entity.Follow;
import com.xy.repository.FollowRepository;

@Service
public class FollowServiceImpl implements FollowService{
	
	@Autowired
	FollowRepository followRepo;
	@PersistenceContext
    EntityManager em;

	@Override
	public Follow save(Follow follow) {
		
		
		
		return followRepo.save(follow);
	}

	@Override
	public List<Follow> getMemberId(long id) {
		
		//follower_id== id 인 경우
		
		
		//자신을 팔로우 하는 사람들
		String jpql="select distinct f from Follow as f where f.follower_id=:id";
		TypedQuery<Follow> query=em.createQuery(jpql,Follow.class);
		query.setParameter("id", id);

		return query.getResultList();
	}
	
	@Override
	public List<Follow> amIFollowed(long id) {
		String jpql="select distinct f from Follow as f where f.follow_id=:id";
		TypedQuery<Follow> query=em.createQuery(jpql, Follow.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public int unFollow(long memberid, long followid) {
		String jpql="delete from Follow m where m.member_id=:memberid and m.follower_id=:followid";
		Query query = em.createQuery(jpql).setParameter("memberid", memberid).setParameter("followid", followid);
		int rows = query.executeUpdate();
		return rows;
	}
	
	
	
	

}

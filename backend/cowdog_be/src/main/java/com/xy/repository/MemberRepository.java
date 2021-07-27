package com.xy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xy.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	boolean existsBymemberid(String id);
	Member getBymemberid(String id);

}

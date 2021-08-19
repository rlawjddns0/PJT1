package com.xy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xy.entity.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
	
}

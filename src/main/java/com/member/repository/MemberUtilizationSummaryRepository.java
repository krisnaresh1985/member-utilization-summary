package com.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.member.model.MemberUtilizationSummary;

public interface MemberUtilizationSummaryRepository extends JpaRepository<MemberUtilizationSummary, Integer> {
    List<MemberUtilizationSummary> findByUid(String uid);
}

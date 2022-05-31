package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojos.Feedback;

public interface FeedbackRespository extends JpaRepository<Feedback, Integer> {

	
	
}

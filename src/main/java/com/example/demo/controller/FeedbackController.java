package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.Feedback;
import com.example.demo.service.FeedbackService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class FeedbackController {
	@Autowired
	FeedbackService feedback;

//-----------------allFeedback-----------------------------------
	@GetMapping("/getfeedback")
	public List<Feedback> allfeedback() {
		return feedback.getfeedback();
	}

//-----------------getfeedbackbyid-----------------------------------
	@GetMapping("/getfeedbackbyid")
	public Feedback getfeedbackbyid(@RequestParam("feedbackid") int id) {
		return feedback.getfeedbackbyid(id);
	}

	// ----------------------------RegisterFeedback----------------------
	@PostMapping("/registerfeedback")
	public boolean registerfeedback(@RequestBody Feedback f) {
		return feedback.registerfeedback(f);
	}

	// ----------------------------UpdateFeedback----------------------
	@PutMapping("/updatefeedback")
	public boolean updatefeedback(Feedback f) {
		return feedback.registerfeedback(f);
	}
}

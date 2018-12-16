package com.cts.ba.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {
	
	@Id
	@Column(name = "subjectId", unique = true, nullable = false)
	private long subjectId;
	
	@Column
	private String subtitle;
	
	@Column
	private int durationInHours;
	
    @ManyToOne
    @JoinColumn(name="bookId", nullable=true)
    private Book bookDetails;
    
    



	public Book getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(Book bookDetails) {
		this.bookDetails = bookDetails;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Subject Id is:\t" + subjectId + "\t");
		sb.append("Subject Title :\t" + subtitle + "\t");
		sb.append("Subject Duration (Hours) :\t" + durationInHours + "\n");
		return sb.toString();
	}
	
}

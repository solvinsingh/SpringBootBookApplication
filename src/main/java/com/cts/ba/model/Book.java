package com.cts.ba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Entity
@Table(name = "book")
public class Book implements Serializable {

	@Id
	@Column(name = "bookId", unique = true, nullable = false)
	private long bookId;

	@Column
	private String title;

	@Column
	private double price;

	@Column
	private int volume;

	@Column
	private String publishDate;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "bookDetails")
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private Set<Subject> subject = new HashSet<>();

	public Set<Subject> getSubject() {
		return subject;
	}

	public void setSubject(Set<Subject> subject) {
		this.subject = subject;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getPublishDate() {
		if (publishDate != null) {
			return publishDate.toString();
		} else {
			return null;
		}
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Book Id is:\t" + bookId + "\n");
		sb.append("Book Title :\t" + title + "\n");
		sb.append("Book Volume :\t" + volume + "\n");
		sb.append("Book Price :\t" + price + "\n");
		sb.append("Publish Date :\t" + publishDate + "\n");
		sb.append("Subject Details ::\n");
		if (subject != null) {
			for (Subject object : subject) {
				sb.append(object + "\n");
			}
		}
		return sb.toString();
	}

}

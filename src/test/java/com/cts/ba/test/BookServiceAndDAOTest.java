package com.cts.ba.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.cts.ba.model.Book;
import com.cts.ba.model.Subject;
import com.cts.ba.repository.BookDAO;
import com.cts.ba.repository.SubjectDAO;
import com.cts.ba.service.CrudUtilService;



@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "/test-context.xml" })
public class BookServiceAndDAOTest {

	private SubjectDAO mockSubjectDAOImpl;

	private BookDAO mockBookDao;

	CrudUtilService mockUtilService;

	@Before
	public void initMocks() {
		mockSubjectDAOImpl = Mockito.mock(SubjectDAO.class);
		mockBookDao = Mockito.mock(BookDAO.class);
		mockUtilService = Mockito.mock(CrudUtilService.class);

		ReflectionTestUtils.setField(mockUtilService, "bookDao", mockBookDao);
		ReflectionTestUtils.setField(mockUtilService, "subjectDAOImpl", mockSubjectDAOImpl);

	}

	@Test
	public void testAddSubject() {
		Subject subject = new Subject();
		subject.setSubjectId(100);
		subject.setSubtitle("Testing Subject");
		try {
			mockUtilService.addSubject(subject);
		} catch (Exception ex) {
			fail("Test Case failed while adding the Subject");
		}
	}

	@Test
	public void testUpdateSubject() {
		Subject subject = new Subject();
		subject.setSubjectId(100);
		subject.setSubtitle("Testing Subject");
		try {
			mockUtilService.updateSubject(subject);
		} catch (Exception ex) {
			fail("Test Case failed while updating the Subject");
		}
	}
	
	@Test
	public void testDeleteSubject() {
		Subject subject = new Subject();
		subject.setSubjectId(100);
		subject.setSubtitle("Testing Subject");
		try {
			when(mockUtilService.deleteSubject(Mockito.anyLong())).thenReturn("The Subject has been deleted");
			String result = mockUtilService.deleteSubject(100);
			assertEquals(result, "The Subject has been deleted");
		} catch (Exception ex) {
			fail("Test Case failed while deleting the Subject");
		}
	}
	
	@Test
	public void testAddBook() {
		Book book = new Book();
		book.setBookId(100);
		book.setTitle("Testing Book");
		try {
			mockUtilService.addBook(book);
		} catch (Exception ex) {
			fail("Test Case failed while adding the Book");
		}
	}

	@Test
	public void testUpdateBook() {
		Book book = new Book();
		book.setBookId(100);
		book.setTitle("Testing Book");
		try {
			mockUtilService.updateBook(book);
		} catch (Exception ex) {
			fail("Test Case failed while updating the Book");
		}
	}
	
	@Test
	public void testDeleteBook() {
		Book book = new Book();
		book.setBookId(100);
		book.setTitle("Testing Book");
		try {
			when(mockUtilService.deleteBook(Mockito.anyLong())).thenReturn("The Book has been deleted");
			String result = mockUtilService.deleteBook(100);
			assertEquals(result, "The Book has been deleted");
		} catch (Exception ex) {
			fail("Test Case failed while deleting the Book");
		}
	}
	
	@Test
	public void testFindByTitleDAO() {
		List<Book> bookList = new ArrayList();
		when(mockBookDao.findByTitle(Mockito.anyString())).thenReturn(bookList);
		assertNotNull(mockBookDao.findByTitle("Test Book"));	
	}
	
	@Test
	public void testFindByDurationInHoursDAO() {
		List<Subject> subjectList = new ArrayList();
		when(mockSubjectDAOImpl.findByDurationInHours(Mockito.anyInt())).thenReturn(subjectList);
		assertNotNull(mockSubjectDAOImpl.findByDurationInHours(100));	
	}	
}

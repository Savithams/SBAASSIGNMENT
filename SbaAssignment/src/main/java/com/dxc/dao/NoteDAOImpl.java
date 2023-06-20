package com.dxc.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxc.exception.*;
import com.dxc.model.*;

import jakarta.transaction.Transactional;


@Repository
@Transactional
public class NoteDAOImpl implements NoteDAO {

	
	@Autowired
	SessionFactory sessionFactory;

	public NoteDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	

	public boolean createNote(Note note) {
		getSession().save(note);
		return Boolean.TRUE;
	}



	public boolean deleteNote(int noteId) {
		try {
			getSession().delete(getNoteById(noteId));
		} catch (NoteNotFoundException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	

	

	

	public Note getNoteById(int noteId) throws NoteNotFoundException {
		Note note=getSession().get(Note.class, noteId);
		if(note ==null) {
			throw new NoteNotFoundException("Note not found for: "+noteId);
		}
		return note;
	}

	
	public boolean UpdateNote(Note note) {
		getSession().update(note);
		return Boolean.TRUE;
	}

	@Override
	public List<Note> getAllNotesByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

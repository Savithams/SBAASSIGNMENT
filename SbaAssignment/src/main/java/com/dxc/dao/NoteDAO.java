package com.dxc.dao;

import java.util.List;

import com.dxc.exception.*;
import com.dxc.model.*;

public interface NoteDAO {

	

	public boolean createNote(Note note);

	public boolean deleteNote(int noteId);

	public List<Note> getAllNotesByUserId(String userId);

	public Note getNoteById(int noteId) throws NoteNotFoundException;

	public boolean UpdateNote(Note note);

}

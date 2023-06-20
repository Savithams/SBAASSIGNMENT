package com.dxc.model;

import java.util.Date;




import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="NOTE")
public class Note {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "note_id")
	private int noteId;

	@NotNull
	@Column(name = "note_title")
	private String noteTitle;

	@Column(name = "note_content")
	private String noteContent;

	@Column(name = "note_status")
	private String noteStatus;

	@Column(name = "note_creation_date")
	private Date noteCreatedAt;

	@Column(name = "created_by")
	private String createdBy;

	public Note(int noteId, String noteTitle, String noteContent, String noteStatus, Date noteCreatedAt,
			String createdBy) {
		super();
		this.noteId = noteId;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.noteStatus = noteStatus;
		this.noteCreatedAt = noteCreatedAt;
		this.createdBy = createdBy;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public String getNoteStatus() {
		return noteStatus;
	}

	public void setNoteStatus(String noteStatus) {
		this.noteStatus = noteStatus;
	}

	public Date getNoteCreatedAt() {
		return noteCreatedAt;
	}

	public void setNoteCreatedAt(Date noteCreatedAt) {
		this.noteCreatedAt = noteCreatedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	

}
	
	
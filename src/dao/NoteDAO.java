package dao;

import java.util.List;

import model.Note;

public interface NoteDAO extends Dao {

	List<Note> getLastNotes();

}

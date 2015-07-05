package dao;

import java.util.List;

import persistence.PersistenceNote;
import model.Note;

public interface NoteDAO extends Dao {

	List<Note> getLastNotes();

	List<PersistenceNote> getPersistenceCustomerList();

}

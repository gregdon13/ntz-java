package rocks.zipcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
class NotezTest {
    Notez notez =  new Notez();
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @Test
    public void addToCategoryTest() {
        //Given
        String general = "General";
        String note = "go to store";

        //When
        notez.addToCategory(general, note);

        //Then
        assertTrue(notez.filemap.get(general).size() == 1);
    }

    @Test
    public void removeNote() {
        //Given
        String todo = "ToDo";
        String note = "go to store";
        int indexToRemoveish = 1;

        //When
        notez.addToCategory(todo, note);
        notez.removeNote(todo, indexToRemoveish);

        //Then
        assertTrue(notez.filemap.get(todo).size() == 0);
    }

    @Test
    public void updateNote() {
        //Given
        String todo = "ToDo";
        String note = "go to store";
        String note2 = "buy stuff";
        String newNote = "buy milk";
        int editIndex = 2;

        //When
        notez.addToCategory(todo, note);
        notez.addToCategory(todo, note2);
        notez.editNote(todo, editIndex, newNote);

        //Then
        String expected = "buy milk";
        String actual = notez.filemap.get(todo).get(1);

        assertEquals(expected, actual);
    }

}

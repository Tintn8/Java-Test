import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

public class NumberImplementerTest {

    private NumberImplementer impl = new NumberImplementer();

    @Test
    public void testCollect() {
        String input = "1, 2, 3, 4, a, b, 5, 6, 7, 8, c, d, 9, 10";
        Collection<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Collection<Integer> actual = impl.collect(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testSummarizeCollection() {
        Collection<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        String expected = "1-10";
        String actual = impl.summarizeCollection(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testSummarizeCollectionWithSingleNumber() {
        Collection<Integer> input = Arrays.asList(1);
        String expected = "1";
        String actual = impl.summarizeCollection(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testSummarizeCollectionWithMultipleGroups() {
        Collection<Integer> input = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 10);
        String expected = "1-3, 5-8, 10";
        String actual = impl.summarizeCollection(input);
        assertEquals(expected, actual);
    }
}
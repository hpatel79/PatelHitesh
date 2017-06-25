package hitesh.sky.service;

import hitesh.sky.exception.CallbackMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Comparator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by Hitesh on 25/06/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class ParentalControlServiceTest {


    @Mock
    private CallbackMessage callbackMessage;
    @Mock
    private MovieService movieService;
    @Mock
    private Comparator<String> levelComparator;

    private ParentalControlService service;


    @Test
    public void testIsAccessibleMovie_lowerTahnUserPrerence_shouldNotAllowWathing() throws Exception {

        //Set up
        service = new ParentalControlService(movieService, levelComparator);

        when(movieService.getParentalControlLevel("movie id")).thenReturn("PG");
        when(levelComparator.compare("PG","12")).thenReturn(-1);

        boolean result = service.isAccessibleMovie("12", "movie id", callbackMessage);

        // Verify Behaviour
        assertThat(result, is(true));
        verifyZeroInteractions(callbackMessage);
    }

    @Test
    public void testComparePrefereedLevel() throws Exception {

    }
}
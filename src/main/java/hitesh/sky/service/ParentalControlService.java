package hitesh.sky.service;

import hitesh.sky.exception.CallbackMessage;
import hitesh.sky.exception.TechnicalFailureException;
import hitesh.sky.exception.TitleNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;

/**
 * Created by Hitesh on 25/06/2017.
 */
@Service
public class ParentalControlService {


    private MovieService movieService;
    private final Comparator levelComparator;


    public ParentalControlService(MovieService movieService, Comparator levelComparator) {
        this.movieService = movieService;
        this.levelComparator = levelComparator;
    }

    public boolean isAccessibleMovie(String preferredLevel, String movieId, CallbackMessage callback) {
        try {
            String movieParentalControlLevel = movieService.getParentalControlLevel(movieId);
            return comparePrefereedLevel(preferredLevel, movieParentalControlLevel);
        } catch (TitleNotFoundException | TechnicalFailureException e){
            callback.showMessage(e.getMessage());
            return false;
        }
    }


    public boolean comparePrefereedLevel(String preferredLevel, String movieParentalControlLevel) {
        return levelComparator.compare(movieParentalControlLevel,preferredLevel) <=0;
    }


}

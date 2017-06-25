package hitesh.sky.service;

import hitesh.sky.exception.TechnicalFailureException;
import hitesh.sky.exception.TitleNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MovieService{


    public String getParentalControlLevel(String movieId)
                        throws TitleNotFoundException,
                                TechnicalFailureException {

        switch (movieId){
            case "1":
                    return "18";
            case "2":
                    return "12";
           case "3":
                throw new TechnicalFailureException("Sorry, we have experience a technical failure.");
            default:
                throw new TitleNotFoundException("Sorry, we could not find the movie you are looking for.");
        }
    }
}

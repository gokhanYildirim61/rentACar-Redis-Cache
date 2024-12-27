package myProject.rentACar.core.utilites;

//import org.modelmapper.ModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


public interface ModelMapperService {

    ModelMapper forResponse();
    ModelMapper forRequest();
}

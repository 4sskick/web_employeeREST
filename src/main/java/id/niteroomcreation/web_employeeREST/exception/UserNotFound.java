package id.niteroomcreation.web_employeeREST.exception;

/**
 * Created by monta on 06/07/21
 * please make sure to use credit when you're using people's code
 */
public class UserNotFound extends RuntimeException {

    public UserNotFound(String msg) {
        super(msg);
    }
}

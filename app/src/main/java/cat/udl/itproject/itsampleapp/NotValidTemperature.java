package cat.udl.itproject.itsampleapp;

class NotValidTemperatureException extends RuntimeException {

    public NotValidTemperatureException(String message) {
        super(message);
    }
}

package br.com.forcaVendas.cliente.remote;

/**
 *
 * @author André
 */
public class ClienteException extends Exception{

    public ClienteException(Throwable cause) {
        super(cause);
    }

    public ClienteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClienteException(String message) {
        super(message);
    }

    public ClienteException() {
        super();
    }

}

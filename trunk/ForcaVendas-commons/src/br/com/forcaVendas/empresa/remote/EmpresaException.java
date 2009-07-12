package br.com.forcaVendas.empresa.remote;

/**
 *
 * @author Henrique
 */
public class EmpresaException extends Exception{

    public EmpresaException(Throwable cause) {
        super(cause);
    }

    public EmpresaException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmpresaException(String message) {
        super(message);
    }

    public EmpresaException() {
        super();
    }

}

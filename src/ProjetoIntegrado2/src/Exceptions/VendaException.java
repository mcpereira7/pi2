/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Exceptions;

/**
 *
 * @author aayan
 */
public class VendaException extends Exception {

    public VendaException(String message, Throwable cause) {
        super(message, cause);
    }

    public VendaException(String message) {
        super(message);
    }

}

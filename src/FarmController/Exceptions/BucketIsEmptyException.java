package FarmController.Exceptions;

import static View.View.PlayErrorSound;

public class BucketIsEmptyException extends Exception {
    public BucketIsEmptyException(){
        PlayErrorSound();
    }
}

package meowpay.restcontroller.meow;

import meowpay.restcontroller.credential.Credential;

public class RequestWrapper {
    private Credential credential;
    private Meow meow;

    public RequestWrapper() {
    }

    public RequestWrapper(Credential credential, Meow meow) {
        this.credential = credential;
        this.meow = meow;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public Meow getMeow() {
        return meow;
    }

    public void setMeow(Meow meow) {
        this.meow = meow;
    }
}

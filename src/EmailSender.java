public class EmailSender {
    private final String email;

    public EmailSender(String email) {
        this.email = email;
    }

    public void sendConfirmationEmail() {
        System.out.println("Отправка комерческого предложения поставщику на: " + email);
    }
}

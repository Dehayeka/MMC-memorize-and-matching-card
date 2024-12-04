import javax.swing.Timer;

public class GameLogic {
    private Card firstCard = null;
    private Card secondCard = null;

    public void cardClicked(Card card) {
        if (firstCard == null) {
            firstCard = card;
            firstCard.flip();
        } else if (secondCard == null && card != firstCard) {
            secondCard = card;
            secondCard.flip();
            checkMatch();
        }
    }

    private void checkMatch() {
        if (firstCard.getFrontImage().equals(secondCard.getFrontImage())) {
            // Cards match; disable further clicks
            firstCard.setEnabled(false);
            secondCard.setEnabled(false);
            resetCards();
        } else {
            // No match; flip back after delay
            Timer timer = new Timer(1000, e -> {
                firstCard.flip();
                secondCard.flip();
                resetCards();
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void resetCards() {
        firstCard = null;
        secondCard = null;
    }
}

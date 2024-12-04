import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Card[] cards;
    private GameLogic gameLogic;

    public GamePanel() {
        setLayout(new GridLayout(4, 4)); // Default grid 4x4
        gameLogic = new GameLogic();

        loadCards();
        shuffleAndAddCards();
    }

    private void loadCards() {
        ImageIcon[] images = AssetLoader.loadImages();
        int pairCount = images.length; // Sesuaikan jumlah pasangan dengan panjang array images
        cards = new Card[pairCount * 2]; // Total kartu = 2 x jumlah pasangan
    
        for (int i = 0; i < pairCount; i++) {
            cards[i] = new Card(images[i], gameLogic);
            cards[i + pairCount] = new Card(images[i], gameLogic); // Pasangan kartu
        }
    }
    

    private void shuffleAndAddCards() {
        java.util.List<Card> cardList = java.util.Arrays.asList(cards);
        java.util.Collections.shuffle(cardList);
        cardList.toArray(cards);

        for (Card card : cards) {
            add(card);
        }
    }
}

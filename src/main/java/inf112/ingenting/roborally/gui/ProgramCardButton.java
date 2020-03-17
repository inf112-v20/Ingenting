package inf112.ingenting.roborally.gui;

import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import inf112.ingenting.roborally.cards.ProgrammingCard;

class ProgrammingCardButton extends ImageTextButton {

    private ProgrammingCard card;

    ProgrammingCardButton(ProgrammingCard card) {
        super("", card.getStyle());
        this.card = card;
        Label label = getLabel();
        label.setText(card.getPriority() + "");
        label.setFontScale(2.7f);
        setLabel(label);
        getCell(label).padRight(160).padBottom(250);
    }

    public void dispose() {
        card.dispose();
    }

}

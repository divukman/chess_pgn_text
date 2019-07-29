package chess;

import com.github.bhlangonijr.chesslib.game.Game;
import com.github.bhlangonijr.chesslib.pgn.PgnHolder;

public class Main {

    public static void main(String args[]) throws Exception {
        int numOfGames = 1;

        if (args.length < 1) {
            throw new RuntimeException("Missing file path.");
        }

        System.out.println();

        PgnHolder pgn = new PgnHolder(args[0]);
        pgn.loadPgn();
        for (Game game: pgn.getGame()) {

            final String strWhitePlayerName = game.getWhitePlayer().getName();
            final String strBlackPlayerName = game.getBlackPlayer().getName();

            final String strEvent = game.getRound().getEvent().getName();
            final String strEventDate = game.getDate();
            final String strAnnotator = game.getAnnotator();
            final String strResult = game.getResult().getDescription();
            final String strFEN = game.getFen();


            System.out.println("####################################################################################");
            System.out.println(String.format("Broj: %d  %s - %s, %s %s [%s]", numOfGames, strWhitePlayerName, strBlackPlayerName, strEvent, strEventDate, strAnnotator));
            System.out.println("-----------------");
            System.out.println(String.format("FEN: %s", strFEN));
            System.out.println("-----------------");
            System.out.println(strResult);
            System.out.println("-----------------");
            System.out.println("Analiza:");
            System.out.println("-----------------");
            System.out.println("Nastavak:");

            System.out.println();

            ++numOfGames;
        }
    }

}

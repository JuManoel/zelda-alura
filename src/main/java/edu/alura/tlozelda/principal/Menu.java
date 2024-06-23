package edu.alura.tlozelda.principal;

import edu.alura.tlozelda.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.alura.tlozelda.models.*;

public class Menu {
    private final String[] URL = {
            "https://zelda.fanapis.com/api/games", // jogos de zelda
            "https://zelda.fanapis.com/api/places", //// lugares de zelda
            "https://zelda.fanapis.com/api/items", // items de zelda
            "https://zelda.fanapis.com/api/characters"// personagens de zelda
    };
    private String json;

    private ConsumoAPI api = new ConsumoAPI();
    private IConvertirDatos converter = new ConvierteDatos();
    private Scanner scn = new Scanner(System.in);
    private List<ZeldaCharacter> personagens = new ArrayList<ZeldaCharacter>();
    private List<Item> items = new ArrayList<Item>();
    private List<Place> places = new ArrayList<>();
    private List<ZeldaGame> games = new ArrayList<>();

    private String[] format(String json) {
        String[] split = json.split("]");
        json = split[0];
        String[] split2 = json.split("\\[");
        json = split2[1];
        System.out.println(json);
        String[] split3 = json.split("},");
        for (int i = 0; i < split3.length - 1; i++) {
            split3[i] = split3[i] + "}";
        }
        return split3;
    }

    private void load() {
        List<DataZeldaGame> dataGames = new ArrayList<>();
        List<DataCharacter> dataCharacter = new ArrayList<>();
        List<DataItem> dataItem = new ArrayList<>();
        List<DataPlaces> dataPlaces = new ArrayList<>();
        /*
         * "https://zelda.fanapis.com/api/games",//jogos de zelda
         * "https://zelda.fanapis.com/api/places",////lugares de zelda
         * "https://zelda.fanapis.com/api/items",//items de zelda
         * "https://zelda.fanapis.com/api/characters"//personagens de zelda
         */
        for (int i = 0; i < URL.length; i++) {
            this.json = api.obtenerDatos(URL[i]);
            String[] jsons = format(this.json);
            switch (i) {
                case 0:
                    for (String string : jsons) {
                        dataGames.add(converter.obterDados(string, DataZeldaGame.class));
                        games.add(new ZeldaGame(dataGames.get(dataGames.size() - 1)));
                    }
                    break;
                case 1:
                    for (String string : jsons) {
                        dataPlaces.add(converter.obterDados(string, DataPlaces.class));
                        places.add(new Place(dataPlaces.get(dataPlaces.size() - 1)));
                    }
                    break;
                case 2:
                    for (String string : jsons) {
                        dataItem.add(converter.obterDados(string, DataItem.class));
                        items.add(new Item(dataItem.get(dataItem.size() - 1)));
                    }
                    break;
                case 3:
                    for (String string : jsons) {
                        dataCharacter.add(converter.obterDados(string, DataCharacter.class));
                        personagens.add(new ZeldaCharacter(dataCharacter.get(dataCharacter.size() - 1)));
                    }
                    break;
                default:
                    break;
            }

        }

    }

    public void run() {
        load();
    }
}

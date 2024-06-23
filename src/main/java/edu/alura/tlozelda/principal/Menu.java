package edu.alura.tlozelda.principal;

import edu.alura.tlozelda.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;

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
    private void load() {
        /*
         * "https://zelda.fanapis.com/api/games",//jogos de zelda
         * "https://zelda.fanapis.com/api/places",////lugares de zelda
         * "https://zelda.fanapis.com/api/items",//items de zelda
         * "https://zelda.fanapis.com/api/characters"//personagens de zelda
         */
        for (int i = 0; i < URL.length; i++) {
            this.json = api.obtenerDatos(URL[i]);
            switch (i) {
                case 0:
                    ResponseApi<DataZeldaGame> rGames = converter.obterDados(this.json,
                            new TypeReference<ResponseApi<DataZeldaGame>>() {
                            });
                    for (DataZeldaGame game : rGames.data()) {
                        this.games.add(new ZeldaGame(game));
                    }
                    break;
                case 1:
                    ResponseApi<DataPlaces> rPlaces = converter.obterDados(this.json,
                            new TypeReference<ResponseApi<DataPlaces>>() {
                            });
                    for (DataPlaces place : rPlaces.data()) {
                        this.places.add(new Place(place));
                    }
                    break;
                case 2:
                    ResponseApi<DataItem> rItems = converter.obterDados(this.json,
                            new TypeReference<ResponseApi<DataItem>>() {
                            });
                    for (DataItem item : rItems.data()) {
                        this.items.add(new Item(item));
                    }
                    break;
                case 3:
                    ResponseApi<DataCharacter> rPerso = converter.obterDados(this.json,
                            new TypeReference<ResponseApi<DataCharacter>>() {
                            });
                    for (DataCharacter pers : rPerso.data()) {
                        this.personagens.add(new ZeldaCharacter(pers));
                    }
                    break;
                default:
                    break;
            }

        }

    }

    public void run() {
        load();
        System.out.println("Que deseas buscar sobre los juegos de Zelda?");
        String menu = """
                1. Juegos de Zelda     3. Personagens de Zelda
                2. Lugares de Zelda    4. Items de los juegos de Zelda
                """;
        System.out.println(menu);
        scn = new Scanner(System.in);
        int opcion = scn.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Ingrese un nombre");
                scn = new Scanner(System.in);
                String nombre = scn.nextLine();
                juegosDeZelda(nombre);
                break;

            default:
                break;
        }
    }

    public void juegosDeZelda(String nombre) {
        System.out.println("ok?");
    }
}

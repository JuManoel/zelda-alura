package edu.alura.tlozelda.principal;

import edu.alura.tlozelda.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
        String resp;
        do {
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
                    juegosDeZelda();
                    break;
                case 2:
                    lugaresDeZelda();
                    break;
                case 3:
                    personagensDeZelda();
                    break;
                case 4:
                    itemsDeZelda();
                    break;
                default:
                    System.out.println("Esa opcion no existe");
                    break;
            }
            System.out.println("Deseas seguir buscando?");
            scn = new Scanner(System.in);
            resp = scn.nextLine();
        } while (resp.toLowerCase().startsWith("s"));
        scn.close();
    }

    public void juegosDeZelda() {
        String s = """
                Que deseas hacer?
                1. Buscar por nombre del juego
                2. Buscar por fecha de lanzamiento
                3. Ver lista en orden de lanzamiento
                """;
        System.out.println(s);
        scn = new Scanner(System.in);
        int opcion = scn.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Ingrese un nombre");
                scn = new Scanner(System.in);
                String nombre = scn.nextLine();
                Optional<ZeldaGame> game = this.games.stream()
                        .filter(g -> g.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                        .findFirst();
                if (game.isPresent())
                    System.out.println(game.get());
                else
                    System.out.println("Jeugo no encontrado");
                break;
            case 2:
                System.out.println("Ingrese el año");
                scn = new Scanner(System.in);
                int ano = scn.nextInt();
                LocalDate fechaBusqueda1 = LocalDate.of(ano, 1, 1);
                LocalDate fechabusqueda2 = LocalDate.of(ano + 1, 1, 1);
                this.games.parallelStream()
                        .filter(g -> g.getDataLanz().isAfter(fechaBusqueda1))
                        .filter(g -> g.getDataLanz().isBefore(fechabusqueda2))
                        .forEach(System.out::println);
                break;
            case 3:
                this.games.stream()
                        .sorted(Comparator.comparing(ZeldaGame::getDataLanz))
                        .forEach(System.out::println);
                break;
            default:
                System.out.println("Esa opcion no existe");
                break;

        }
    }

    public void lugaresDeZelda() {
        String s = """
                Que deseas hacer?
                1. Buscar por nombre
                2. Listar Lugares
                """;
        System.out.println(s);
        scn = new Scanner(System.in);
        int opcion = scn.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el nombre el item");
                scn = new Scanner(System.in);
                String nombre = scn.nextLine();
                Optional<Place> place = this.places.stream()
                        .filter(p -> p.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                        .findFirst();
                if (place.isPresent())
                    System.out.println(place.get());
                else
                    System.out.println("Lugar no encuentrado");
                break;
            case 2:
                this.places.parallelStream()
                        .forEach(System.out::println);
                break;

        }
    }

    public void itemsDeZelda() {
        String s = """
                Que deseas hacer?
                1. Buscar por nombre del item
                2. Listar todos los items
                """;
        System.out.println(s);
        scn = new Scanner(System.in);
        int opcion = scn.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el nombre el item");
                scn = new Scanner(System.in);
                String nombre = scn.nextLine();
                Optional<Item> item = this.items.stream()
                        .filter(i -> i.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                        .findFirst();
                if (item.isPresent())
                    System.out.println(item.get());
                else
                    System.out.println("Item no encontrado");
                break;
            case 2:
                this.items.parallelStream()
                        .forEach(System.out::println);
                break;
            default:
                System.out.println("Esa opcion no existe");
                break;
        }
    }

    public void personagensDeZelda() {
        String s = """
                Que deseas hacer?
                1. Buscar por nombre    4. Listar por Raca
                2. Buscar por raca      5. listar por Genero
                3. Buscar por genero    6. Listar todos
                """;
        System.out.println(s);
        scn = new Scanner(System.in);
        int opcion = scn.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("ingrese el nombre del personagen");
                scn = new Scanner(System.in);
                String nombre = scn.nextLine();
                Optional<ZeldaCharacter> perso = this.personagens.stream()
                        .filter(p -> p.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                        .findFirst();
                if (perso.isPresent())
                    System.out.println(perso.get());
                else
                    System.out.println("No encuentrado");

                break;
            case 2:
                System.out.println("Ingre la raca que de deseas buscar");
                scn = new Scanner(System.in);
                String raca = scn.nextLine();
                this.personagens.stream()
                        .filter(p -> p.getRaca()!=null)
                        .filter(p -> p.getRaca().toLowerCase().contains(raca.toLowerCase()))
                        .forEach(System.out::println);
                break;
            case 3:
                System.out.println("Ingrese el genero que buscas");
                scn = new Scanner(System.in);
                String genero = scn.nextLine();
                this.personagens.parallelStream()
                        .filter(p -> p.getGenero()!=null)
                        .filter(p -> p.getGenero().toLowerCase().contains(genero.toLowerCase()))
                        .forEach(System.out::println);
                break;
            case 4:
                this.personagens.stream()
                        .filter(p -> p.getRaca()!=null)
                        .sorted(Comparator.comparing(ZeldaCharacter::getRaca))
                        .forEach(System.out::println);
                break;
            case 5:
                this.personagens.stream()
                        .filter(p -> p.getGenero()!=null)
                        .sorted(Comparator.comparing(ZeldaCharacter::getGenero))
                        .forEach(System.out::println);
                break;
            case 6:
                this.personagens.parallelStream()
                        .forEach(System.out::println);
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
    }
}

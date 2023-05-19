public class Main {
    public static void main(String[] args) {
        VideogameDatabase database = new VideogameDatabase();

        // Agregar videojuegos a la base de datos
        database.addVideogame(new Videogame("Super Mario Odyssey", "Aventura", 59.99));
        database.addVideogame(new Videogame("The Legend of Zelda: Breath of the Wild", "Aventura", 69.99));
        database.addVideogame(new Videogame("Resident Evil Village", "Terror", 49.99));
        database.addVideogame(new Videogame("FIFA 22", "Deportes", 49.99));
        database.addVideogame(new Videogame("Call of Duty: Warzone", "Acción", 0.0));

        // Obtener todos los títulos de los videojuegos
        List<String> allTitles = database.getAllTitles();
        System.out.println("Todos los títulos:");
        System.out.println(allTitles);

        // Obtener los títulos de los videojuegos con precio superior a 20€
        List<String> titlesAbove20 = database.getTitlesWithPriceAbove(20.0);
        System.out.println("\nTítulos con precio superior a 20€:");
        System.out.println(titlesAbove20);

        // Obtener los títulos de los videojuegos de categoría "Terror"
        List<String> titlesInCategory = database.getTitlesWithCategory("Terror");
        System.out.println("\nTítulos de la categoría \"Terror\":");
        System.out.println(titlesInCategory);

        // Obtener los títulos de los videojuegos con precio superior a 20€ ordenados ascendentemente por precio
        List<String> titlesAbove20SortedAsc = database.getTitlesWithPriceAboveSortedByPriceAsc(20.0);
        System.out.println("\nTítulos con precio superior a 20€ ordenados ascendente por precio:");
        System.out.println(titlesAbove20SortedAsc);

        // Obtener los títulos de los videojuegos con precio superior a 20€ ordenados descendentemente por precio
        List<String> titlesAbove20SortedDesc = database.getTitlesWithPriceAboveSortedByPriceDesc(20.0);
        System.out.println("\nTítulos con precio superior a 20€ ordenados descendente por precio:");
        System.out.println(titlesAbove20SortedDesc);

        // Obtener el número de videojuegos agrupados por categoría
        Map<String, Long> videogameCountByCategory = database.getVideogameCountByCategory();
        System.out.println("\nNúmero de videojuegos por categoría:");
        System.out.println(videogameCountByCategory);

        // Obtener la suma de los precios de los videojuegos agrupados por categoría
        Map<String, Double> priceSumByCategory = database.getPriceSumByCategory();
        System.out.println("\nSuma de precios de los videojuegos por categoría:");
        System.out.println(priceSumByCategory);

        // Obtener la suma de los precios de los videojuegos agrupados por categoría, siempre que la suma sea superior a 200€
        Map<String, Double> priceSumAbove200ByCategory = database.getPriceSumByCategoryAboveThreshold(200.0);
        System.out.println("\nSuma de precios de los videojuegos por categoría (superior a 200€):");
        System.out.println(priceSumAbove200ByCategory);
    }
}
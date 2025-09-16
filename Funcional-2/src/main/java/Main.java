import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[]args){
        List<Producto> productos = new ArrayList<>();

        Producto p1 =new Producto("Monitor","Tecnologia",500.00,50);
        Producto p2 =new Producto("Teclado","Tecnologia",125.50,100);
        Producto p3 =new Producto("Remera","Ropa",50.00,200);
        Producto p4 =new Producto("Pantalon","Ropa",75.50,60);
        Producto p5 =new Producto("Pizza","Comida",25.00,90);

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);

        List<Producto> porPrecio = productos.stream()
                .filter(a->a.getPrecio()>100)
                .sorted((a1, a2) -> Double.compare(a2.getPrecio(), p1.getPrecio()))
                .collect(Collectors.toList());

        for(Producto p : porPrecio){System.out.println(p);}

        Map<String, Integer> stockPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)
                ));

        System.out.println(stockPorCategoria);

        String nombrePrecio = productos.stream()
                .map(p -> p.getNombre() + " $" + p.getPrecio())
                .collect(Collectors.joining("; "));

        System.out.println(nombrePrecio);

        double promedio = productos.stream()
                .collect(Collectors.averagingDouble(Producto::getPrecio));

        System.out.println("Promedio general: " + promedio);

        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));
        System.out.println("Promedio por categoria:");
        System.out.println(promedioPorCategoria);

    }
}

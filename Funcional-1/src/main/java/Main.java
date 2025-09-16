import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Alumno> alumnos = Arrays.asList(
                new Alumno("Enzo", 5.5, "Matematica"),
                new Alumno("Jeronimo", 7.0, "Programacion"),
                new Alumno("Luca", 9.5, "Matematica"),
                new Alumno("Gabriel", 5.0, "Programacion"),
                new Alumno("Tiziano", 8.0, "Matematica")
        );

        List<String> aprobados = alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Aprobados: " + aprobados);

        double promedio = alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0.0);

        System.out.println("Promedio: " + promedio);

        Map<String, List<Alumno>> porCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));

        System.out.println("Por curso: " + porCurso);

        List<Alumno> top3 = alumnos.stream()
                .sorted((a1, a2) -> Double.compare(a2.getNota(), a1.getNota()))
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Top 3: " + top3);
    }
}